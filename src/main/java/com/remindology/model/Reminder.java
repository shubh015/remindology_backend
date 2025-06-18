package com.remindology.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID userId;
    private String title;
    private LocalDateTime remindAt;
    private String description;
    private String category;
    private String intent;

    private boolean isDone = false;
    private LocalDateTime createdAt = LocalDateTime.now();
}
