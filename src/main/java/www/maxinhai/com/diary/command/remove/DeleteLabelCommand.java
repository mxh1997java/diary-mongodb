package www.maxinhai.com.diary.command.remove;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

import java.util.UUID;

public class DeleteLabelCommand  extends AbstractCommand {

    @Setter
    @Getter
    private UUID id;

}
