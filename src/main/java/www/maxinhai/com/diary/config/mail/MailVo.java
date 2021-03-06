package www.maxinhai.com.diary.config.mail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

@Data
@NoArgsConstructor
public class MailVo {

    private String id;//邮件id

    private String from;//邮件发送人

    private String to;//邮件接收人（多个邮箱则用逗号","隔开）

    private String subject;//邮件主题

    private String text;//邮件内容

    private Date sentDate;//发送时间

    private String cc;//抄送（多个邮箱则用逗号","隔开）

    private String bcc;//密送（多个邮箱则用逗号","隔开）

    private String status;//状态

    private String error;//报错信息

    @JsonIgnore
    private MultipartFile[] multipartFiles;//邮件附件

    /**
     * 快速邮件构造
     * @param subject
     * @param text
     */
    public MailVo(String subject, String text) {
        this.from = "666先生的救赎";
        this.to = "2485460305@qq.com";
        this.subject = subject;
        this.text = text;
    }

}
