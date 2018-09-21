package org.arpicoinsurance.groupit.complaint.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SignInInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpSession httpSession;

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		
		if (!httpServletRequest.getRequestURI().equals("/login") ) {

			Object user = httpSession.getAttribute("token");
			if (null == user) {
				httpServletResponse.sendRedirect("login");
			}
		}

		return true;

	}

	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
		
		String token=(String) httpSession.getAttribute("token");
		if (null != token) {
			// httpServletRequest.setAttribute("ent",user.getMenuMap());
			httpServletRequest.setAttribute("token", token);

		}

	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}