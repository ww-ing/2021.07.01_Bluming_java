import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;


import jdbc.util.DBUtil;

public class BlumingDAO {
	  public Connection con;
	   public PreparedStatement ps;
	   public ResultSet rs;
	  
	   public boolean insertPeople(BlumingVO blum) { //signup 
	      try {         
	         con=DBUtil.getCon();
	     	String sql="insert into blumingPeople(idx,username,pwd,name,tel,email)";
			sql+="values(friend_seq.nextval,?,?,?,?,?)";
	         ps=con.prepareStatement(sql);
	         	ps.setString(1, blum.getUserid());
				ps.setString(2, blum.getPwd());
				ps.setString(3, blum.getName());
				ps.setString(4, blum.getTel());
				ps.setString(5, blum.getEmail());	
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

	   /**�۹�ȣ(PK)�� delete���� �����ϴ� �޼ҵ�*/
	   public boolean deletePeople(int idx) {
	       try {
	          con=DBUtil.getCon();
	          String sql="delete from blumingtest where idx=?";
	          ps=con.prepareStatement(sql);
	          ps.setInt(1, idx);
	          int cnt=ps.executeUpdate();
	          return (cnt>0)? true: false;
	       }catch(SQLException e) {
	         e.printStackTrace();
	         return false;
	      }finally {
	         closeAll();
	      }
	   }//----------------------------------
	   /**update���� �����ϴ� �޼ҵ�*/
	   public boolean updatePeople(BlumingVO blum) {
	      try {
	         con=DBUtil.getCon();
	         String sql="update blumingpeople set name=?, tel=?,email=? where idx=?";
	         ps=con.prepareStatement(sql);
	         ps.setString(1, blum.getName());
	         ps.setString(2, blum.getTel());
	         ps.setString(3, blum.getEmail());
	         ps.setInt(4,blum.getIdx());
	         int cnt=ps.executeUpdate();
	         return (cnt>0)? true: false;
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	      }finally {
	         closeAll();
	      }
	   }//----------------------------------
	   //ģ����� ���鶧 ����
//	   public ArrayList<BlumingVO> selectMemoAll() {
//	      try {
//	         con=DBUtil.getCon();
//	         String sql="select idx, name, msg, wdate from memo order by idx desc";
//	         ps=con.prepareStatement(sql);
//	         rs=ps.executeQuery();
//	         
//	         ArrayList<BlumingVO> arrList=makeList(rs);
//	         
//	         return arrList;
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	         return null;
//	      }finally {
//	         closeAll();
//	      }
//	   }//selectMemoAll()--------------------

	   private ArrayList<BlumingVO> makeList(ResultSet rs) throws SQLException {
	      ArrayList<BlumingVO> arrList=new ArrayList<>();
	      while(rs.next()) {
	         int idx=rs.getInt("idx");
	         String id=rs.getString("username");
	         String pwd=rs.getString("pwd");
	         String name=rs.getString("name");
	         String tel=rs.getString("tel");
	         String email=rs.getString("email");       
	         BlumingVO blum=new BlumingVO(idx,id,pwd,name,tel,email);//�ϳ��� ���ڵ�
	         arrList.add(blum);
	      }//while----
	      return arrList;
	   }//makeList()-----------------------------------------
	   /**select�� where�� �۹�ȣ�� �˻��ؼ� �ش���� �������� �޼ҵ�*/
	   public BlumingVO loginPeople(String username,String pwd) {
	      try {
	         con =DBUtil.getCon();
	         String sql="select * from BlumingPeople where username=? and pwd=?";
	         ps=con.prepareStatement(sql);
	         ps.setString(1, username);
	         ps.setString(2, pwd);
	         rs=ps.executeQuery();
	         ArrayList<BlumingVO> arrList=makeList(rs);
	         //pk�� �������Ƿ� �����Ͱ� �ִٸ� 1�� ����
	         if(arrList!=null && arrList.size()==1) {
	            BlumingVO blum=arrList.get(0);
	            return blum;
	         }
	         return null;         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	      }finally {
	         closeAll();
	      }

	   }
	   public boolean logincheckPeople(String username,String pwd) //Sign ID Check
	   {
		   boolean LoginCheck=false;
		   try {
			con=DBUtil.getCon();
			 String sql="select username,pwd from BlumingPeople where username=? and pwd=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			 ResultSet result = ps.executeQuery();
			
			 if(result.next()) {
				 LoginCheck= true;
							 
				 }else {
					 LoginCheck= false;
				 }
			 return LoginCheck;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		 }
		   finally {
		         closeAll();
		      }
	   }
	   
	   
	   
	   
	   
	   public boolean signcheckPeople(String username) //Sign ID Check
	   {
		   boolean isCheck=false;
		   try {
			con=DBUtil.getCon();
			 String sql="select idx from BlumingPeople where username=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
		
			 ResultSet result = ps.executeQuery();
			
			 if(result.next()) {
				 isCheck= false;
							 
				 }else {
					 isCheck= true;
				 }
			 return isCheck;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}finally {
	         closeAll();
	      }
		   
	   }
	
	   public ArrayList<BlumingVO> profilePeople(String username,String pwd) //show profile
	   {
		   
		   try {
			con=DBUtil.getCon();
			 String sql="select * from BlumingPeople where username=? and pwd=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			System.out.println(username+"/"+pwd);
			 ResultSet rs = ps.executeQuery();		
		            return makeList(rs);
		   
		 }catch (SQLException e) {
			e.printStackTrace();
			return null;
		 }//catch
		   finally {
		        closeAll();
		 }//finally
	   }

}
