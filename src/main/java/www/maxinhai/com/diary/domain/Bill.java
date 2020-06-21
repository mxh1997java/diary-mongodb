package www.maxinhai.com.diary.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

/**
 * 账单
 */
@Data
@Document(collection = "d_bill")
public class Bill extends BaseEntity {

    private UUID id;

    /**
     * 标签
     */
    private String label;

    private String labelId;

    /**
     * 消费金额
     */
    private Double amount;

}
