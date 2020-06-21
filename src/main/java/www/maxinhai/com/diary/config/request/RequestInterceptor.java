package www.maxinhai.com.diary.config.request;

//import com.example.diary.util.ObjectUtil;
//import com.example.diary.util.UserCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 请求拦截器
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
//        if(null != token && ObjectUtil.isNotNull(UserCacheManager.getCache(token.toString()))) {
//            logger.debug("用户已登录");
//            return true;
//        }
        logger.debug("用户未登录  即将跳转到登陆页面");
        response.sendRedirect("/diary/user/login.htm");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("请求IP: {} 请求路径: {} 请求方式: {} 请求参数: {}",
                request.getRemoteAddr(),
                request.getRequestURL(),
                request.getMethod(),
                request.getParameterMap().toString());
    }

}
