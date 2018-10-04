package org.arpicoinsurance.groupit.complaint.main.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@PropertySource("classpath:application.properties")
public class SignInInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpSession httpSession;
	
	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	ServletContext context;


	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		context.setAttribute("path", path);
		if (!httpServletRequest.getRequestURI().equals(path+"/login") ) {

			Object user = httpSession.getAttribute("token");
			if (null == user) {
				httpServletResponse.sendRedirect(path+"/login");
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