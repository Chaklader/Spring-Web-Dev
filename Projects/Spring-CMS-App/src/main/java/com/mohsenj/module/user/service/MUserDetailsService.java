package com.mohsenj.module.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohsenj.module.user.model.Role;
import com.mohsenj.module.user.model.User;
import com.mohsenj.module.user.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class MUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
    // 
	
    static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
  
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
              "No user found with username: "+ email);
        }
       // System.out.println("is enabled: "+user.isEnabled());
     //   boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
      //get the encoded password
     //   String encodedPassword = passwordEncoder.encode(user.getPassword());
        
        org.springframework.security.core.userdetails.User userDetails =   new org.springframework.security.core.userdetails.User
          (user.getEmail(), 
        		  user.getPassword(), user.isEnabled(), accountNonExpired, 
          credentialsNonExpired, accountNonLocked, 
          getAuthorities(user.getRoles()));
        
      //  System.out.println(userDetails);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                 
        return userDetails;
    }
     
    private static List<GrantedAuthority> getAuthorities (Set<Role> set) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : set) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

}
