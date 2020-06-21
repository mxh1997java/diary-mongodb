package www.maxinhai.com.diary.command.add;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

public class AddNoteCommand  extends AbstractCommand {

    @Setter
    @Getter
    private String content;

}
