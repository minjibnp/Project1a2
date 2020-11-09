package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;

public class PhoneBookVer06 implements MenuItem {

		
	public static void main(String[] args) throws MenuSelectException {

		PhoneBookManager pm = new PhoneBookManager(100);
		
		while(true) {
			
			pm.printMenu();
			
			Scanner scanner = new Scanner(System.in);
			try {
				int choice = scanner.nextInt();
				if(choice>5||choice<0) {
					MenuSelectException ex = new MenuSelectException();//개발자정의 예외처리
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
			
				catch (InputMismatchException e) {//문자 입력을 불가능하게 예외처리
					System.out.println("숫자만 입력 가능합니다.");
				}
		}
		
	}

}
/*
 		catch (MenuSelectException e) {
			System.out.println(e.getMessage());
		}
 */


/*
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

}

}
*/