package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	// 의존 객체를 직접 생성
//	private MemberDao memberDao = new CachedMemberDao();
	
	// MemberRegisterService 클래스에서 의존하는 MemberDao 객체를 직접 생성하기 때문에
	// MemberRegisterService 객체를 생성하는 순간에 MemberDao 객체도 함께 생성된다.
	// 의존하는 MemberDao의 객체도 함께 생성
//	MemberRegisterService svc = new MemberRegisterService();
	
	// DI 사용
	// 직접 의존 객체를 생성했던 코드와 달리 바뀐 코드는 의존 객체를 직접 생성하지 않는다.
	private MemberDao memberDao;
	
	// 생성자를 통해서 의존 객체를 전달받는다.
	// 생성자를 통해 MemberRegisterService가 의존(Dependency)하고 있는 MemberDao 객체를 주입(Injection) 받은 것이다.
	// 의존 객체를 직접 구하지 않고 생성자를 통해서 전달받기 때문에 이 코드는 DI(의존 주입) 패턴을 따르고 있다.
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// DI를 적용한 결과 MemberRegisterService 클래스를 사용하는 코드는
	// 다음과 같이 MemberRegisterService 객체를 생성할 때 MemberDao 객체를 전달해야 한다.
//	MemberDao dao = new MemberDao();
	// 의존 객체를 생성자를 통해 주입한다.
//	MemberRegisterService svc = new MemberRegisterService(dao);
	
	public Long regist(RegisterRequest req) {
		// 이메일로 회원 데이터(Member) 조회
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null) {
			// 같은 이메일을 가진 회원이 이미 존재하면 익셉션 발생
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		// 같은 이메일을 가진 회원이 존재하지 않으면 DB에 삽입
		Member newMember = new Member(
			req.getEmail(), req.getPassword(), req.getName(),
			LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
