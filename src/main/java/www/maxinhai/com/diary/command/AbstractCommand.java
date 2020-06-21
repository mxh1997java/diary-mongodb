package www.maxinhai.com.diary.command;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractCommand {

    /**
     * 名称
     */
    @Setter
    @Getter
    protected String name;

    /**
     * 描述
     */
    @Setter
    @Getter
    protected String description;

}
