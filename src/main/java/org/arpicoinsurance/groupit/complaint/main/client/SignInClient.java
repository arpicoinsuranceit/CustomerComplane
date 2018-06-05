package org.arpicoinsurance.groupit.complaint.main.client;

import java.util.HashMap;
import org.arpicoinsurance.groupit.complaint.main.dto.LoginResponseDto;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SignInClient {
	public LoginResponseDto getLogin(String username,String password) {
		
		HashMap<String , String> map=new HashMap<>();
		map.put("userName", username);
		map.put("password", password);
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			LoginResponseDto result = restTemplate.postForObject(AppConstant.LOGIN_REST_URL, map, LoginResponseDto.class);
			return result;
		}catch (Exception e) {

		}
		return null;
	}

}
