package project1.ver08;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import project1.ver08.*;


public class PhoneBookManager implements SubMenuItem {

	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	public int numOfpInfo;// 한명 정보 추가시 1씩 증가
	AutoSaverT as1 = null;//쓰레드 참조용
	int save = 0;//자동저장 옵션을 위한 변수

	ObjectOutputStream personI = null;// 변수생성
	FileOutputStream pInfo = null;// 변수생성

	ObjectInputStream ois = null;
	FileInputStream fis = null;

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
				boolean base = set.add(pInf);
//               PhoneInfos.add(ph1);
				if (!(base)) {//phoneInfo에서 이미 hashcode로 true반환. true가 아니면 중복발견
					System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
					Scanner scan = new Scanner(System.in);
					String str = scan.nextLine();
					if (str.equalsIgnoreCase("y")) {
						if (!(base)) {
							set.remove(pInf);
							set.add(pInf);
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
						 //set.add(new PhoneCompanyInfo(iName, iphoneN, iCompany));
						 
						} 

				
		}	
		else if (choice1 > 3 || choice1 < 0) {
			System.out.println("1,2,3 중 하나를 입력해주세요");
			}
		}

		catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다.");
			e.printStackTrace();
		}
}
	//텍스트파일 저장
	public void saveTxt() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
			Iterator<PhoneInfo> itr = set.iterator();// 해시셋에 저장된 모든 객체를 파일에 저장하기 위해 이터레이터
			while (itr.hasNext()) {// while문으로 저장한 데이터의 객체를 돌린다
				PhoneInfo phoneI = itr.next();//객체를 담아서 itr에 저장한다
				out.printf(phoneI.getInfo());
				//System.out.println("정보:"+phoneI.getInfo());
			}
			//프린트 writer로 txt파일 경로 설정하고 이터레이터로 반복해주면서 phoneinfo타입으로 받고, 게터 이용해서 printf에 적용
			out.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		catch (IOException e) {
			System.out.println("IO오류 발생");
		}
	}
	public void saveData() {
		try {
			pInfo = new FileOutputStream("PhoneBook.obj");
			personI = new ObjectOutputStream(pInfo);// 파일아웃풋스트림 가져오려고
			personI.writeObject(set.size());// 해시셋의 크기를 알기위해
			Iterator<PhoneInfo> itr = set.iterator();// 해시셋에 저장된 모든 객체를 파일에 저장하기 위해 이터레이터
			while (itr.hasNext()) {// while문으로 저장한 데이터의 객체를 돌린다
				personI.writeObject(itr.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 스트림을 닫아준다
			if (pInfo != null)
				try {
					pInfo.close();
				} catch (IOException e) {
				}
			if (personI != null)
				try {
					personI.close();
				} catch (IOException e) {
				
				}

		}
	}

	public void loadData() {
		try {
			fis = new FileInputStream("PhoneBook.obj");// 파일을 읽어오는 객체
			ois = new ObjectInputStream(fis);// fis에서 읽어온 파일을 객체형으로 바꿔준다
			// ObjectInputStream으로 부터 객체 하나씩 읽어서 출력한다.
			// (UserClass) 로 형변환을 작성해야 한다.
			// System.out.println 으로 객체의 구현된 toString() 함수를 호출한다.
			int size = (int) ois.readObject();// 해시셋의 사이즈를 불러온다. int 형변환 한다.
			for (int i = 0; i < size; i++) {// for문 안에서 해시셋의 사이즈만큼 돌려준다
				PhoneInfo pi = (PhoneInfo) ois.readObject();// 출력, 해시셋에 저장 둘다 하기 위해서
				// System.out.println(pi);//readobject를 한번하면 다음으로 넘어가서 달라질수있으니 저장
				set.add(pi);// 해시셋에 더해주기
			}

		} catch (Exception e) {
			// e.printStackTrace();
		} finally {

			// 스트림을 닫아준다.
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
				}
		}
	}

	// 데이터 검색
	public void dataSearch() {
		boolean isFind = false;// 검색한 정보 확인을 위한 변수
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다! 검색할 이름을 입력하세요.");
		System.out.println("검색할 이름:");
		String searchN = sc.nextLine();

		try {
			for (PhoneInfo phoneInfo : set) {
				// System.out.println("검색할 이름:"+searchN);

				if (searchN.equals(phoneInfo.name)) {
					phoneInfo.showPhoneInfo();
					System.out.println("데이터 검색이 완료되었습니다.");
					isFind = true;
				}
			}
			if (isFind == false) {
				System.out.println("일치하는 정보가 없습니다.");
			}
		}

		catch (NullPointerException e) {
			System.out.println("검색결과가 없습니다.");
			e.printStackTrace();
		} // end of search
	}

	// 데이터삭제
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다!");
		System.out.print("이름:");
		String deleteN = sc.nextLine();

		// 삭제 불가능할시 알림을 위해 설정
		boolean deleteFlag = false;

		Iterator<PhoneInfo> itr = set.iterator();

		while (itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();

			if (deleteN.equals(phoneInfo.name)) {
				set.remove(phoneInfo);
				System.out.println("데이터 삭제가 완료되었습니다.");
				deleteFlag = true;
				break;
			}
		}
		// 검색 불가능할시
		if (deleteFlag == false) {
			System.out.println("삭제된 데이터가 없습니다.");

		}

	}// end of delete

	public void dataAllShow() {
		for (PhoneInfo phoneInfo : set) {

			phoneInfo.showPhoneInfo();
		}
	}// 데이터 전체출력
	
	
	//AutoSaverT as2 = new AutoSaverT(this);
    
    public void saveOption() {
		System.out.println("===저장옵션선택===");
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1.자동저장 On / 2.자동저장 Off");
       
		Scanner sc = new Scanner(System.in);
        int saveChoice = sc.nextInt();
        sc.nextLine();
       
       
       if(saveChoice==1 && save==1) {//save변수를 위에 선언해주고 가져와서 비교한다.
          System.out.println("이미 자동저장이 실행중입니다.");
       }
       else if(saveChoice==1 && save!=1) {
          as1 = new AutoSaverT(this);
          System.out.println("자동저장을 시작합니다.");
          as1.setDaemon(true); //셋데몬
          as1.start();//자동저장 시작
          
          save = 1;
       }
       else if(saveChoice==2) {
          System.out.println("자동저장을 종료합니다.");
          
             as1.interrupt();//자동저장멈춤
          
          save = 0;
       	}
       }


	public static void printMenu() {

		System.out.println("================메뉴를 선택하세요!===============");
		System.out.println("1.주소록입력  2.검색  3.삭제  4.출력  5.저장옵션   6.종료");
		System.out.println("============================================");
		System.out.print("선택:");

	}

}// end of handler
