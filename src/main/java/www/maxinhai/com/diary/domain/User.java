package www.maxinhai.com.diary.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

/**
 * 用户
 */
@Data
@Document(collection = "d_user")
public class User extends BaseEntity {

    /**
     * 用户id
     */
    private UUID userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
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
