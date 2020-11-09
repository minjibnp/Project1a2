package project1.ver02;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		birthday="생년월일은 필수 입력사항이 아닙니다";
	}


	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}


	public void showPhoneInfo(){
		System.out.println("입력된 정보 출력...");
		System.out.println("name:"+name);
		System.out.println("phone:"+phoneNumber);
		System.out.println("birth:"+birthday);
		
	}

}
