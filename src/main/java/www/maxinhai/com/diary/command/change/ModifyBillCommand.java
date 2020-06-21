package www.maxinhai.com.diary.command.change;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

import java.util.UUID;

public class ModifyBillCommand  extends AbstractCommand {

    @Setter
    @Getter
    private UUID id;

    /**
     * 标签
     */
    @Setter
    @Getter
    private String label;

    @Setter
    @Getter
    private String labelId;

    /**
     * 消费金额
     */
    @Setter
    @Getter
    private Double amount;

}
