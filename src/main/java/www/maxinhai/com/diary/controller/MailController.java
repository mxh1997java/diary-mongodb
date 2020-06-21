package www.maxinhai.com.diary.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import www.maxinhai.com.diary.config.mail.MailService;
import www.maxinhai.com.diary.config.mail.MailVo;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
@Api(value = "Mail接口API", description = "邮箱接口API")
public class MailController extends AbstractController{

    @Autowired
    private MailService mailService;

    /**
     * 发送邮件
     */
    @PostMapping("/send")
    public Map<String, Object> sendMail(@RequestBody MailVo mailVo,
                                        @RequestBody MultipartFile[] files) {
        mailVo.setMultipartFiles(files);
        MailVo mailVo1 = mailService.sendMail(mailVo);//发送邮件和附件
        Map<String, Object> result = new HashMap<>();
        result.put("code", SUCCESSCODE);
        result.put("msg", SUCCESS);
        result.put("data", mailVo1);
        return result;
    }


}
