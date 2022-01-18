package com.hp.boot.controller;

import com.hp.boot.bean.NewCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @create 2022-01-18 10:36
 */
@RestController
public class HelloController {

    @Autowired
    private NewCar newCar;

    @GetMapping("/newCar")
    public NewCar newCar(){
        return newCar;
    }


    @GetMapping("hello")
    public String hello(){
        return "123";
    }


}
