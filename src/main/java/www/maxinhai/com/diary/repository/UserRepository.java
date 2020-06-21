package www.maxinhai.com.diary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import www.maxinhai.com.diary.domain.User;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    User findByUsername(String username);

}
