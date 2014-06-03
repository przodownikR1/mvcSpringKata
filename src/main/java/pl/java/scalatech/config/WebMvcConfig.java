package pl.java.scalatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author przodownik
 * Module name :    mvcSpringKata
 * Creating time :  3 cze 2014
 */
@EnableWebMvc
@Configuration
@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
   
      return resolver;
    }
}