package com.project.Mysql.utils;

import com.project.Mysql.user.Role;
import com.project.Mysql.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class CookiesUtils {

    private HttpSession session;

    public CookiesUtils(HttpSession session) {
        this.session = session;
    }

    private CookiesUtils() {}

    public boolean isAuthenticated() {
        return session.getAttribute("user") != null;
    }

    public boolean isLibrarian() {
        User user = (User) session.getAttribute("user");
        return user != null && user.getRole() == Role.LIBRARIAN;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public static CookiesUtils getInstance() {
        return new CookiesUtils();
    }
}
