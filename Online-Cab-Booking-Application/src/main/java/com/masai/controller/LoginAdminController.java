package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.AdminLoginService;
import com.masai.service.DriverLoginService;


@RestController
public class LoginAdminController {

	

	@Autowired
	private AdminLoginService adminLogin;
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> logIn(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = adminLogin.logIntoAccount(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@GetMapping("/logoutAdmin")
	public String logout(@RequestParam(required = false) String key) throws LoginException {
		return adminLogin.logOutFromAccount(key);
		
	}
}
