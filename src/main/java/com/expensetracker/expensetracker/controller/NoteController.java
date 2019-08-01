package com.expensetracker.expensetracker.controller;

import com.expensetracker.expensetracker.model.Note;
import com.expensetracker.expensetracker.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/expenses")
@Slf4j
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping(value = "{id}/notes")
    @ResponseStatus(HttpStatus.OK)
    public Note createNote(@RequestBody Note note, @PathVariable Long id) {
        Note createdNote = noteService.addNote(note, id);
        log.info("note: " + note);
        return createdNote;
    }
}
