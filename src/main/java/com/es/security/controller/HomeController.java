/*
 * To change this license header, choose License Headers in Project Properties.dfgdfgdfggs
 * To change this template file, choose Tools | Templates
 * and open the template in the edgitor.
 */
package com.es.security.controller;

import com.es.security.dao.UserDao;
import com.es.security.dto.UserDto;
import com.es.security.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author VIGNESHSe
 */
@Controller
public class HomeController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;


    @Resource(name = "defaultTokenServices")
    ConsumerTokenServices tokenServices;

    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/welcome")
    public String getWelcomePage(Principal principal, Map map) {
        System.out.println("Principal" + principal);
        map.put("username", principal.getName());
        return "welcome User";
    }

    @RequestMapping("/getUserDetails")
    public @ResponseBody
    Principal getUserDetails(Principal principal, Map map) {

        return principal;
    }

    @RequestMapping("/getAllUserDetails")
    public @ResponseBody
    List<UserDto> getAllUserDetails(Principal principal, Map map) {
        List<UserDto> users = userService.findAll();//userDao.getAllUserDetails();
        return users;
    }
    
   
    @RequestMapping("/create/New/User")
    public String createUser() {
        //userService.createUser();
        return "createNewUser";
    }

    
    @RequestMapping("/create/New/UserDetails")
    public String CreateUserDetails() {
        //userService.createUser();
        return "createNewUser";
    }

    @RequestMapping(value = "/tokens/revoke")
    public @ResponseBody void revokeToken(@RequestParam("access_token") String tokenId) {

        tokenServices.revokeToken(tokenId);
        

    }
}
