package www.maxinhai.com.diary.command.change;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

import java.util.UUID;

public class ModifyNoteCommand  extends AbstractCommand {

    @Setter
    @Getter
    private UUID id;

    @Setter
    @Getter
    private String content;

}
