package com.main.drawingcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.converter.UserConverter;
import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.RefreshToken;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.jwt.JwtResponse;
import com.main.drawingcourse.jwt.JwtUtility;
import com.main.drawingcourse.jwt.RefreshTokenRequest;
import com.main.drawingcourse.jwt.RefreshTokenResponse;
import com.main.drawingcourse.payload.ForgotPasswordRequest;
import com.main.drawingcourse.payload.LoginRequest;
import com.main.drawingcourse.payload.LogoutRequest;
import com.main.drawingcourse.repository.RefreshTokenRepository;
import com.main.drawingcourse.service.IUserService;
import com.main.drawingcourse.service.impl.RefreshTokenService;
import com.main.drawingcourse.service.impl.UserDetailsImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("public/account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SercurityController {
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserConverter converter;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
    private RefreshTokenService refreshTokenService;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest){
		System.out.println(loginRequest.getUsername());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtility.generateToken(loginRequest.getUsername());
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("");
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(loginRequest.getUsername());

		
		 return ResponseEntity.ok(
	                new JwtResponse(
	                        jwt,
	                        refreshToken.getToken(),
	                        userDetails.getUsername(),
	                        role)
	        );
	}
	
	@PostMapping("/signup")
    public String addCustomer(@RequestBody UserModel userInfo) {
		userInfo.setRoleId(3);//customer roleId = 3
		userInfo.setStatus(true);
        return userService.addUser(converter.toEntity(userInfo));
    }
	
	@GetMapping("/hello")
	@PreAuthorize("hasAuthority('User')")
	// change by role name in db here the roleName is User
	public String sayHello ()
    { return "Hello User" ;}
	
	
	@PostMapping("/refreshToken")
	public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
	    RefreshToken refreshToken = refreshTokenService.findByToken(refreshTokenRequest.getToken());
	    
	    String jwt = jwtUtility.generateToken(refreshTokenService.verifyExpiration(refreshToken).getUser().getUserName());
	    
	    return ResponseEntity.ok(
                new RefreshTokenResponse(
                        jwt,
                        refreshToken.getToken())
        );
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(@RequestBody LogoutRequest userName) {
		refreshTokenService.removeFromInstance((refreshTokenRepository.findByUser(userService.findUserByUserName(userName.getEmail()))));
		return ResponseEntity.ok("Logout successful!");
	}
	
	@PostMapping("/add-staff")
    public String addStaff(@RequestBody UserModel userInfo) {
		userInfo.setRoleId(2);//Staff roleId = 2
		userInfo.setStatus(true);
        return userService.addUser(converter.toEntity(userInfo));
    }
	
	@PostMapping("/add-instructor")
    public String addInstructor(@RequestBody UserModel userInfo) {
		userInfo.setRoleId(4);//instructor roleId = 2
		userInfo.setStatus(true);
        return userService.addUser(converter.toEntity(userInfo));
    }
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody ForgotPasswordRequest email) {
		String result="Do not find Email!";
		User user = userService.findUserByUserName(email.getEmail());
		if(user !=null) {
			result = userService.sendEmail(user);
		}
		return result;
	}
	
}
