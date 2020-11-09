package project1.ver07;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneInfo implements Serializable{
	
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

	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		return hc1;
	}

	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo pi = (PhoneInfo)obj;//객체생성이 아니라 불러와주는것
//		System.out.println("이미 저장된 데이터입니다.");
//		System.out.println("덮어쓸까요? Y(y) / N(n)");
//		Scanner sc = new Scanner(System.in);
//		String dupInfo = sc.nextLine();
		
		if(this.name.equals(pi.name)) {
		}

		return true;
	}
}



