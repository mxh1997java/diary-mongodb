package www.maxinhai.com.diary.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MyAspect {

    private static final Logger LOG = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(public * www.maxinhai.com.diary.controller.DiaryController.*(..))")
    public void addAdvice(){}

    @Before("addAdvice()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest requests = (HttpServletRequest) args[0];
        LOG.info("============打印日志开始============");
        LOG.info("URL: " + requests.getRequestURL().toString());
        LOG.info("============打印日志结束============");
    }

    @Pointcut("@annotation(www.maxinhai.com.diary.config.annotation.LoggerAnnotation)")
    public void logger() {}


    /**
     * 根据日志注解打印日志
     * @param joinPoint
     */
    @Before("logger()")
    public void before1(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest requests = (HttpServletRequest) args[0];
        LOG.info("============打印日志开始============");
        LOG.info("URL: " + requests.getRequestURL().toString());
        LOG.info("============打印日志结束============");
    }
}
