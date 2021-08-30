package com.Student.filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.Filter;

public class AuthFilterUser implements Filter
{
    private HttpServletRequest httpRequest;
    private static final String[] loginUserRequiredURLs;
    
    static {
        loginUserRequiredURLs = new String[] { "/registerSubject", "/listSubjectRegisted","cancelSubject","listSubjectRegisted" };
    }
    
    public void destroy() {
    }
    
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        this.httpRequest = (HttpServletRequest)request;
        final String path = this.httpRequest.getRequestURI().substring(this.httpRequest.getContextPath().length());
        if (path.startsWith("/user/")) {
            chain.doFilter(request, response);
            return;
        }
        final HttpSession session = this.httpRequest.getSession(false);
        final boolean isUserLoggedIn = session != null && session.getAttribute("USER") != null;
        final String loginUserURI = String.valueOf(this.httpRequest.getContextPath()) + "/login";
        final boolean isLoginUserRequest = this.httpRequest.getRequestURI().equals(loginUserURI);
        final boolean isLoginUserPage = this.httpRequest.getRequestURI().endsWith("/user/login.jsp");
        if (isUserLoggedIn && (isLoginUserRequest || isLoginUserPage)) {
            this.httpRequest.getRequestDispatcher("user/registerSubject.jsp").forward(request, response);
        }
        else if (!isUserLoggedIn && this.isLoginUserRequired()) {
            final String loginPage = "invalid.jsp";
            final RequestDispatcher dispatcher = this.httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        }
        else {
            chain.doFilter(request, response);
        }
    }
    
    private boolean isLoginUserRequired() {
        final String requestURL = this.httpRequest.getRequestURL().toString();
        String[] loginUserRequiredURLs;
        for (int length = (loginUserRequiredURLs = AuthFilterUser.loginUserRequiredURLs).length, i = 0; i < length; ++i) {
            final String loginRequiredURL = loginUserRequiredURLs[i];
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
        return false;
    }
    
    public void init(final FilterConfig filterConfig) throws ServletException {
    }
}