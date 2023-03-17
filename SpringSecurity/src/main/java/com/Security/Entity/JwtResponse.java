package com.Security.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class JwtResponse {
	
	
	private User user;
	private String jwtToken;

}
