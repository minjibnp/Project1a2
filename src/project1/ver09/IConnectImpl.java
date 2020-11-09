package project1.ver09;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class IConnectImpl implements IConnect{
	
	public PreparedStatement psmt;//동적쿼리 처리를 위한 객체
	public Statement stmt;
	public Connection con;	
	public ResultSet rs;
	
	//기본생성자 호출
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	
	//인자생성자-매개변수 2개
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		
		try {
			//드라이버 로드
			Class.forName(ORACLE_DRIVER);
			//DB연결
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//인자생성자-매개변수 3개로 오버로딩 생성자 선언
	public IConnectImpl(String driver, String user, String pass) {
		System.out.println("IConnectImple 인자생성자 호출");
		
		try {
			//드라이버 로드
			Class.forName(driver);
			//DB연결
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
			
	//오라클 DB에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			con=DriverManager.getConnection(ORACEL_URL, user, pass);
		}
		catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
		
	}
	/*
	 오버라이딩 목적으로 정의한 메소드. 쿼리실행은 각각의 클래스에 진행하게 될것임.
	 */
	@Override
	public void execute() {
		//하는일 없음
	}
	
	//입력, 삭제용 자원해제
	@Override
	public void close1() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			System.out.println("자원 반납 완료");
		}
		catch (Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
		
	}
	
	//검색용 자원해제
	@Override
	public void close2() {
		try {
			if(con!=null) con.close();
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch (Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
		
	}

	@Override
	public String scanValue(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	
}


