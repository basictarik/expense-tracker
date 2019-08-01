package com.expensetracker.expensetracker.repo;

import com.expensetracker.expensetracker.model.NotificationType;
import com.expensetracker.expensetracker.model.NotificationTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationType, Long> {
    Optional<NotificationType> findBynotificationTypeName(NotificationTypeName notificationTypeName);
}
