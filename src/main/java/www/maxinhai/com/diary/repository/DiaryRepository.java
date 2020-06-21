package www.maxinhai.com.diary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import www.maxinhai.com.diary.domain.Diary;
import java.util.UUID;

@Repository
public interface DiaryRepository extends MongoRepository<Diary, UUID> {

}
