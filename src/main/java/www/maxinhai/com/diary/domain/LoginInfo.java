package www.maxinhai.com.diary.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "d_login_info")
public class LoginInfo extends BaseEntity {

    private UUID id;

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
     * 登录时间
     */
    private Date loginTime;

    /**
     * 系统
     */
    private String system;

    /**
     * 机器号
     */
    private String machine;

}
