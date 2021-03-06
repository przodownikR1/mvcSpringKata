package pl.java.scalatech.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author przodownik
 *         Module name : mvcSpringKata
 *         Creating time : 3 cze 2014
 */
@RestController
@Slf4j
public class HealthController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/appContext", method = RequestMethod.GET)
    public ResponseEntity<String> appContext() {
        List<String> names = Lists.newArrayList(applicationContext.getBeanDefinitionNames());
        names.sort((String s1, String s2) -> s1.compareTo(s2));
        String appContext = Joiner.on("<br/>").join(names);
        log.info("beans : {}",names);
        return new ResponseEntity<>(appContext, HttpStatus.OK);
    }

    
}
