___

## Spirng Container
- Bean(Object) 관리 = bean 생성 + dependency 관리 (Depedency Injection : **_wiring_**)

> ||Feature|`XML`|`Java`|
> |:---:|:---:|---|---|
> |**Auto**|Annotation, Auto Scan<br>(@Component, @Service, @Controller, @Autowired)|`<context:annotation-config />`|`@Configuration`<br>`@ComponentScan(basePackages = { "com.poscoict.container.soundsystem" })`|
> |**Explicity**|bean|`<bean />`| : 



## IoC / Wiring

+ user : Observer / Test

- soundSystem : auto wiring (java, xml config) - Annotation<br>
- videoSystem : explicit wiring (java, xml config) - Bean<br>

### Tree
```
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂poscoict
 ┃ ┃ ┃ ┃ ┗ 📂container
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂soundsystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CDPlayerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AppConfig01.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AppConfig02.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂videosystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mixing
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DvdPlayerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂soundsystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CDPlayer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CompactDisc.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HighSchoolRapper2Final.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂test
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AppConfigTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜XmlConfigTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Friend.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User1.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂videosystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Avengers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BlankDisc.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DigitalVideoDisc.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DVDPack.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DVDPlayer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜IronMan.java
 ┃ ┗ 📂resources
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂poscoict
 ┃ ┃ ┃ ┃ ┗ 📂container
 ┃ ┃ ┃ ┃ ┃ ┗ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂soundsystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CDPlayerConfig.xml
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜applicationContext01.xml
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜applicationContext02.xml
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂videosystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DVDPlayerConfig.xml
 ┗ 📂test
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂poscoict
 ┃ ┃ ┃ ┃ ┗ 📂container
 ┃ ┃ ┃ ┃ ┃ ┣ 📂soundsystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CDPlayerJavaConfigTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CDPlayerXmlConfigTest.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂videosystem
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DvdPlayerJavaConfigTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DvdPlayerXmlConfigTest.java
 ┃ ┗ 📂resources
```

### XML-Config
- auto

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
        http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
        http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task.xsd">

	<!-- auto proxy -->
	<aop:aspectj-autoproxy />

	<context:annotation-config />

	<context:component-scan
		base-package="com.poscoict.container.user">
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Repository" />
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Service" />
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Component" />
	</context:component-scan>


</beans>
```

- explicit
	
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
        http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
        http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task.xsd">

	<bean id="user1" class="com.poscoict.container.user.User1" />

	<!-- 기본 생성자로 빈 생성 -->
	<bean id="user" name="usr" class="com.poscoict.container.user.User" />

	<!-- 파라미터 1개인 생성자로 빈 생성 -->
	<bean id="user2" class="com.poscoict.container.user.User">
		<constructor-arg value="둘리" />
	</bean>

	<!-- 파라미터 2개인 생성자로 빈 생성1 -->
	<bean id="user3" class="com.poscoict.container.user.User">
		<constructor-arg value="3" />
		<constructor-arg value="마이콜" ></constructor-arg>
	</bean>
	
	<!-- 파라미터 2개인 생성자로 빈 생성2 (parameter 순서 변경) -->
	<bean id="user4" class="com.poscoict.container.user.User">
		<constructor-arg index="1" value="마이콜" />
		<constructor-arg index="0" value="4" />
	</bean>
	
	<!-- Setter 사용하여 빈 생성 -->
	<bean id="user5" class="com.poscoict.container.user.User">
		<property name="name" value="도우너" />
		<property name="no" value="5" />
	</bean>

	<!-- 의존성 주입 - DI  / Wiring -->
	<bean id="friend" class="com.poscoict.container.user.Friend">
		<constructor-arg value="고길동" />
	</bean>
	<bean id="user6" class="com.poscoict.container.user.User">
		<property name="name" value="영희" />
		<property name="no" value="6" />
		<property name="friend" ref="friend" />
	</bean>
	
	<!-- Setter를 사용한 List 세팅 -->
	<bean id="user7" class="com.poscoict.container.user.User">
		<property name="no" value="7" />
		<property name="name" value="아이언맨" />
		<property name="friends" >
			<list>
				<value>스타이더맨</value>
				<value>캡핀아메리카</value>
				<value>헐끄니까~</value>
			</list>
		</property>
	</bean>

</beans>

```

### Java-Config

```java
@Configuration
public class AppConfig02 {
	
	@Bean
	public User user() {
		return new User("둘리");
	}

}
```

___

### BeanFactory
- XML-Config

```java
public class XmlConfigTest {

	public static void main(String[] args) {
		testBeanFactory01();
		testBeanFactory02();
	}

	// XML Auto Configuration (Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 됨
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Bean Configuration (Explicit Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 되지 않음
		// 명시적으로 설정 필요 (xml bean에 id=""으로 설정)
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}
}
```

### ApplicationContext
- XML-Config

```java
public class XmlConfigTest {

	public static void main(String[] args) {
		
		testApplicationContext01();
		testApplicationContext02();
	}
	
	// XML Auto Configuration (Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext01.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 됨
		user1 = (User1) ac.getBean("user1");
		System.out.println(user1.getName());
	}
	
	// XML Bean Configuration (Explicit Configuration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext02.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 되지 않음
		// 명시적으로 설정 필요 (xml bean에 id=""으로 설정)
		user1 = (User1) ac.getBean("user1");
		System.out.println(user1.getName());
	}
```

- Java-Config

```java
public class AppConfigTest {
	
	public static void main(String[] args) {
		testAppConfig01();
		testAppConfig02();
	}
	
	// Java Config 1
	// 직접 자바 클래스(Config Class)를 전달
	public static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}
	
	// Java Config 2
	// 직접 자바 클래스(Config Class)를 전달
	// Class에 @Configuration 추가
	public static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.poscoict.container.config.user");
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}

}
```

