package com.acme.delivery.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfiguration
{
	@Bean public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
