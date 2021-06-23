package com.example.myrealestate.service;


import com.example.myrealestate.model.CurrentUser;
import com.example.myrealestate.model.User;
import com.example.myrealestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
  @Autowired
  private   UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(s);
       if (!byEmail.isPresent()){
           throw  new UsernameNotFoundException("User with " + s + " does not exist");
       }

        return new CurrentUser(byEmail.get());

    }
}
