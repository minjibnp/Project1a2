package project1.ver09;

public class DeleteInfo extends IConnectImpl {

	 String deleteN;
	   
	   
	   public DeleteInfo(String deleteN) {
			super(ORACLE_DRIVER, "kosmo", "1234");
			this.deleteN = deleteN;
	   }
	   
	   
	   @Override
	   public void execute() {
	      
	      try {
	         //1.쿼리문준비
	         String query = " DELETE FROM phonebook_tb WHERE name=?";
	         //2.prepared객체생성
	         psmt = con.prepareStatement(query);
	         //3.사용자로부터 입력받은값을 인파라미터로 설정
			 psmt.setString(1, deleteN);
	         //4.쿼리실행
	         int affected = psmt.executeUpdate();
	         System.out.println(affected+ "행이 삭제되었습니다.");
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         close1();
	      }
	       
	   }
	   
}