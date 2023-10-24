package com.main.drawingcourse.controller;

import com.main.drawingcourse.payload.ChangePasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtility.generateToken(loginRequest.getUsername());
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("");
		User userData = userService.findUserByUserName(userDetails.getUsername());
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(loginRequest.getUsername());

		
		 return ResponseEntity.ok(
	                new JwtResponse(
	                        jwt,
	                        refreshToken.getToken(),
	                        userData.getFullname(),
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
	@PreAuthorize("hasAuthority('CUSTOMER')")
	// change by role name in db here the roleName is CUSTOMER
	public String sayHello ()
    { return "Hello CUSTOMER" ;}
	
	
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
	public ResponseEntity<?> logout(@RequestBody LogoutRequest token) {
		refreshTokenService.removeFromInstance(refreshTokenRepository.findByToken(token.getToken()));
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
		User user = userService.findUserByEmail(email.getEmail());
		if(user !=null) {
			result = userService.sendEmail(user);
		}
		return result;
	}


	@PutMapping("/change-password")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request) {
		User user = userService.findUserByUserName(request.getUsername());
		String result = "Change password fail!";
		if(user!=null) {
			result = userService.changePassword(user, request.getPasswordEntered(),request.getNewPassword());
		}
		return ResponseEntity.ok(result);
	}
}
