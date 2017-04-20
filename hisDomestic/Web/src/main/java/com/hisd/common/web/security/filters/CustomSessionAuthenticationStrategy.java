package com.hisd.common.web.security.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;

public class CustomSessionAuthenticationStrategy extends
		ConcurrentSessionControlStrategy {

	private SessionRegistry sessionRegistry;
	private SessionFactory sessionFactory;

	public CustomSessionAuthenticationStrategy(SessionRegistry sessionRegistry,
			SessionFactory sessionFactory) {
		super(sessionRegistry);
		this.sessionRegistry = sessionRegistry;
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void onAuthentication(Authentication authentication,
			HttpServletRequest request, HttpServletResponse response) {
		setExceptionIfMaximumExceeded(false);
		super.onAuthentication(authentication, request, response);
	}

	@Override
	public void setExceptionIfMaximumExceeded(boolean exceptionIfMaximumExceeded) {
		super.setExceptionIfMaximumExceeded(exceptionIfMaximumExceeded);
	}

	@Override
	public void setMaximumSessions(int maximumSessions) {
		super.setMaximumSessions(maximumSessions);
	}
}
