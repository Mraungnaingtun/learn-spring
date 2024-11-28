package com.trainSpringBoot.logant.QueryByExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Endpoint to search notes
    @GetMapping("/search")
    public List<Note> searchNotes(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String category) {
        return noteService.searchNotes(title, content, category);
    }

    // Endpoint to save a note
    @PostMapping
    public Note saveNote(@RequestBody Note note) {
        return noteService.saveNote(note.getTitle(), note.getContent(), note.getCategory());
    }
}
