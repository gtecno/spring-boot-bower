/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.spring.boot.bower;

import co.agileventure.cloud.spring.entidad.Genre;
import co.agileventure.cloud.spring.entidad.Movie;
import co.agileventure.cloud.spring.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gabriel Calvo
 */
@SpringBootApplication
@Controller
public class BowerAplicationInit  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BowerAplicationInit.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(BowerAplicationInit.class, args);
    }

    @RequestMapping("/")
    public String hola() {
        return "index";
    }
}
