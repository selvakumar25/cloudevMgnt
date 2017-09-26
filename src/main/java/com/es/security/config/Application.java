/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesssssssss
 * and open the template in the editor.
 */
package com.es.security.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author VIGNESH
 */
@SpringBootApplication
@ComponentScan("com.es.security")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
