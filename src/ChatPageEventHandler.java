import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class ChatPageEventHandler extends MouseAdapter {
	
	ChatPageBeta main;
	ChatPageDAO chatPageDao;
	
	DeleteChatPage deleteChat = new DeleteChatPage();
	
	String userId;
	
	//JTextPane
	JTextPane tpMsg;
	JScrollPane jscroll;
	
	public ChatPageEventHandler (ChatPageBeta main) {
		this.main = main;
		chatPageDao = new ChatPageDAO();
		listChat();
	}
	
	//JTextPane 저장
	private void saveFile() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("chatFile/"+userId+"과"+tableRow()+"님의 채팅.txt"));
			
		oos.writeObject(tpMsg);
		oos.flush();
		oos.close();
		showMsg("파일저장완료");
		
		}catch(Exception e) {
			System.out.println("saveFile 예외 : "+e.getMessage());
		}
	}
	//JTextPane 저장
	private void saveFile2() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("chatFile/"+tableRow()+"과"+userId+"님의 채팅.txt"));
			
		oos.writeObject(tpMsg);
		oos.flush();
		oos.close();
		showMsg("파일저장완료");
		
		}catch(Exception e) {
			System.out.println("saveFile 예외 : "+e.getMessage());
		}
	}
	
	//JTextPane 출력
    private void readFile() {
    	
        try {
           ObjectInputStream oos=new ObjectInputStream(new FileInputStream("chatFile/"+userId+"과"+tableRow()+"님의 채팅.txt"));
           
           tpMsg=(JTextPane)oos.readObject();
            tpMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255), 3));
            jscroll.setViewportView(tpMsg);
           tpMsg.updateUI();
           System.out.println(tpMsg);
           oos.close();
        } catch (Exception e) {
           System.out.println(e.getMessage()+": error");
        }
        
     }
	
	//버튼 누르면 창 띄우기
	public void showPage(Component com) {
		com.setSize(400, 190);
		((Frame) com).setUndecorated(true);
		com.setLocation(320, 440);
		com.setVisible(true);	
		
	}
	
	
	
	//채팅 리스트
	public void listChat() {
    	ArrayList<FriendVO> arr = chatPageDao.selecMusicAll(userId);
    	main.showTable(arr);
		
	}//--listMusic
	
	//선택한 행의 값
	public String tableRow() {
		int row = main.chatTable.getSelectedRow();
		String friendId = (String) main.chatTable.getValueAt(row, 1);
		
		return friendId;
		
	}
	
	//쇼메시지
	private void showMsg(String string) {
		JOptionPane.showMessageDialog(main, string);
		
	}//--showMsg
	
	@Override
	public void mousePressed(MouseEvent e) {
		readFile();//해당테이블 친구와의 대화목록 띄워주기
		
		Object obj = e.getSource();
		
		//대화삭제
		if(obj==main.lbDelete) {
			saveFile();
			
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==main.lbDelete) {
			main.lbDelete.setIcon(main.ideletechat_);
			
		 }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==main.lbDelete) {
			main.lbDelete.setIcon(main.ideletechat);
		}
		
	}

}
