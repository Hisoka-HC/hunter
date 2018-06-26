package com.elabel.hospital.util;

import com.elabel.hospital.pojo.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private Class currentClass;
    private HttpSession httpSession;
    private HttpServletRequest request;

    public Logger(Class currentClass){
        this.currentClass = currentClass;
    }

    public Logger(Class currentClass, HttpSession httpSession, HttpServletRequest request) {
        this.currentClass = currentClass;
        this.httpSession = httpSession;
        this.request = request;
    }

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void log(String message) {
        StringBuilder buff = new StringBuilder();
        buff.append(format.format(Calendar.getInstance().getTime())).append("\t").append(currentClass.getName());

        if (httpSession != null) {
            User user = getSessionUser(httpSession);
            if (user != null) {
                buff.append("\t").append(user.email);
            }
        }
        if (request != null) {
            buff.append("\t").append(request.getRemoteAddr());
        }
        buff.append("\t").append(message);
        System.out.println(buff.toString());
    }

    private User getSessionUser(HttpSession httpSession) {
        Object tmp = httpSession.getAttribute("user");
        if (tmp == null)
            return null;
        else
            return (User) tmp;
    }

}
