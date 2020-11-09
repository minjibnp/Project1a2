package project1.ver09;

import java.util.Scanner;

//	
//	//멤버변수
//	String name;
//	String phoneN;
//	String bDay;
//	//생성자메소드	
//	public PhoneInfo(String name, String phoneN, String bDay) {
//		this.name = name;
//		this.phoneN = phoneN;
//		this.bDay = bDay;
//	}
//	//주소록 전체출력 멤버메소드	
//
//}


public class PhoneBookManager {
	
	public PhoneInfo[] pInfo;
	public int numOfpInfo;//한명 정보 추가시 1씩 증가
	String iName, iphoneN, ibDay;
	
	//생성자-인자로 전달되는 num크기의 객체배열 생성
	public PhoneBookManager (int num) {
		pInfo = new PhoneInfo[num];
		numOfpInfo = 0;
	}
	
	//데이터입력
	public void dataInput() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("데이터 입력을 시작합니다!");
		System.out.print("이름:");iName = sc.nextLine();
		System.out.print("전화번호:");iphoneN = sc.nextLine();
		System.out.print("생년월일:");ibDay = sc.nextLine();
		PhoneInfo pi = new PhoneInfo(iName, iphoneN, ibDay);
		pInfo[numOfpInfo++]=pi;
		System.out.println("데이터 입력 완료");
		
		new InsertInfo(iName, iphoneN, ibDay).execute();
	
	}
	//데이터 검색
	public void dataSearch() {
		boolean isFind = false;//검색한 정보 확인을 위한 변수
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다!");	
		System.out.print("이름:");
		String searchN = sc.nextLine();
		
		new SearchInfo(searchN).execute();
		
		
//		for(int i=0; i<numOfpInfo;i++) {
//			System.out.print("검색할 이름:"+pInfo[i].name);
//			
//			if(searchN.compareTo(pInfo[i].name)==0) {
//				pInfo[i].showPhoneInfo();
//				System.out.println("데이터 검색이 완료되었습니다.");
//				isFind = true;
//			}
//		}
//		if(isFind==false)
//			System.out.println("일치하는 정보가 없습니다.");
		
	}//end of search
	
	//데이터삭제
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다!");
		System.out.print("이름:");
		String deleteN = sc.nextLine();
		new DeleteInfo(deleteN).execute();

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
	
	public void printMenu() {
		System.out.println("메뉴를 선택하세요!");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.println("선택:");
		
	}
	
}//end of handler
	

