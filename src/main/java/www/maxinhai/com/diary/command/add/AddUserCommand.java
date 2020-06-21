package www.maxinhai.com.diary.command.add;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

public class AddUserCommand  extends AbstractCommand {

    /**
     * 密码
     */
    @NonNull
    @Getter
    @Setter
    private String password;

    /**
     * 用户名
     */
    @NonNull
    @Getter
    @Setter
    private String username;

}
