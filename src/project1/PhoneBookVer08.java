package project1;

import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;

public class PhoneBookVer08 implements MenuItem {
    
      
   public static void main(String[] args) throws MenuSelectException {

	   
	 
      PhoneBookManager pm = new PhoneBookManager();
      pm.loadData();//while문 전에, 프로그램 시작 직후에 데이터 로드
      
     
      
      while(true) {
    	  
         
         pm.printMenu();
         
         Scanner scanner = new Scanner(System.in);
         try {
            int choice = scanner.nextInt();
            if(choice>6||choice<0) {
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
         case SAVE:
            pm.saveOption();
            break;
         case EXIT:
            System.out.println("obj 파일로 저장되었습니다.");
            System.out.println("프로그램 종료");
            pm.saveData();//종료 직전에 데이터 저장
            return;
         }
         }   catch (MenuSelectException e) {
            System.err.println(e.getMessage());
         }
         
            catch (InputMismatchException e) {
               System.out.println("숫자만 입력 가능합니다.");
            }
         
      }
      
   }

}