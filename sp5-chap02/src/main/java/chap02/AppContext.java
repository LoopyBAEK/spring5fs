package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// 해당 클래스를 스프링 설정 클래스로 지정하는 어노테이션
public class AppContext {
	
	// "greeter"에 해당하는 객체 한 개와 "greeter1"에 해당하는 객체 한 개, 이렇게 두 개의 빈 객체가 생성된다.
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s 안녕하세요!");
		return g;
	}
	
	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter();
		g.setFormat("안녕하세요, %s님!");
		return g;
	}
}
