package com.es.security.service;

import com.es.security.persistence.User;
import com.es.security.persistence.UserHasRole;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
             User user = userService.findByUsername(username);
        List<UserHasRole> role=userService.getUserHasRole(user);
        List<GrantedAuthority> authorities=new ArrayList<>();
        role.stream().forEach((userHasRole) -> {
            authorities.add(new SimpleGrantedAuthority(userHasRole.getAuthority().getName()));
        });
        AppUserDetails appUserDetails=new AppUserDetails(user.getUsername(), user.getPassword(),authorities);
        return appUserDetails;
        
        }catch (Exception ex) {
            throw new UsernameNotFoundException(username+" not found");
        }
       
    }
}
