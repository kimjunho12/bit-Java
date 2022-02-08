package com.poscoict.container.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/poscoict/container/config/videosystem/DVDPlayerConfig.xml" })
public class DvdPlayerXmlConfigTest {

	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	// @Autowired
	// 예외 발생 : Expliciti XML Bean 설정 (Avengers)에서는 id를 자동으로 부여하지 않는다
	// 따라서 @Qualifier를 사용할 수 없다.
	private DigitalVideoDisc dvd1;

	@Qualifier("ironman")
	@Autowired
	private DigitalVideoDisc dvd2;

	@Qualifier("avengersInfinityWar")
	@Autowired
	private DigitalVideoDisc dvd3;

	@Qualifier("avengersEndGame")
	@Autowired
	private DigitalVideoDisc dvd4;

	@Qualifier("avengersAgeOfUltron")
	@Autowired
	private DigitalVideoDisc dvd5;

	@Qualifier("avengersCaptainAmerica")
	@Autowired
	private DigitalVideoDisc dvd6;

	@Qualifier("avengersDirectorEdition")
	@Autowired
	private DigitalVideoDisc dvd7;
	
	@Qualifier("avengersExpansionEdition01")
	@Autowired
	private DigitalVideoDisc dvd8;
	
	
	
	
	@Autowired
	private DVDPack dvdPack;

	@Ignore
	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull01() {
		assertNotNull(dvd1);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull02() {
		assertNotNull(dvd2);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull03() {
		assertNotNull(dvd3);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull04() {
		assertNotNull(dvd4);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull05() {
		assertNotNull(dvd5);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull06() {
		assertNotNull(dvd6);
	}

	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull07() {
		assertNotNull(dvd7);
	}
	
	@Test /* 빈 생성 테스트 */
	public void testDVDNotNull08() {
		assertNotNull(dvd8);
	}
	
	
	
	@Test /* 빈 생성 테스트 */
	public void testDVDPack() {
		assertNotNull(dvdPack);
	}

}
