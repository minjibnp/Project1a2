package project1.ver06;

public class MenuSelectException extends Exception{//개발자정의로 메뉴 선택시 1~5사이의 숫자만 입력할수있게 예외처리를 해준다
	public MenuSelectException() {
		super("1~5사이의 숫자를 입력하세요.");
	}
}
