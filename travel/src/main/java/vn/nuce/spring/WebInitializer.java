package vn.nuce.spring;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8", true);
        servletContext.addFilter("encodingFilter", filter)
                .addMappingForUrlPatterns(null,false,"/*");
    }
}
