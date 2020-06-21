package www.maxinhai.com.diary.command.add;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;
import www.maxinhai.com.diary.domain.Label;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AddDiaryCommand  extends AbstractCommand {

    @Setter
    @Getter
    private String content;

    @Setter
    @Getter
    private List<Label> labelList = new ArrayList<>();

    @Setter
    @Getter
    private Date createTime;

    @Setter
    @Getter
    private String author;

    @Setter
    @Getter
    private UUID authorId;

}
