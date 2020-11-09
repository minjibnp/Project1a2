package project1.ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import project1.ver07.*;


public class PhoneBookManager implements SubMenuItem{
	
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();//해시셋 선언. 중복저장을 허용하지 않게한다.
	public int numOfpInfo;//한명 정보 추가시 1씩 증가
	
	
	//생성자-인자로 전달되는 num크기의 객체배열 생성
//	public PhoneBookManager (int num) {
//	
//		numOfpInfo = 0;
//	}	
		
	// 데이터입력
	public void dataInput(int choice) {
		Scanner sc = new Scanner(System.in);
		String iName, iphoneN, iCompany, major, grade;

		System.out.println("데이터 입력을 시작합니다!");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.println("선택>>");

		try {

			int choice1 = sc.nextInt();
			sc.nextLine();
			

			if (choice1 == BASE) {// 일반친구
				System.out.print("이름:");
				iName = sc.nextLine();
				System.out.print("전화번호:");
				iphoneN = sc.nextLine();
				PhoneInfo pInf = new PhoneInfo(iName, iphoneN);
				boolean base = set.add(pInf);//중복저장 확인용 메소드
//               PhoneInfos.add(ph1);
				if (!(base)) {
					System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
					Scanner scan = new Scanner(System.in);
					String str = scan.nextLine();
					if (str.equalsIgnoreCase("y")) {
						if (!(base)) {
							set.remove(pInf);//중복데이터를 해시셋에서 삭제
							set.add(pInf);//새 데이터를 추가
							// break;
						}
						set.add(new PhoneInfo(iName, iphoneN));
						System.out.println("덮어쓰기가 완료되었습니다.");
					}
					if (str.equalsIgnoreCase("n")) {
						System.out.println("덮어쓰기에 실패했습니다.");
					}

				}
			}

			else if (choice1 == SCHOOL) {
				System.out.print("이름:");
				iName = sc.nextLine();
				System.out.print("전화번호:");
				iphoneN = sc.nextLine();
				System.out.print("전공:");
				major = sc.nextLine();
				System.out.print("학년:");
				grade = sc.nextLine();
				PhoneSchoolInfo pInf2 = new PhoneSchoolInfo(iName, iphoneN, major, grade);
				boolean school = set.add(pInf2);
//               PhoneInfos.add(ph2);
				if (!(school)) {
					System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
					Scanner scan = new Scanner(System.in);
					String str = scan.nextLine();
					if (str.equalsIgnoreCase("y")) {
						if (!(school)) {
							set.remove(pInf2);
							set.add(pInf2);
							// break;
//                           }
//                        }
							set.add(new PhoneSchoolInfo(iName, iphoneN, major, grade));
							System.out.println("덮어쓰기가 완료되었습니다.");
						}
						if (str.equalsIgnoreCase("n")) {
							System.out.println("덮어쓰기에 실패했습니다.");
						}
					}

					// set.add(new PhoneSchoolInfo(iName, iphoneN, major, grade));
				}
			}
				
			else if (choice1 == COMPANY) {
					System.out.print("이름:");
					iName = sc.nextLine();
					System.out.print("전화번호:");
					iphoneN = sc.nextLine();
					System.out.print("회사:");
					iCompany = sc.nextLine();
					PhoneCompanyInfo pInf3 = new PhoneCompanyInfo(iName, iphoneN, iCompany);
					boolean company = set.add(pInf3);
//             PhoneInfos.add(ph3);
					if (!(company)) {
						System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
						Scanner scan = new Scanner(System.in);
						String str = scan.nextLine();
						if (str.equalsIgnoreCase("y")) {
							if (!(company)) {
								set.remove(pInf3);
								set.add(pInf3);
								// break;
//                           }
//                        }
								set.add(new PhoneCompanyInfo(iName, iphoneN, iCompany));
								System.out.println("덮어쓰기가 완료되었습니다.");
							}
							if (str.equalsIgnoreCase("n")) {
								System.out.println("덮어쓰기에 실패했습니다.");
							}
						}
						 set.add(new PhoneCompanyInfo(iName, iphoneN, iCompany));
				
					}
			
		}
		else if(choice1>3 || choice1<0){
			System.out.println("1,2,3 중 하나를 입력해주세요");
					
			}	
		}
	
		catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다.");
			e.printStackTrace();
		}
}

	//데이터 검색
	public void dataSearch() {
		boolean isFind = false;//검색한 정보 확인을 위한 변수
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다!");		
		System.out.print("검색할 이름:");
		String searchN = sc.nextLine();
		
		try {
			for(PhoneInfo phoneInfo:set) {
				//System.out.println("검색할 이름:"+searchN);
				
				if(searchN.equals(phoneInfo.name)) {
					phoneInfo.showPhoneInfo();
					System.out.println("데이터 검색이 완료되었습니다.");
					isFind = true;
				}
				if(isFind==false)
					System.out.println("일치하는 정보가 없습니다.");
			}		
		}
	

	catch (NullPointerException e) {
		System.out.println("검색결과가 없습니다.");
		e.printStackTrace();
		}//end of search
	}
	//데이터삭제
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다!");
		System.out.print("이름:");
		String deleteN = sc.nextLine();
		
		//삭제 불가능할시 알림을 위해 설정
		boolean deleteFlag=false;
		
		Iterator<PhoneInfo> itr = set.iterator();//이터레이터로 데이터를 돌린다
		
		while(itr.hasNext()) {//읽어올 데이터를 확인
			PhoneInfo phoneInfo = itr.next();
			
			if(deleteN.equals(phoneInfo.name)) {//equals로 비교
				set.remove(phoneInfo);
				System.out.println("데이터 삭제가 완료되었습니다.");
				deleteFlag = true;
				break;
			}
		}
		//검색 불가능할시
		if(deleteFlag==false) {
			System.out.println("삭제된 데이터가 없습니다.");
			
		}
		
		
	}//end of delete
	public void dataAllShow() {
		for(PhoneInfo phoneInfo:set) {
			
			phoneInfo.showPhoneInfo();
		}
	}//데이터 전체출력
	
	public static void printMenu() {
		
		System.out.println("메뉴를 선택하세요!");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택:");
		
	}
	
	
}//end of handler

