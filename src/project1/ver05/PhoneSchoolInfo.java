package project1.ver05;

public class PhoneSchoolInfo extends PhoneInfo {

		String major;
		int grade;
		
		public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
			super(name, phoneNumber);
			this.major = major;
			this.grade = grade;
		}
		
		@Override
		public void showPhoneInfo() {
			super.showPhoneInfo();
			System.out.println("Major:"+major);
			System.out.println("Grade:"+grade);
		}
	
}
