package www.maxinhai.com.diary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import www.maxinhai.com.diary.domain.Diary;
import www.maxinhai.com.diary.domain.Note;

import java.util.UUID;

@Repository
public interface NoteRepository extends MongoRepository<Note, UUID> {

}
