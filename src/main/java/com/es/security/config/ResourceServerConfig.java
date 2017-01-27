//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.es.security.config;
//
//import java.util.Arrays;
//import java.util.List;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
///**
// *
// * @author VIGNESH
// */
//@Configuration
//@EnableResourceServer   
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    
//     @Override
//            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//                resources.resourceId("rest");
//            }
//
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
//                http.authorizeRequests()
//                        .antMatchers("/login", "/").permitAll()
//                        //.antMatchers("/create/**").access("#oauth2.hasScope('read')")
////                        .hasAuthority("ROLE_HR")
//                        .antMatchers("/getAllUserDetails").hasAuthority("ROLE_HR")
//                        
//                        .and()
//                        .exceptionHandling().accessDeniedPage("/403");
//                //http.antMatcher("/create/**").authorizeRequests().anyRequest().access("#oauth2.hasScope('read')");
//                
//                http.authorizeRequests().anyRequest().authenticated();
//            }
//    
//    @Bean
//    protected ResourceServerConfiguration bedApiResources() {
//        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
//            public void setConfigurers(List<ResourceServerConfigurer> configurers) {
//                super.setConfigurers(configurers);
//            }
//        };
//        resource.setConfigurers(Arrays.<ResourceServerConfigurer>asList(new ResourceServerConfigurerAdapter() {
//
//            @Override
//            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//                resources.resourceId("rest");
//            }
//
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
//                http.authorizeRequests()
//                        .antMatchers("/login", "/").permitAll()
//                        //.antMatchers("/create/**").access("#oauth2.hasScope('read')")
////                        .hasAuthority("ROLE_HR")
//                        .antMatchers("/getAllUserDetails").hasAuthority("ROLE_HR")
//                        
//                        .and()
//                        .exceptionHandling().accessDeniedPage("/403");
//                //http.antMatcher("/create/**").authorizeRequests().anyRequest().access("#oauth2.hasScope('read')");
//                
//                http.authorizeRequests().anyRequest().authenticated();
//            }
//
//        }));
//        resource.setOrder(4);
//        return resource;
//    }
//}
