package com.trainSpringBoot.logant.QueryByExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // Search notes by title, content, category
    public List<Note> searchNotes(String title, String content, String category) {
        Note probe = new Note();
        probe.setTitle(title);
        probe.setContent(content);
        probe.setCategory(category);

        // Create an ExampleMatcher to specify case-insensitive matching and 'contains' match for strings
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()  // Case-insensitive matching
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);  // 'Contains' match

        Example<Note> example = Example.of(probe, matcher);

        return noteRepository.findAll(example);
    }

    // Save a new note
    public Note saveNote(String title, String content, String category) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setCategory(category);
        note.setCreatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }
}

