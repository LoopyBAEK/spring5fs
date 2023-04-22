package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration	// 이 어노테이션을 붙여야 스프링 설정 클래스로 사용할 수 있다.
public class AppCtx {
	
	// @Bean 어노테이션은 해당 메소드가 생성한 객체를 스프링 빈이라고 설정한다. 각각의 메소드마다 한 개의 빈 객체를 생성한다.
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		// memberDao()가 생성한 객체를 MemberRegisterService 생성자를 통해 주입한다.
		return new MemberRegisterService(memberDao());
	}
	
	// ChangePasswordService 타입의 빈을 생성한다. 이 메소드는 세터(setMemberDao())를 이용해서 의존 객체를 주입한다.
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
}
