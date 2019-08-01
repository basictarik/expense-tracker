package com.expensetracker.expensetracker.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "notification_type")
@Entity
public class NotificationType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private NotificationTypeName notificationTypeName;
}
