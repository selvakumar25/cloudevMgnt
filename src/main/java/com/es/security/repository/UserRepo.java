/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.repository;

import com.es.security.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VIGNESH
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    public User findByUsername(@Param("username") String username);
}
