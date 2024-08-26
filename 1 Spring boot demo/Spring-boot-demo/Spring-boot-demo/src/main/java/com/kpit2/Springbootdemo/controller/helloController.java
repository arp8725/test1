package com.kpit2.Springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController 
{
    // @RequestMapping(value = "/", method = RequestMethod.GET) // or we can directly write i.e @GetMapping("/")
    @GetMapping("/")
    public String helloWorld()
    {
        return "Welcome Adityaaaaaaa";
    }

}
