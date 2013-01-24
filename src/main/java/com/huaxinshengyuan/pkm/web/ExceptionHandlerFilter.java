package com.huaxinshengyuan.pkm.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExceptionHandlerFilter implements Filter {

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse respone = (HttpServletResponse) servletResponse;

		try {
			filterChain.doFilter(request, servletResponse);
		} catch (Exception ex) {

			if(ex.getClass().toString().equals("class org.springframework.web.HttpSessionRequiredException"))
			{
				respone.sendRedirect(request.getContextPath()+"/timeout");
			}
			else
			{
	            request.setAttribute("errorMsg", getErrorMsg(ex));
				request.getRequestDispatcher(
						"/WEB-INF/views/uncaughtException.jsp").forward(
						request, respone);
			}

			
		}

	}


	public void init(FilterConfig filterConfig) throws ServletException {

	}


	public void destroy() {

	}

	protected String getErrorMsg(Exception exc) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body style=\"background-color : lightgreen;\">"
				+ "\n");

		Throwable e = exc;
		while (e != null) {

			// <![CDATA[ somehow doesn't work as expected
			String exceptionMsg = e.getMessage();
			if (exceptionMsg != null && !exceptionMsg.isEmpty()) {
				exceptionMsg = exceptionMsg.replaceAll("&", "&amp;");
				exceptionMsg = exceptionMsg.replaceAll("<", "&lt;");
				exceptionMsg = exceptionMsg.replaceAll(">", "&gt;");
				exceptionMsg = exceptionMsg.replaceAll("\n", "<br/>");
			}

			sb.append("<p>Exception: <b>" + e.getClass() + "</b>, message: <b>"
					+ exceptionMsg + "</b></p>" + "\n");

			sb.append("<p>" + "\n");
			StackTraceElement[] stackTraceElements = e.getStackTrace();
			for (StackTraceElement ste : stackTraceElements) {

				// set background color
				String steStr = ste.toString();
				if (steStr.startsWith("org.spring"))
					steStr = setBackgroundColorToHtmlText(steStr, "lightblue");
				else if (steStr.startsWith("com.huaxinshengyuan"))
					steStr = setBackgroundColorToHtmlText(steStr, "lavender");

				sb.append("&nbsp;&nbsp;&nbsp;&nbsp;" + steStr + "<br/>" + "\n");
			}
			sb.append("</p>" + "\n");

			Throwable cause = e.getCause();
			e = cause;

			if (e != null)
				sb.append("<p>Caused by:</p>" + "\n");
		}
		sb.append("</body></html>" + "\n");
	    return sb.toString();
		
		

	}

	private String setBackgroundColorToHtmlText(String text, String colorName) {
		String s = "<span style=\"background-color : " + colorName + ";\">"
				+ text + "</span>";
		return s;
	}



}
