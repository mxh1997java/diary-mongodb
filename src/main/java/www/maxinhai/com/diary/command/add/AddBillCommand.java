package www.maxinhai.com.diary.command.add;

import lombok.Getter;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

public class AddBillCommand extends AbstractCommand {

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
