package com.clinica.odontologia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Bienvenido admin</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>Bienvenido user</h1>";
    }


}
