package com.inacioalves.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inacioalves.auth.jwt.UserSecurity;
import com.inacioalves.auth.model.User;
import com.inacioalves.auth.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserSecurityService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		if(user.isPresent()) {
			return new UserSecurity(user.get().getId(),user.get().getEmail(),user
					.get().getPassword(),user.get().getPerfis());
		}
		throw new UsernameNotFoundException(email);
		
		
	}

}
