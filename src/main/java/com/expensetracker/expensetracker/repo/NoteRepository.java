package com.expensetracker.expensetracker.repo;

import com.expensetracker.expensetracker.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
