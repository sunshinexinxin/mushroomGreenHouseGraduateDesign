package com.hbkd.hyx.core.mvc;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Map;

public class BaseAction extends ActionSupport implements ServletRequestAware,
        ServletResponseAware, SessionAware {

    private static final long serialVersionUID = 4565394360208096613L;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Map<String, HttpSession> sessions;
    protected HttpSession session;

    public void outputStreamStr(String str) {
        PrintWriter out = null;
        try {
            if (response == null) {
                response = ServletActionContext.getResponse();
            }
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.print(str);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != null) {
                out.close();
            }
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setSession(Map map) {
        this.sessions = map;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Map<String, HttpSession> getSessions() {
        return sessions;
    }

    public void setSessions(Map<String, HttpSession> sessions) {
        this.sessions = sessions;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public HttpSession getSession() {
        return request.getSession(true);
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

}