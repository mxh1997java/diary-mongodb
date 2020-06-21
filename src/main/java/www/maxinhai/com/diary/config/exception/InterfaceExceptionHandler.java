package www.maxinhai.com.diary.config.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import www.maxinhai.com.diary.config.mail.MailVo;
import www.maxinhai.com.diary.controller.MailController;
import www.maxinhai.com.diary.util.ResultBean;

@RestControllerAdvice
public class InterfaceExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(InterfaceExceptionHandler.class);

    @Autowired
    private MailController mailController;

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String runtimeException(RuntimeException e) {
        logger.error(e.getMessage(), e);
        // 返回 JOSN
        ResultBean resultBean = new ResultBean("运行时异常,请联系管理员", e.getMessage(),"500");
        MailVo mail = new MailVo("系统运行异常", e.getMessage() + e);
        mailController.sendMail(mail,null);
        return resultBean.toString();
    }


    /**
     * 系统异常捕获处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e) {
        logger.error(e.getMessage(), e);
        ResultBean resultBean = new ResultBean("系统捕获异常,请按系统要求输入", e.getMessage(), "500");
        MailVo mail = new MailVo("系统捕获异常", e.getMessage() + e);
        mailController.sendMail(mail,null);
        // 返回 JOSN
        return resultBean.toString();
    }

}
