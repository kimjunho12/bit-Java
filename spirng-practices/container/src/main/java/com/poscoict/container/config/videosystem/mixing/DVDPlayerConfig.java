package com.poscoict.container.config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.poscoict.container.videosystem.DVDPlayer;
import com.poscoict.container.videosystem.DigitalVideoDisc;

/**
 * JavaConfig02 (DVDPlayerConfig) <------------ JavaConfig01 (DVDConfig)
 * 
 * 
 * JavaConfig02 + JavaConfig01
 */

@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {
	
	@Bean
	public DVDPlayer dvdPlayer(@Qualifier(value = "avengersInfinityWar") DigitalVideoDisc dvd) {
		return new DVDPlayer();
	}
}
