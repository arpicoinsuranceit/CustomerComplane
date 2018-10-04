package org.arpicoinsurance.groupit.complaint.main.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.client.SignInClient;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.dto.LoginResponseDto;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintService;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PropertySource("classpath:application.properties")
public class WelcomeController {
	
	@Autowired
	private SignInClient userManagementClient;
	
	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private ComplaintService complaintService;
    

	@RequestMapping("/")
	public String redirectToLoginPage(HttpSession httpSession) {
		return "login";
	}

	@RequestMapping("/login")
	public String viewLoginPage(HttpSession httpSession) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpSession httpSession, @RequestParam(value = "userName") String username,
			@RequestParam(value = "password") String password) throws Exception {
		context.setAttribute("path", path);
		System.out.println(username +"-"+ password );
		LoginResponseDto loginResponseDto= userManagementClient.getLogin(username, password,"3");
		
		
		ModelAndView modelAndView = new ModelAndView();

		if (loginResponseDto != null) {
			//System.out.println(loginResponseDto.toString());
			if((loginResponseDto.getJwtToken() != "" || loginResponseDto.getJwtToken() != null)&& loginResponseDto.isLogin() == true) {
				
				httpSession.setAttribute("token", loginResponseDto.getJwtToken());
				
				List<ComplaintDto> complaintDto= complaintService.findByComplaintStatus(AppConstant.COMPLAINT_STATUS_NEW);
				httpSession.setAttribute(AppConstant.COMPLAINT_STATUS_NEW, complaintDto.size());
				
				complaintDto= complaintService.findByComplaintStatus(AppConstant.COMPLAINT_STATUS_FULLY);
				httpSession.setAttribute(AppConstant.COMPLAINT_STATUS_FULLY, complaintDto.size());
				
				complaintDto= complaintService.findByComplaintStatus(AppConstant.COMPLAINT_STATUS_NOT);
				httpSession.setAttribute(AppConstant.COMPLAINT_STATUS_NOT, complaintDto.size());
				
				complaintDto= complaintService.findByComplaintStatus(AppConstant.COMPLAINT_STATUS_PARTIALLY);
				httpSession.setAttribute(AppConstant.COMPLAINT_STATUS_PARTIALLY, complaintDto.size());
				
				httpSession.setAttribute("userName",loginResponseDto.getUserName());
				modelAndView.setViewName("home");
				
			}else {

				if (loginResponseDto.isInactive()) {
					modelAndView.addObject("login_error", "You have no authorized to login to system");
					//modelAndView.setViewName("login");
				} else if (!loginResponseDto.isLogin()){
					modelAndView.addObject("login_error", "You have entered username or password incorrectly");
					//modelAndView.setViewName("login");
				} else if (loginResponseDto.isLock()){
					modelAndView.addObject("login_error", "Your account has been locked");
					//modelAndView.setViewName("login");
				} else if (loginResponseDto.isExpired()){
					modelAndView.addObject("login_error", "Your account has been expired. Please reset your password");
					//modelAndView.setViewName("login");
				} else if (loginResponseDto.getJwtToken() == "" || loginResponseDto.getJwtToken() == null){
					modelAndView.addObject("login_error", "You have entered username or password incorrectly");
					//modelAndView.setViewName("login");
				}else {
					modelAndView.addObject("login_error", "You have entered username or password incorrectly");
					//modelAndView.setViewName("login");
				}
			}
			
		} else {
			modelAndView.addObject("login_error", "Username or password incorrect");
			//modelAndView.setViewName("login");
		}

		return modelAndView;

	}

	@RequestMapping("/home")
	public String viewWelcomePage(ModelAndView modelAndView) {
		return "home";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "logout";
	}

}
