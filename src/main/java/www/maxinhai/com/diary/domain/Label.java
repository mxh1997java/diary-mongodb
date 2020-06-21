package www.maxinhai.com.diary.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

/**
 * 标签
 */
@Data
@Document(collection = "d_label")
public class Label extends BaseEntity {

    private UUID id;

    /**
     * 状态
     */
    private Integer state;
}
