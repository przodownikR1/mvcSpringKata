package pl.java.scalatech.initializer;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import lombok.extern.slf4j.Slf4j;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import pl.java.scalatech.config.WebMvcConfig;

/**
 * @author przodownik
 *         Module name : mvcSpringKata
 *         Creating time : 3 cze 2014
 */
@Slf4j
public class AppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext appContext = getContext();
        servletContext.addListener(new ContextLoaderListener(appContext));
        
              
              
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        registerHiddenHttpMethodFilter(servletContext);
        characterEncoding(servletContext);
        openSessionInView(servletContext);
    }

    private AnnotationConfigWebApplicationContext getContext() {

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebMvcConfig.class);
        log.info("++++                  getContext  {} ", appContext.getDisplayName());
        return appContext;
    }


    private void registerHiddenHttpMethodFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic registration = servletContext.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
        registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false, DISPATCHER_SERVLET_NAME);
    }
    
    
    private void characterEncoding(ServletContext servletContext){
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        DispatcherType[] dispatcherTypes = { DispatcherType.FORWARD,DispatcherType.INCLUDE };
        characterEncodingFilter.addMappingForUrlPatterns(
        EnumSet.of(DispatcherType.REQUEST, dispatcherTypes), false, "/*");

    }
    
    private void openSessionInView(ServletContext servletContext){
                FilterRegistration.Dynamic openEntityManagerInViewFilter = servletContext.addFilter("openEntityManagerInViewFilter",new OpenEntityManagerInViewFilter());
                openEntityManagerInViewFilter.setInitParameter("entityManagerFactoryBeanName", "entityManagerFactory");
                openEntityManagerInViewFilter.addMappingForUrlPatterns(null, false,"/*");
    }
    
  /*  protected Filter[] getServletFilters() {
        return new Filter[]{
                characterEncodingFilter(),
                new HiddenHttpMethodFilter(),
                requestLoggingFilter(),
               };
    }

    
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    Filter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    Filter requestLoggingFilter() {
        final CommonsRequestLoggingFilter requestLoggingFilter = new CommonsRequestLoggingFilter();
        requestLoggingFilter.setIncludeClientInfo(true);
        requestLoggingFilter.setIncludePayload(true);
        requestLoggingFilter.setIncludeQueryString(true);
        return requestLoggingFilter;
    }*/
}