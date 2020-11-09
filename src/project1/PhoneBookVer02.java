package project1;

import java.util.Scanner;
import project1.ver02.PhoneInfo;


public class PhoneBookVer02 {
		
	public static void main(String[] args) {
		
						
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {//프로그램이 유지되도록 while문 사용
			System.out.println("선택하세요...");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택:");
			
			int choiceN=0;//선택옵션
			choiceN=sc.nextInt();
			sc.nextLine();//버퍼 없애주기
			
			if(choiceN==1) {								
				System.out.print("이름:");
				String name=sc.nextLine();//사용자로부터  데이터를 입력받는 형식으로 전환	
				System.out.print("전화번호:");
				String phoneNumber=sc.nextLine();
				System.out.print("생년월일:");
				String birthday=sc.nextLine();
				
				PhoneInfo p = new PhoneInfo(name, phoneNumber, birthday);//변수 3개인 생성자 찾아가기
				p.showPhoneInfo();
				System.out.println();
				
			}
			else if(choiceN==2){
				System.out.println("프로그램을 종료합니다.");
				break;//종료시 탈출
			}
			else {
				System.out.println("1또는 2를 입력하세요");
				System.out.println();
			}
			
		}
		
	}
}
