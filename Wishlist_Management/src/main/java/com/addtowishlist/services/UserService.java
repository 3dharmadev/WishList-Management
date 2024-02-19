package com.addtowishlist.services;

import com.addtowishlist.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

     User findByUsername(String username);

     String saveUser(User user);


}
