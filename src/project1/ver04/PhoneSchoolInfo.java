package project1.ver04;

public class PhoneSchoolInfo extends PhoneInfo {//폰인포 클래스 상속받음

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
