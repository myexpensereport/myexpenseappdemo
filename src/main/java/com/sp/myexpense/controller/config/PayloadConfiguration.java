/**
 * 
 */
package com.sp.myexpense.controller.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
public class PayloadConfiguration {
	
	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
