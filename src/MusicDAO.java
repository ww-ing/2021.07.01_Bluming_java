import java.sql.*;
import java.util.*;
import jdbc.util.DBUtil;

public class MusicDAO {

	public MusicDAO() {
		
	}
	
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
 
    String songlocal;
    
    //음악 추가
    public boolean insertMusic(MusicVO musicVO) {
    	
		try {
		con = DBUtil.getCon();
		
		String sql = "insert into musiclist(idx, songname, songlocal, username)";
			   sql+=" values (musicinfo_seq.nextval, ?, ?, ?)";
			   
		ps = con.prepareStatement(sql);
		ps.setString(1, musicVO.getName());
		ps.setString(2, musicVO.getLocal());
		ps.setString(3, musicVO.getUsername());
		
		int cnt = ps.executeUpdate();
		
		return (cnt>0)? true:false;
		
			
		}catch(SQLException e) {
			System.out.println("Music added Exception"+e);
			return false;
			
		}finally {
			closeAll();
		}
    	
    }//--insertMusic
    
    //���� ����
    public boolean deleteMusic(String songname) {
    	try {
    		con = DBUtil.getCon();
    		String sql = "delete from musiclist";
    			   sql+=" where songname = ?";
    			   
    		ps = con.prepareStatement(sql);
    		ps.setString(1, songname);
    		
    		int cnt = ps.executeUpdate();
    		
    		return (cnt>0)? true:false;
    			   
    	}catch(SQLException e) {
    		System.out.println("Music deleted Exception"+e);
    		return false;
    		
    	}finally {
    		closeAll();
    	}
    }
    
	//음악 경로 찾아오기
    public String selectLocal(String songname) {
    	try {
    		con = DBUtil.getCon();
    		String sql = "select songlocal";
    			   sql+=" from musiclist";
    			   sql+=" where songname = ?";
    			   
    		ps = con.prepareStatement(sql);
    		ps.setString(1, songname);
    		
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
        		songlocal = rs.getString("songlocal");
    			
    		}

    			   
    	}catch(SQLException e) {
    		System.out.println("MusicLocal selected by songname  Exception"+e);
    		
    	}finally {
    		closeAll();
    	}
		return songname;
		
    }    
    
    //전체 닫기
    private void closeAll() {
    	try {
    		if(rs!=null) rs.close();
    		if(ps!=null) ps.close();
    		if(con!=null) con.close();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    			
	}//--closeAll
    
    //--모든 음악 불러오기
	public ArrayList<MusicVO> selecMusicAll(String username){
		
    	try {
    		con = DBUtil.getCon();
    		
    		String sql = "select songname";
    			   sql+=" from musiclist";
    			   sql+=" where username = ?";
    			   sql+=" order by idx asc";
    			   
    		ps = con.prepareStatement(sql);
    		ps.setString(1, username);
    		
    		rs = ps.executeQuery();
    		
    		ArrayList<MusicVO> arrList = makeList(rs);
    		
    		return arrList;
    			   
    		
    	}catch(SQLException e) {
    		System.out.println("Music selected Exception"+e);
    		return null;
    		
    	}finally {
    		closeAll();
    	}
		
    	
    }//--seletMemoAll
    
    
    //음악 리스트 만들기
    private ArrayList<MusicVO> makeList(ResultSet rs)
    throws SQLException 
    {
    	ArrayList<MusicVO> arrList = new ArrayList<>();
    	while(rs.next()){
    		String songName = rs.getString("songname");
    		
    		MusicVO musicVO = new MusicVO(songName);
    		
    		arrList.add(musicVO);
    	}
		return arrList;
    	
    }//--makeList
    
}





