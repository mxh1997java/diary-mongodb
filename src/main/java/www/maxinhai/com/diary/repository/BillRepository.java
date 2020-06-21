package www.maxinhai.com.diary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import www.maxinhai.com.diary.domain.Bill;
import java.util.UUID;

@Repository
public interface BillRepository extends MongoRepository<Bill, UUID> {

}
