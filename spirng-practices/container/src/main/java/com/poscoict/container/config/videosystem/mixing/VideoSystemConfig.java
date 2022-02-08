package com.poscoict.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * <------------ JavaConfig01 (DVDConfig + JavaConfig02 (DVDPlayerConfig)
 * import
 * 
 * JavaConfig01 + JavaConfig02
 *
 */

@Configuration
@Import({ DVDConfig.class, DVDPlayerConfig.class })
public class VideoSystemConfig {

}
