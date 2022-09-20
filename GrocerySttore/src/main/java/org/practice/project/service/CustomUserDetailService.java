package org.practice.project.service;

import java.util.Optional;

import org.practice.project.entity.CustomUserDetail;
import org.practice.project.entity.User;
import org.practice.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailService implements UserDetailsService{
@Autowired
UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>user=userRepository.findUserByEmail(username);
		user.orElseThrow(()->new UsernameNotFoundException("username not found"));
		return user.map(CustomUserDetail::new).get();
	}

}
