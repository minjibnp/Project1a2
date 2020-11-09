package project1.ver05;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}




	public void showPhoneInfo(){
		System.out.println("입력된 정보 출력...");
		System.out.println("name:"+name);
		System.out.println("phone:"+phoneNumber);
		
	}

}
