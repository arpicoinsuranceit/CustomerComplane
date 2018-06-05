package org.arpicoinsurance.groupit.complaint.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.dto.UsersDto;
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
		//if(!httpServletRequest.getRequestURI().contains("/qfs-driver/api/v1/driver/")) {
			if (AppConstant.LOGIN_URL.equals(httpServletRequest.getRequestURI())
					|| AppConstant.ROOT_URL.equals(httpServletRequest.getRequestURI())) {
				UsersDto user = (UsersDto) httpSession.getAttribute("user");
				if (null != user) {
					httpServletResponse.sendRedirect("/home");
				}
			}

			if (!AppConstant.LOGIN_URL.equals(httpServletRequest.getRequestURI())
					&& !AppConstant.LOGOUT_URL.equals(httpServletRequest.getRequestURI())) {
				UsersDto user = (UsersDto) httpSession.getAttribute("user");
				if (null == user) {
					httpServletRequest.logout();
					httpServletResponse.sendRedirect("/login");

				}
			}
		//}
		

		return true;

	}

	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
		//if(!httpServletRequest.getRequestURI().contains("/qfs-driver/api/v1/driver/")) {
		UsersDto user = (UsersDto) httpSession.getAttribute("user");
			if (null != user) {
				// httpServletRequest.setAttribute("ent",user.getMenuMap());
				httpServletRequest.setAttribute("user_name", user.getUser_Name());
	
			}
		//}

	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
