package project1;

import java.util.Scanner;

import project1.ver03.PhoneBookManager_R;

public class PhoneBookVer03 {

	public static void main(String[] args) {

		PhoneBookManager_R pm = new PhoneBookManager_R(100);//정보를 100개까지 유지되게 한다
		
		while(true) {
			
			pm.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: 
				pm.dataInput();
				break;
			case 2:
				pm.dataSearch();
				break;
			case 3:
				pm.dataDelete();
				break;
			case 4:
				pm.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램 종료");
				return;
			}
			
		}
		
	}

}
