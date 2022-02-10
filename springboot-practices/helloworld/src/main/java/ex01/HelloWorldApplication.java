package ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  Bootstrapping Class
 * 
 *  1. 스프링부트 애플리케이션의 부트스트래핑 (bootstrapping)
 *  2. 설정 클래스로 역할 (Configuration Class)
 *  
 */

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		/*
		 *  1. 애플리케이션 컨텍스트 (Application Context, Spring Container) 생성
		 *  2. 웹어플리케이션 타입 (Web Application인 경우 MVC or Reactive 타입 결정) 
		 *  3. Annotation Scanning (Auto) or Configuration Class (Explicit) 통한 빈 생성 / 등록 및 와이어링
		 *  4. Web Application (MVC)
		 *  	- 내장(embedded) 서버 (TomcatEmbeddedServletContainer) 인스턴스 생성
		 *  	- 서버 인스턴스 웹 어플리케이션을 배포
		 *  	- 서버 인스턴스 실행
		 *  5. ApplicationRunner 인터페이스를 구현한 Bean을 찾아 실행 (Run 호출)
		 *  
		 */
		
		ConfigurableApplicationContext c = SpringApplication.run(HelloWorldApplication.class, args);
		c.close();
	}

}
