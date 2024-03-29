package com.expensetracker.expensetracker.dto;

import com.expensetracker.expensetracker.model.NotificationTypeName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class NoteDTO {
    @NotBlank
    @Size(max = 255)
    private String notificationText;

    @NotBlank
    private NotificationTypeName notificationType;

    @NotBlank
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private LocalDateTime reminderDate;
}
