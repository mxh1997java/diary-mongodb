package www.maxinhai.com.diary.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Data
@Document(collection = "d_note")
public class Note extends BaseEntity {

    private UUID id;

    /**
     * 内容
     */
    private String content;

}
