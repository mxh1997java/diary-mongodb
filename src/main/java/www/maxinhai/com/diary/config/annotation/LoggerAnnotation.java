package www.maxinhai.com.diary.config.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggerAnnotation {
}
