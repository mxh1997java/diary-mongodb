package www.maxinhai.com.diary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import www.maxinhai.com.diary.domain.Label;
import java.util.UUID;

@Repository
public interface LabelRepository extends MongoRepository<Label, UUID> {

}
