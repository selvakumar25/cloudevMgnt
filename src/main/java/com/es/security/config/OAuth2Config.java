/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.config;

import com.es.security.service.UserDetailsServiceImpl;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 *
 * @author VIGNESH
 */
@Configuration
public class OAuth2Config {

    @Configuration
    @EnableAuthorizationServer
    protected class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private UserDetailsServiceImpl userDetailsService;

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        @Qualifier("dataSourceApi")
        DataSource dataSource;

        @Primary
        @Bean
        public DefaultTokenServices defaultTokenServices() {
            DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
            defaultTokenServices.setTokenStore(tokenStore());
            defaultTokenServices.setSupportRefreshToken(true);
            return defaultTokenServices;
        }

        @Bean
        public JdbcTokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }

        @Bean
        public JdbcClientDetailsService jdbcClientDetailsService() {
            return new JdbcClientDetailsService(dataSource);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.jdbc(dataSource);

        }
    }

    @Bean
    protected ResourceServerConfiguration apiResources() {
        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
            @Override
            public void setConfigurers(List<ResourceServerConfigurer> configurers) {
                super.setConfigurers(configurers);
            }
        };
        resource.setConfigurers(Arrays.<ResourceServerConfigurer>asList(new ResourceServerConfigurerAdapter() {

            @Override
            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
                resources.resourceId("rest12");
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/login", "/").permitAll()
                        .antMatchers("/create/**").access("#oauth2.hasScope('read') and hasRole('ROLE_ADMIN')")
                        //                        .hasAuthority("ROLE_HR")
                        .antMatchers("/getAllUserDetails").hasAuthority("ROLE_HR");
                       
                http.authorizeRequests().anyRequest().authenticated();
            }

        }));
        resource.setOrder(4);
        return resource;
    }
}
