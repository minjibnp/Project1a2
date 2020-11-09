package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo {
	
	String company;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	
	@Override
	public String getInfo() {
		
		return super.getInfo()+"회사:" + company+"\n";
	}
	@Override
	public void showPhoneInfo() {
		
		super.showPhoneInfo();
		System.out.println("Company:"+company);
	}
	
}
