package www.maxinhai.com.diary.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 日记
 */
@Data
@Document(collection = "d_diary")
public class Diary extends BaseEntity{

    @Id
    private UUID id;

    private String content;

    private List<Label> labelList = new ArrayList<>();

}
