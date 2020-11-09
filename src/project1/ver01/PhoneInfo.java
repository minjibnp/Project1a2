package project1.ver01;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	
	public PhoneInfo(String name, String phoneNumber) {//생성자 변수 2개
		this.name = name;
		this.phoneNumber = phoneNumber;
		birthday="생년월일은 필수 입력사항이 아닙니다";
	}


	public PhoneInfo(String name, String phoneNumber, String birthday) {//생성자 변수 3개
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}


	public void showPhoneInfo(){//정보출력
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("생년월일:"+birthday);
		
	}

}
