/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.repository;

import com.es.security.persistence.User;
import com.es.security.persistence.UserHasRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VIGNESH
 */
@Repository
public interface UserHasRoleRepo extends JpaRepository<UserHasRole,Integer>{
    
    public List<UserHasRole> findByUser(User user);
    
}
