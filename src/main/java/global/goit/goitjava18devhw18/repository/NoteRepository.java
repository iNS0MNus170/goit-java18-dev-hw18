package global.goit.goitjava18devhw18.repository;

import global.goit.goitjava18devhw18.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
