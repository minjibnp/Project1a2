package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.MenuItem;
import project1.ver07.MenuSelectException;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer07 implements MenuItem {

		
	public static void main(String[] args) throws MenuSelectException {

		PhoneBookManager pm = new PhoneBookManager();//배열저장용 변수를 없앰
		
		while(true) {
			
			pm.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			try {
				int choice = scanner.nextInt();
				if(choice>5||choice<0) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			switch (choice) {
			case DATA_INPUT:
				pm.dataInput(choice);				
				break;
			case DATA_SEARCH:
				pm.dataSearch();
				break;
			case DATA_DELETE:
				pm.dataDelete();
				break;
			case DATA_ALLSHOW:
				pm.dataAllShow();
				break;
			case EXIT:
				System.out.println("프로그램 종료");
				return;
			}
			}	catch (MenuSelectException e) {
				System.err.println(e.getMessage());
			}
			
				catch (InputMismatchException e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
			
		}
		
	}

}
