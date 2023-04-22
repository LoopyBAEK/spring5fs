package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		// 10행과 11행은 이름이 "greeter"인 빈 객체를 구해서 각각 g1과 g2 변수에 할당한다.
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		// 13행에서는 g1과 g2가 같은 객체인지 여부를 콘솔에 출력한다.
		// 출력 결과 : (g1 == g2) = true
		// g1과 g2가 같은 객체라는 것을 의미한다. 즉, 10행과 11행에서 getBean() 메소드는 같은 객체를 리턴하는 것이다.
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}
