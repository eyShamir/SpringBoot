package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
@RestController
public class SpringBootController {

    private String FirstName ;

    @Autowired


    @RequestMapping("/")
    public String getHelloWorld(){
        return "Hello World from SpringBoot New";
    }

    @RequestMapping("GoodBy")
    public String GetGoodBy(){
        return "GoodBy from SpringBoot";
    }

    @RequestMapping("ClientDeatils")
    public String GetClientDetails (@RequestParam(name="name", required = false, defaultValue = "Ahmed") String name){
        return "Hello " + name;
    }
}
