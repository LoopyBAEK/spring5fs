package chap02;

//AnnotationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		// AnnotationConfigApplicationContext 객체를 생성할 때 앞서 작성한 AppContext 클래스를 생성자 파라미터로 전달한다.
		// AnnotationConfigApplicationContext는 AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화한다.
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		// getBean()메소드는 AnnotationConfigApplicationContext가 자바 설정을 읽어와 생성한 빈(bean) 객체를
		// 검색할 때 사용된다. getBean() 메소드의 첫 번째 파라미터는 @Bean 어노테이션의 메소드 이름인 빈 객체의 이름이며,
		// 두 번째 파라미터는 검색할 빈 객체의 타입이다. 앞서 작성한 자바 설정(AppContext)을 보면
		// @Bean 메소드의 이름이 "greeter"이고 생성한 객체의 리턴 타입이 Greeter이므로,
		// 18행의 getBean() 메소드는 greeter() 메소드가 생성한 Greeter객체를 리턴한다.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		// g.greet("스프링") 코드는 다음의 코드와 동일한 결과를 생성한다.
		// String.format("%s, 안녕하세요!", "스프링") -> "스프링, 안녕하세요!"
		System.out.println(msg);
		ctx.close();
	}
	
	// 1. (11행)설정 정보를 이용해서 빈 객체를 생성한다.
	// 2. (18행)빈 객체를 제공한다.
}
