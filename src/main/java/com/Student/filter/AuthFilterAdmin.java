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
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;

@WebFilter({ "/*" })
public class AuthFilterAdmin implements Filter {
	private HttpServletRequest httpRequest;
	private static final String[] loginAdminRequiredURLs;

	static {
		loginAdminRequiredURLs = new String[] { "/addStudent", "/editStudent", "/homeStudent", "/addSubject",
				"editSubject", "homeSubject", "/viewMark", "editMark" };
	}

	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		this.httpRequest = (HttpServletRequest) request;
		final String path = this.httpRequest.getRequestURI().substring(this.httpRequest.getContextPath().length());
		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		final HttpSession session = this.httpRequest.getSession(false);
		final boolean isAdminLoggedIn = session != null && session.getAttribute("ADMIN") != null;
		final String loginAdminURI = String.valueOf(this.httpRequest.getContextPath()) + "/login";
		final boolean isLoginAdminRequest = this.httpRequest.getRequestURI().equals(loginAdminURI);
		final boolean isLoginAdminPage = this.httpRequest.getRequestURI().endsWith("/admin/login.jsp");
		if (isAdminLoggedIn && (isLoginAdminRequest || isLoginAdminPage)) {
			this.httpRequest.getRequestDispatcher("admin/homeSubject.jsp").forward(request, response);
		} else if (!isAdminLoggedIn && this.isLoginAdminRequired()) {
			final String loginPage = "invalid.jsp";
			final RequestDispatcher dispatcher = this.httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean isLoginAdminRequired() {
		final String requestURL = this.httpRequest.getRequestURL().toString();
		String[] loginAdminRequiredURLs;
		for (int length = (loginAdminRequiredURLs = AuthFilterAdmin.loginAdminRequiredURLs).length,
				i = 0; i < length; ++i) {
			final String loginRequiredURL = loginAdminRequiredURLs[i];
			if (requestURL.contains(loginRequiredURL)) {
				return true;
			}
		}
		return false;
	}

	public void destroy() {
	}

	public void init(final FilterConfig fConfig) throws ServletException {
	}
}