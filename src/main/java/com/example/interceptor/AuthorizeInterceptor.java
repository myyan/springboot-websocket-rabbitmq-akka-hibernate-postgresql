package com.example.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chenhao on 2016/9/19.
 */
@Component
public class AuthorizeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("entry user interceptor module");
//        String reqUrl = request.getRequestURI().replace(request.getContextPath(), "");
//        if (reqUrl.contains("/login")) {
//            logger.info("reqeust permit");
//            return true;
//        } else {
//            HttpSession session = request.getSession();
//            Object obj = session.getAttribute("userInfo");
//            if (obj == null || "".equals(obj.toString())) {
//                logger.info("session is not exist ,request reject");
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
