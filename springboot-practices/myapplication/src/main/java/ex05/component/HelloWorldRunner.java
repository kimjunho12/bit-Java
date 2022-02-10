package ex05.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRunner implements ApplicationRunner {

	@Autowired
	private MyComponent myComponent;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		myComponent.printHello();
	}

}
