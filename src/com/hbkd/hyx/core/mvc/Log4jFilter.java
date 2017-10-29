package com.hbkd.hyx.core.mvc;

import org.apache.log4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author anke
 * @date 2017/10/26
 */
public class Log4jFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String ip = req.getRemoteAddr();
        //获取用户名
        String userName = (String) ((HttpServletRequest) req).getSession().getAttribute("userName");
        MDC.put("ip", ip);
        MDC.put("userName", userName);
        chain.doFilter(req, res);
        MDC.remove("ip");
        MDC.remove("userName");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
