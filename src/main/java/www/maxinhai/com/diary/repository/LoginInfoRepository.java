package www.maxinhai.com.diary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import www.maxinhai.com.diary.domain.LoginInfo;
import java.util.UUID;

@Repository
public interface LoginInfoRepository extends MongoRepository<LoginInfo, UUID> {



}
