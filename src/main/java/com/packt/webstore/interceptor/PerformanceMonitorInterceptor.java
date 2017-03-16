package com.packt.webstore.interceptor;

import com.sun.istack.internal.logging.Logger;
import org.springframework.util.StopWatch;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {
    ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
    Logger logger = Logger.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, java.lang.Object o) throws Exception {
        StopWatch stopWatch = new StopWatch(o.toString());
        stopWatch.start(o.toString());
        stopWatchLocal.set(stopWatch);
        logger.info("Przetwarzanie żądania do ścieżki: " + getUrlPath(httpServletRequest));
        logger.info("Przetwarzanie żądania rozpoczęto o: " + getCurrentTime());

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, java.lang.Object o, ModelAndView modelAndView) throws Exception {
        logger.info("Przetwarzanie żądania zaończono o: " + getCurrentTime());
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, java.lang.Object o, java.lang.Exception e) throws Exception {
        StopWatch stopWatch = stopWatchLocal.get();
        stopWatch.stop();
        logger.info("Laczny czas przetwarzania żądania: " + stopWatch.getTotalTimeMillis() + " ms");
        stopWatchLocal.set(null);
        logger.info("================================================");
    }

    private String getUrlPath(HttpServletRequest httpServletRequest) {
        String currentPath = httpServletRequest.getRequestURI();
        String queryString = httpServletRequest.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath+queryString;
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat(("dd/MM/yyyy 'o' hh:mm:ss"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
