package project1.ver09;




public class InsertInfo extends IConnectImpl{
	
	String iName;
	String iphoneN;
	String ibDay;
	
	
	
	public InsertInfo(String iName, String iphoneN, String ibDay) {
		super(ORACLE_DRIVER, "kosmo", "1234");
		this.iName = iName;
		this.iphoneN = iphoneN;
		this.ibDay = ibDay;
	}
	
	@Override
	public void execute() {
		try {
			//쿼리문준비
			String query = " INSERT INTO phonebook_tb VALUES (seq_phonebook.nextval, ?, ?, ?) ";			
			//prepared 객체생성 : 생성시 준비한 쿼리문을 인자로 전달.
			psmt = con.prepareStatement(query);			
			
			
			psmt.setString(1, iName);
			psmt.setString(2, iphoneN);
			psmt.setString(3, ibDay);
			
			
			// prepared객체 실행.
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close1();
		}
	}

	

}

