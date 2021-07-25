import java.sql.*;
import java.util.*;




import jdbc.util.DBUtil;

public class FriendDAO {
	  public Connection con;
	   public PreparedStatement ps;
	   public ResultSet rs;
	  
	   public boolean insertFriend(FriendVO fr) { //add friend
	      try {         
	         con=DBUtil.getCon();
	     	String sql="insert into FriendPeople(idx,name,friend)";
			sql+="values(friend_seq.nextval,(select name from blumingPeople where username=?),(select name from blumingPeople where username=?))";
	         ps=con.prepareStatement(sql);
				ps.setString(1, fr.getName());
				ps.setString(2, fr.getFriend());
	         int cnt=ps.executeUpdate();
	      
	         return (cnt>0)? true:false;
	      }catch(SQLException e) {
	         e.printStackTrace();
	         return false;
	      }finally {
	         closeAll();
	      }
	   }
	   
	   private void closeAll() {
	      try {
	         if(rs!=null) rs.close();
	         if(ps!=null) ps.close();
	         if(con!=null) con.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	   }//----------------------------------

	   
	   public boolean deleteFriend(String name) {
	       try {
	          con=DBUtil.getCon();
	          String sql="delete from friendpeople where friend=(select name from blumingPeople where username=?)";
	          ps=con.prepareStatement(sql);
	          ps.setString(1, name);
	          int cnt=ps.executeUpdate();
	          return (cnt>0)? true: false;
	       }catch(SQLException e) {
	         e.printStackTrace();
	         return false;
	      }finally {
	         closeAll();
	      }
	   }//----------------------------------
	   

	   
	   public ArrayList<FriendVO> selectFriendAll(String name) {
	      try {
	         con=DBUtil.getCon();
	         String sql="select * from friendPeople where name=(select name from blumingPeople where username=?)";
	         ps=con.prepareStatement(sql);
	         ps.setString(1,name);
	         rs=ps.executeQuery();
	         
	         ArrayList<FriendVO> arrList=makeList(rs);
	         
	         return arrList;
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	      }finally {
	         closeAll();
	      }
	   }//selectMemoAll()--------------------

	   private ArrayList<FriendVO> makeList(ResultSet rs) throws SQLException {
	      ArrayList<FriendVO> arrList=new ArrayList<>();
	      while(rs.next()) {
	         int idx=rs.getInt("idx");        
	         String name=rs.getString("name");	
	         String friend=rs.getString("friend");
	         FriendVO fr=new FriendVO(idx,name,friend);//�ϳ��� ���ڵ�
	         arrList.add(fr);
	      }//while----
	      return arrList;
	   }//makeList()-----------------------------------------

}
