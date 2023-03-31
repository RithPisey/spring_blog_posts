package com.java.blogposts.configs;

import com.java.blogposts.model.User;
import com.java.blogposts.model.UserSecurity;
import com.java.blogposts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(username);
        if(!user.isPresent()){
            throw  new UsernameNotFoundException("User details not found for user : " + username);
        }

        return new UserSecurity(user.get());
    }
}
