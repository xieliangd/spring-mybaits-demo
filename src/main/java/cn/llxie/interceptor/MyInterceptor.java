package cn.llxie.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ip = httpServletRequest.getRemoteAddr();
        long startTime = System.currentTimeMillis();
        httpServletRequest.setAttribute("requestStartTime", startTime);
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        System.out.println("preHandle------ip:"+ip+",path:"+method.getDeclaringClass().getName() + "." + method.getName()+" now: "+startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        long startTime = (Long) httpServletRequest.getAttribute("requestStartTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if (executeTime > 1000) {
            System.out.println("[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
        } else {
            System.out.println("[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
