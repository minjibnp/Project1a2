package project1.ver08;

public class AutoSaverT extends Thread{
	
	PhoneBookManager pm;

	AutoSaverT(PhoneBookManager pMan) {
		pm = pMan;
	}

	@Override
	public void run() {
		while (true) {

			try {
				sleep(5000);
				pm.saveTxt();//5초마다 텍스트파일 저장 메소드를 불러온다
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			} catch (InterruptedException e) {
//            System.out.println(e);
				return;
			}
		}
	}
}

