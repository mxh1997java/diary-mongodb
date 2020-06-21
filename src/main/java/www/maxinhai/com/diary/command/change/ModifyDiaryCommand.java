package www.maxinhai.com.diary.command.change;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;
import www.maxinhai.com.diary.domain.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ModifyDiaryCommand  extends AbstractCommand {

    @Setter
    @Getter
    private UUID id;

    @Setter
    @Getter
    private String content;

    @Setter
    @Getter
    private List<Label> labelList = new ArrayList<>();

}
