package myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyWebAppication {

	@Controller
	public class HelloController {

		@GetMapping("/hello")
		public String hello01() {
			return "hello";
		}
	}

	@RestController
	public class HelloController02 {

		@GetMapping("/hello2")
		public String hello02() {
			return "<h1>Hello World 02</h1>";
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(MyWebAppication.class, args);
	}

}
