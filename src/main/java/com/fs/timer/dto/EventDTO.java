package com.fs.timer.dto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
public class EventDTO {
    private EventType eventType;
    private int distance;
    private String unit;
    private Long time; // in seconds
    private LocalDateTime createdAt;
}
