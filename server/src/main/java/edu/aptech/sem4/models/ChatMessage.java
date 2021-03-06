package edu.aptech.sem4.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChatMessage {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private String image;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private ChatTopic topic;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDateTime createdAt;

    private Boolean isSystem = false;
}
