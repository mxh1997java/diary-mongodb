package www.maxinhai.com.diary.command.change;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

import java.util.UUID;

public class ModifyLabelCommand extends AbstractCommand {

    @Setter
    @Getter
    private UUID id;

}
