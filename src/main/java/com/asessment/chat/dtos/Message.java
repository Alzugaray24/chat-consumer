package com.asessment.chat.dtos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    private String id;

    private LocalDateTime shippingDate;
    private String text;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}