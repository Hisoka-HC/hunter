package com.elabel.hospital.util;

import com.elabel.hospital.pojo.user.User;

import javax.servlet.http.HttpSession;

public class GetUserSession {

    public static User getSessionUser(HttpSession httpSession) {
        Object tmp = httpSession.getAttribute("user");
        if (tmp == null)
            return null;
        else
            return (User) tmp;
    }
}
