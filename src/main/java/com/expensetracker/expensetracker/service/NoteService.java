package com.expensetracker.expensetracker.service;

import com.expensetracker.expensetracker.exception.AppException;
import com.expensetracker.expensetracker.exception.NotFoundException;
import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.model.Note;
import com.expensetracker.expensetracker.model.NotificationType;
import com.expensetracker.expensetracker.model.NotificationTypeName;
import com.expensetracker.expensetracker.repo.ExpenseRepository;
import com.expensetracker.expensetracker.repo.NoteRepository;
import com.expensetracker.expensetracker.repo.NotificationTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    public Note addNote(Note note, Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() ->
                new NotFoundException("Expense with id " + expenseId + " not found"));

        NotificationType notificationType;
        notificationType = notificationTypeRepository.findBynotificationTypeName(NotificationTypeName.REMINDER)
                .orElseThrow(() -> new AppException("Notification Type not set. Please add default Types"));
        if (note.getReminderDate() == null) {
            notificationType = notificationTypeRepository.findBynotificationTypeName(NotificationTypeName.NOTIFICATION)
                    .orElseThrow(() -> new AppException("Notification Type not set. Please add default Types"));
        }
        note.setExpense(expense);
        note.setNotificationTypes(Collections.singleton(notificationType));
        log.info("note: " + note);
        noteRepository.save(note);
        return note;
    }

}
