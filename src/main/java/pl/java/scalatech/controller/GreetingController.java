package pl.java.scalatech.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author przodownik
 * Module name :    mvcSpringKata
 * Creating time :  3 cze 2014
 */
@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return counter.incrementAndGet() + "  " + String.format(template, name);
    }
}