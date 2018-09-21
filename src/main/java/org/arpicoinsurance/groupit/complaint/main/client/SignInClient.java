package org.arpicoinsurance.groupit.complaint.main.client;

import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.dto.LoginResponseDto;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class SignInClient {
	
	@Autowired
	HttpSession httpSession;
	
	public LoginResponseDto getLogin(String userName,String password,String subSbu) {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userName", userName);
		map.add("password", password);
		map.add("subSbu", subSbu);
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			LoginResponseDto result = restTemplate.postForObject(AppConstant.LOGIN_REST_URL, map, LoginResponseDto.class);
			return result;
		}catch (Exception e) {

		}
		return null;
	}

}
