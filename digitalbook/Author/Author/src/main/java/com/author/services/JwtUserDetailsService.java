package com.author.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.author.entites.Author;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	AuthorService authorService;
	
	
	PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder()  ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Author author = authorService.findAuthorByEmail(username);
		if(author !=null && author.getAuthorEmail() != null) {
			
			System.out.println("======Author is a Valid======");
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
	        
	        
			return new User(author.getAuthorEmail(), bCryptPasswordEncoder.encode(author.getAuthorPass()) , authorities);
		} else {
			throw new UsernameNotFoundException("User not found with Email: " + username);
		}
	}
}
