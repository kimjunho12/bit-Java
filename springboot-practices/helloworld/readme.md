___
## Spring Boot
_: Library (Tool)_

### Spring Application
- 비즈니스 코드 구현
- 설정
    + Dependency ➡ Dependency Starter
    + Container ➡ Auto Confoguration

- module pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>com.poscoict</groupId>
		<artifactId>springboot-practices</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</parent>
	<artifactId>helloworld</artifactId>

	<properties>	<!-- 속성 설정 -->
		<project.build.sourceEncoding>utf-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>utf-8</project.reporting.outputEncoding>
	</properties>

	<!-- Module의 부모 Starter 불러오기 -->
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-dependencies</artifactId>
				<version>2.5.6</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<dependencies>

		<!-- spring boot basic dependency -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<!-- spring boot test -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-test</artifactId>
		</dependency>

	</dependencies>

	<build>
		<finalName>helloworld</finalName>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>

			</plugin>
		</plugins>
	</build>

</project>
```

- 실행 코드
```java
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
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
```

- 결과
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.6)

2022-02-10 12:08:22.364  INFO 3444 --- [           main] ex01.HelloWorldApplication               : Starting HelloWorldApplication using Java 14.0.2 on DESKTOP-EHGSDDI with PID 3444 (D:\BIT\bit-Java\springboot-practices\helloworld\target\classes started by BIT in D:\BIT\bit-Java\springboot-practices\helloworld)
2022-02-10 12:08:22.367  INFO 3444 --- [           main] ex01.HelloWorldApplication               : No active profile set, falling back to default profiles: default
2022-02-10 12:08:22.841  INFO 3444 --- [           main] ex01.HelloWorldApplication               : Started HelloWorldApplication in 0.85 seconds (JVM running for 1.696)

```
