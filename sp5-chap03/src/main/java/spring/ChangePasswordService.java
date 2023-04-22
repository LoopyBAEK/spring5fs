package spring;

public class ChangePasswordService {
	// 의존 객체 직접 생성
//	private MemberDao memberDao = new CachedMemberDao();
	
	// DI 사용
	private MemberDao memberDao;
	
//	public ChangePasswordService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	public void changePassword(String email, String oldPwd, String newPwd) throws MemberNotFoundException {
		Member member = memberDao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
