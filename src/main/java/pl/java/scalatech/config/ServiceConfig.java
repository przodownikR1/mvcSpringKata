package pl.java.scalatech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author przodownik
 * Module name :    mvcSpringKata
 * Creating time :  3 cze 2014
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
@ComponentScan(basePackages="pl.java.scalatech.service")
public class ServiceConfig {

}