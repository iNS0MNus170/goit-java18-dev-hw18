package global.goit.goitjava18devhw18.controller;


import global.goit.goitjava18devhw18.entity.Note;
import global.goit.goitjava18devhw18.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
        Note createdNote = noteService.add(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }

    @GetMapping
    public List<Note> listNotes() {
        return noteService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable long id) {
        Note note = noteService.getById(id);
        return ResponseEntity.ok(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable long id, @Valid @RequestBody Note note) {
        note.setId(id);
        Note updatedNote = noteService.update(note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable long id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
