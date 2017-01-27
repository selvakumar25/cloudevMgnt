/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.service;

import com.es.security.dto.UserDto;
import com.es.security.persistence.Authority;
import com.es.security.persistence.User;
import com.es.security.persistence.UserHasRole;
import com.es.security.repository.UserHasRoleRepo;
import com.es.security.repository.UserRepo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VIGNESH
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    
    @Autowired
    UserHasRoleRepo userHasRoleRepo;
    
    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserHasRole> getUserHasRole(User user) {
        return userHasRoleRepo.findByUser(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList= userRepo.findAll();
        List<UserDto> listofUser=new ArrayList<>();
        for(User user:userList){
            UserDto item = new UserDto();
            String username=user.getUsername();
            String authority="";
            item.setName(username);
            Collection<UserHasRole> userRoles=user.getUserHasRoleCollection();
            Integer userRoleSize= userRoles.size();
            int count=1;
            for(UserHasRole userHasRole:userRoles){
                authority +=userHasRole.getAuthority().getName();
                if(count != userRoleSize ){ 
                    authority +=",";
                    count++;
                }
            }
            item.setAuthority(authority);
            listofUser.add(item);
        }
        return listofUser;
    }
    
    @Override
    public void createUser(){
        User user=new User();
        user.setIdUser(12);
        user.setUsername("Anand");
        user.setPassword( "1234");
        userRepo.save(user);
        
        
    }
}
