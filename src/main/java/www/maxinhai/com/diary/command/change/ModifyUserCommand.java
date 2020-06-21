package www.maxinhai.com.diary.command.change;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import www.maxinhai.com.diary.command.AbstractCommand;

import java.util.UUID;

public class ModifyUserCommand  extends AbstractCommand {

    @Setter
    @Getter
    private UUID id;

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

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * QQ号码
     */
    private String QQNo;

    /**
     * 微信号
     */
    private String weChatNo;

}
