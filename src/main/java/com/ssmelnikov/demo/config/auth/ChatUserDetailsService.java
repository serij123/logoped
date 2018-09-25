package com.ssmelnikov.demo.config.auth;

import com.ssmelnikov.demo.entity.User;
import com.ssmelnikov.demo.items.UserSecDetails;
import com.ssmelnikov.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ChatUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Value("${useFallbackAuth}")
    private Boolean useFallbackAuth;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(username);
        if(user == null) {
            if(useFallbackAuth) {
                if(username != null && username.equals("admin")) {
                    user = new User();
                    user.setEmail("admin@admin.org");
                    user.setFirstName("John");
                    user.setLastName("Smith");
                    user.setId("1");
                    user.setPassword("admin");
                    return new UserSecDetails(user);
                }
            }
            throw new UsernameNotFoundException(username);
        } else {
            return new UserSecDetails(user);
        }
    }


}
