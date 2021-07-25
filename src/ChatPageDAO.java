import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.DBUtil;

public class ChatPageDAO {
	
	public ChatPageDAO() {
		
	}
	
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
	
    //--移쒓뎄 �씠由꾨쭔 諛쏆븘�삤湲�
	public ArrayList<FriendVO> selecMusicAll(String userName){
		
    	try {
    		con = DBUtil.getCon();
    		
    		String sql = "select friend";
    			   sql+=" from friendpeople";
    			   sql+=" where name = ?";
    			   sql+=" order by idx asc";
    			   
    		ps = con.prepareStatement(sql);
    		ps.setString(1, userName);
    		
    		rs = ps.executeQuery();
    		
    		ArrayList<FriendVO> arrList = makeList(rs);
    		
    		return arrList;
    			   
    		
    	}catch(SQLException e) {
    		System.out.println("Friend selected Exception"+e);
    		return null;
    		
    	}finally {
    		closeAll();
    	}
		
    	
    }//--seletMemoAll
	
    //�뙎�븘二쇨린
    private ArrayList<FriendVO> makeList(ResultSet rs)
    throws SQLException 
    {
    	ArrayList<FriendVO> arrList = new ArrayList<>();
    	
    	while(rs.next()){
    		String friendName = rs.getString("friend");
    		
    		FriendVO friendVO = new FriendVO(friendName);
    		
    		arrList.add(friendVO);
    	}
		return arrList;
    	
    }//--makeList
    
    //�떎�뻾以묒씤嫄� �떕�븘二쇨린
    private void closeAll() {
    	try {
    		if(rs!=null) rs.close();
    		if(ps!=null) ps.close();
    		if(con!=null) con.close();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    			
	}//--closeAll

}
