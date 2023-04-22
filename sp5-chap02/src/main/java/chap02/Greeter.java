package chap02;

public class Greeter {
	private String format;
	
	// format 필드는 setFormat() 메소드로 설정함
	public String greet(String guest) {
		return String.format(format, guest);
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	// Greeter 클래스를 사용하는 코드
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요!");
		String msg = greeter.greet("스프링");	// msg는 "스프링, 안녕하세요!"가 된다.
	}
}