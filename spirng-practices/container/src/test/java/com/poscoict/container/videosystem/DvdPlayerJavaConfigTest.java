package com.poscoict.container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poscoict.container.config.videosystem.DvdPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DvdPlayerConfig.class })
public class DvdPlayerJavaConfigTest {
	
	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	private DigitalVideoDisc dvd;

	@Qualifier("dvdPlayer04")
	@Autowired
	private DVDPlayer dvdPlayer;

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull() {
		assertNotNull(dvd);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDPlayerNotNull() {
		assertNotNull(dvdPlayer);
	}

	@Test /* 빈 주입 테스트 */
	public void testPlay() {
		dvdPlayer.play();
		assertEquals("Playing Movie MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}

}
