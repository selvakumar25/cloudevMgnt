/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.service;

import com.es.security.dto.UserDto;
import com.es.security.persistence.User;
import com.es.security.persistence.UserHasRole;
import java.util.List;

/**
 *
 * @author VIGNESH
 */
public interface UserService {
   public User findByUsername(String username);
   
   public List<UserHasRole> getUserHasRole(User user);
   
   public List<UserDto> findAll();
   
   public void createUser();
}
