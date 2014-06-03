package pl.java.scalatech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author przodownik
 * Module name :    mvcSpringKata
 * Creating time :  3 cze 2014
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "Hello world";
    }

}