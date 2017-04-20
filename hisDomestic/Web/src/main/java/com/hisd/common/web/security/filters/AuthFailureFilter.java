package com.hisd.common.web.security.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class AuthFailureFilter extends SimpleUrlAuthenticationFailureHandler {

    private String defaultFailureUrl;
    private SessionFactory sessionFactory;
    
    public AuthFailureFilter(String defaultFailureUrl, SessionFactory sessionFactory) {
        super();
        this.defaultFailureUrl = defaultFailureUrl;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String userName = request.getParameter("j_username");
        try {
            // add code for login track and audit for login history	
            session.flush();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
        response.sendRedirect(request.getContextPath()+"/"+defaultFailureUrl+"?emailId="+userName);
    }
}
