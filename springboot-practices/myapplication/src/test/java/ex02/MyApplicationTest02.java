package ex02;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/* @Configuration 설정 클래스는 자동으로 찾지 못함 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {MyApplication.class})
@SpringBootTest
public class MyApplicationTest02 {

	@Autowired
	private MyComponent myComponent;

	@Test
	public void myComponentNotNull() {
		assertNotNull(myComponent);
	}
}
