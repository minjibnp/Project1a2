package project1.ver09;



public class SearchInfo extends IConnectImpl{
	
	String searchN;
	
	public SearchInfo(String searchN) {
		super(ORACLE_DRIVER, "kosmo", "1234");
		this.searchN = searchN;		
	}
	
	@Override
	public void execute() {
		try {
			
			stmt = con.createStatement();
			
			String query = " SELECT name, phoneNumber, birthday FROM phonebook_tb "
							+ "WHERE name like '%" +searchN+ "%'";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getNString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String birthday = rs.getString("birthday");
				
				System.out.printf("이름 : %s , 전화번호 : %s, 생년월일 : %s ", name, phoneNumber, birthday);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close2();
		}
	}
	

}
