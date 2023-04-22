package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	// MemberRegisterService 객체와 ChangePasswordService 객체에 대한 의존을 주입한다.
	// MemberRegisterService는 생성자를 통해 MemberDao 객체를 주입받고,
	// ChangePasswordService는 세터를 통해 주입받는다.
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}

// Assembler 클래스를 사용하는 코드는 다음처럼 Assembler 객체를 생성한다.
// 그다음에 get 메소드를 이용해서 필요한 객체를 구하고 그 객체를 사용한다.
// Assembler assembler = new Assembler();
// ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
// changePwdSvc.changePassword("madvirus@madvirus.net", "1234", "newpwd");
// assembler.getChangePasswordService()로 구한 ChangePasswordService 객체는
// 19행에서 생성한 객체이므로 세터를 통해 MemberDao 객체를 주입받은 객체이다.

// MemberDao 클래스가 아니라 MemberDao 클래스를 상속받은 CachedMemberDao 클래스를 사용해야 한다면
// Assembler에서 객체를 초기화하는 코드만 변경하면 된다.
//	public Assembler() {
//		memberDao = new CachedMemberDao();
//		regSvc = new MemberRegisterService(memberDao);
//		pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao);
//	}
