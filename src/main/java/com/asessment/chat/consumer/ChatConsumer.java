package com.asessment.chat.consumer;

import com.asessment.chat.dtos.User;
import com.asessment.chat.services.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ChatConsumer {

    private  final UserService userService;

    public ChatConsumer(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "chat_queue")
    public void receiveMessage(User user) {
        System.out.println("Received message: " + user);
        userService.saveUser(user);
    }
}
