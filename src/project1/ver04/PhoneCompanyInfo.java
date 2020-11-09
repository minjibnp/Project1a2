package project1.ver04;

public class PhoneCompanyInfo extends PhoneInfo {//PhoneInfo클래스를 상속. 
	
	String company;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	
	@Override
	public void showPhoneInfo() {//이름과 전화번호는 이미 받아오고 회사정보만 추가해준다
		
		super.showPhoneInfo();
		System.out.println("Company:"+company);
	}
	
}
