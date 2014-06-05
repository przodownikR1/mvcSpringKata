package pl.java.scalatech.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author przodownik
 * Module name :    mvcSpringKata
 * Creating time :  5 cze 2014
 */
@RestController
@RequestMapping("/date")
public class DateController {

    @RequestMapping("/{localDate}")
    public String get(@DateTimeFormat(iso=ISO.DATE)LocalDate localDate){
        return localDate.toString();
    }
    
    
}
