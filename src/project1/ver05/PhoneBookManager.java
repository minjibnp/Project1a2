package project1.ver05;

import java.util.Scanner;

import project1.ver05.PhoneInfo;


public class PhoneBookManager implements SubMenuItem{//인터페이스 구현받음
	
	public PhoneInfo[] pInfo;
	public int numOfpInfo;
	
	public PhoneBookManager (int num) {
		pInfo = new PhoneInfo[num];
		numOfpInfo = 0;
	}
	
	//데이터입력
	public void dataInput(int choice) {
		Scanner sc = new Scanner(System.in);
		String iName , iphoneN, iCompany, major;
		int grade;
	
		System.out.println("데이터 입력을 시작합니다!");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.println("선택>>");

		int choice1 = sc.nextInt();
		sc.nextLine();
		System.out.println("이름:");iName = sc.nextLine();
		System.out.println("전화번호:");iphoneN = sc.nextLine();
		
		
			if(choice1==BASE) {//구현한 인터페이스를 사용한다
				
				PhoneInfo base =
						new PhoneInfo(iName, iphoneN);
				pInfo[numOfpInfo++] = base;
			}
			else if(choice1==SCHOOL) {

				System.out.println("전공:");major = sc.nextLine();
				System.out.println("학년:");grade = sc.nextInt();
				PhoneSchoolInfo base1 = new PhoneSchoolInfo(iName, iphoneN, major, grade);
				pInfo[numOfpInfo++] = base1;
			}
			else if(choice1==COMPANY) {

				System.out.println("회사:");iCompany=sc.nextLine();
				PhoneCompanyInfo base2 = new PhoneCompanyInfo(iName, iphoneN, iCompany);
				pInfo[numOfpInfo++]=base2;
				
			}
			else {
				System.out.println("1,2,3 중 하나를 입력해주세요");
			}
		
	
	}

	//데이터 검색
	public void dataSearch() {
		boolean isFind = false;//검색한 정보 확인을 위한 변수
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다!");		
		String searchN = sc.nextLine();
		
		for(int i=0; i<numOfpInfo;i++) {
			System.out.print("검색할 이름:"+pInfo[i].name);
			
			if(searchN.compareTo(pInfo[i].name)==0) {
				pInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("일치하는 정보가 없습니다.");
		
	}//end of search
	
	//데이터삭제
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다!");
		System.out.print("이름:");
		String deleteN = sc.nextLine();

		int deleteIdx = -1;//배열의 index이므로 초기값은 -1로 설정
		
		for(int i=0; i<numOfpInfo; i++) {
			if(deleteN.compareTo(pInfo[i].name)==0) {
				//요소 삭제를 위해 null값으로 변경
				pInfo[i]=null;
				//삭제된요소의 인덱스를 저장
				deleteIdx = i;
				//전체 저장된 정보중 -1 차감
				numOfpInfo--;
			}
		}
		
		if(deleteIdx==-1) {
			//검색한 데이터가 없어 삭제되지 않을때
			System.out.println("일치정보 없음. 삭제된 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIdx; i<numOfpInfo; i++) {
				pInfo[i] = pInfo[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
		
	}//end of delete
	public void dataAllShow() {
		for(int i=0; i<numOfpInfo;i++) {
			
			pInfo[i].showPhoneInfo();
		}
	}
	
	public static void printMenu() {
		System.out.println("메뉴를 선택하세요!");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.println("선택:");
		
	}
	

	
}//end of handler
	

