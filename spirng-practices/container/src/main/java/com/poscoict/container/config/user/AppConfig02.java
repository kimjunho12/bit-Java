package com.poscoict.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscoict.container.user.User;

@Configuration
public class AppConfig02 {
	
	@Bean
	public User user() {
		return new User("둘리");
	}

}
