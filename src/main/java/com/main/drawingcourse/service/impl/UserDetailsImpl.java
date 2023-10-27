package com.main.drawingcourse.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.drawingcourse.entity.User;



public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private Boolean enabled;

	@JsonIgnore
	private String password;
	GrantedAuthority authority = null;

	public UserDetailsImpl(Integer id, String username, String password, GrantedAuthority authority,
			Boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authority = authority;
		this.enabled = enabled;
	}

//This func help you guys get account information to AccountDetailService
	public static UserDetailsImpl build(User account) {
		GrantedAuthority authority = new SimpleGrantedAuthority(account.getRole().getRoleName());
		return new UserDetailsImpl(account.getUserId(), account.getUserName(), account.getPassword(), authority,
				account.isStatus());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(authority);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl account = (UserDetailsImpl) o;
		return Objects.equals(id, account.id);
	}
}
