package project1.ver08;

public class PhoneSchoolInfo extends PhoneInfo {

		String major,grade;
		
		public PhoneSchoolInfo(String name, String phoneNumber, String major, String grade) {
			super(name, phoneNumber);
			this.major = major;
			this.grade = grade;
		}
		@Override
		public String getInfo() {

			return super.getInfo()+"전공:"+major+"\n학년:"+grade+"\n";
			
		}
		
		@Override
		public void showPhoneInfo() {
			super.showPhoneInfo();
			System.out.println("Major:"+major);
			System.out.println("Grade:"+grade);
		}
	
}
