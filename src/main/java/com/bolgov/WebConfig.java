package com.bolgov;

import com.bolgov.converter.DisheAddDto2ModelConverter;
import com.bolgov.converter.Dishes2RestaurantsWithDishesDTOConverter;
import com.bolgov.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DisheAddDto2ModelConverter());
        registry.addConverter(new Dishes2RestaurantsWithDishesDTOConverter());
    }
}
