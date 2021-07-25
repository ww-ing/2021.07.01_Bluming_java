import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;





public class FriendPageBeta extends JPanel {

	
	FriendDAO frdao=new FriendDAO();
	LoginChat lc;
	// Main image
	JLabel FriendImage;
	
	// JLabel name emoticon
	JLabel label_addFriend = new JLabel(new ImageIcon("images/iconclip+.png"));
	JLabel label_delete = new JLabel(new ImageIcon("images/iconcancle+.png"));
	
	DeleteFriendPageBeta delFriend;
	AddFriendPageBeta addFriend; 
	// Icon acction+
	Icon iaddfriend_ = new ImageIcon("images/iconclip$.png");
	Icon iaddfriend = new ImageIcon("images/iconclip+.png");
	
	Icon idelete = new ImageIcon("images/iconcancle+.png");
	Icon idelete_ = new ImageIcon("images/iconcancle-.png");
	
	

	
	// JPanel for action
	JPanel pN, pC, pCC, pCS;
	
	//-----------------------------------------------------
	// JTable
	JTable friendTable = new JTable();
	
	
	String colHeader[]= {"번호","친구이름"};
	DefaultTableModel model;//DataModel
	JScrollPane jScrollPane = new JScrollPane(friendTable);//scroll
	Object[][]data= {{null,null}};
	
	public FriendPageBeta(LoginChat lc) {
		this.lc=lc;
		setLayout(new BorderLayout());
		JPanel p = new JPanel(new BorderLayout());
		add(p, "Center");

		// Panel North // 筌랃옙 占쎌맄 占쎌뵠沃섎챷占� 占쎈솭占쎄섯
		pN = new JPanel();
		pN.setBackground(new Color(48, 110, 159));
		pN.setBorder(new EmptyBorder(20, 0, 0, 0));
		pN.setPreferredSize(new Dimension(ABORT, 250));
		p.add(pN, "North");

		// Panel Center // 餓λ쵐釉� 占쎄쉽占쎄쉘 占쎈츟 筌잞옙 占쎈솭占쎄섯
		pC = new JPanel(new GridLayout(0, 1));
		pC.setBackground(new Color(48, 110, 159));
		pC.setBorder(new EmptyBorder(0,20,10,20));
		pC.setPreferredSize(new Dimension(ABORT, ABORT));
		p.add(pC, "Center");

		// Panel Center Center // 占쎈�믭옙�뵠�뇡占� 占쎈굶占쎈선揶쏉옙 占쎈솭占쎄섯
		pCC = new JPanel(new GridLayout(0, 1));
		pCC.setBackground(new Color(48, 110, 159));
		pCC.setBorder(new EmptyBorder(0, 0, 50, 5));
		pCC.setPreferredSize(new Dimension(70, ABORT));
		pC.add(pCC, "Center");

		// Panel Center South // 占쎈툡占쎌삋 甕곌쑵�뱣 占쎈솭占쎄섯
		pCS = new JPanel(new FlowLayout(1));
		pCS.setBackground(new Color(48, 110, 159));
		pCS.setBorder(new EmptyBorder(0, 0, 0, 0));
		pCS.setPreferredSize(new Dimension(ABORT, 100));
		p.add(pCS, "South");
		
		//
		pCS.add(label_addFriend);
		pCS.add(label_delete);
	
		
		// Handler
		MyHandler handler = new MyHandler();
		label_addFriend.addMouseListener(handler);
		label_delete.addMouseListener(handler);


		// Main image
		FriendImage = new JLabel(new ImageIcon("images/_friendimage.png"), JLabel.CENTER);
		pN.add(FriendImage);
		
		
		//-----------------------------------------------------
		//JTabel
		model=new DefaultTableModel(data, colHeader);
		
		JTableHeader jheader=friendTable.getTableHeader();
		friendTable.setModel(model);
		jheader.getColumnModel().getColumn(0).setPreferredWidth(5);
		jheader.getColumnModel().getColumn(1).setPreferredWidth(100);
		friendTable.setRowHeight(20);// 20 friends can be added
		pCC.add(jScrollPane);
		
		addFriend= new AddFriendPageBeta(this,lc);
		delFriend=new DeleteFriendPageBeta(this,lc);
	
	
	}
	
	
	//-----------------------------------------------------
	//Table Data Setting
	public void showTable(ArrayList<FriendVO> arr) {
		model = (DefaultTableModel)friendTable.getModel(); //friendChatBeta의 테이블을 가져옴
		data=new Object[arr.size()][3]; //데이터의 갯수
		
		int i=0;
		for(FriendVO f:arr) {
			data[i][0]=f.getIdx(); //데이터 번호 
			data[i][1]=f.getFriend(); // 친구 이름
			data[i][2]=f.getName(); // 자기 자신의 이름
			
			i++; //데이터가 얼마나 저장되어 있냐에 따라 i값이 올라감
		}
			
		model.setDataVector(data, colHeader);//테이블 데이터와 테이블의 헤더(친구번호,친구이름) 생성
		friendTable.setModel(model);		// 테이블 출력
	   
		
		
	}
	

	class MyHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == label_addFriend) 
			{
				addFriend.setSize(400, 190);
				addFriend.setUndecorated(true);
				addFriend.setLocation(320, 440);
				addFriend.setVisible(true);
				label_addFriend.setIcon(iaddfriend_);			
			}else if(obj==label_delete) {
				delFriend.setSize(400, 190);
				delFriend.setUndecorated(true);
				delFriend.setLocation(320, 440);
				delFriend.setVisible(true);
				label_delete.setIcon(idelete_);
				
				
			 }
		
			
			if (obj == addFriend.lbAdd) {

				String name = addFriend.tfAddFriend.getText(); //친구이름 아이디
				String friend= lc.txId.getText(); //자기 자신의 아이디
				int idx=0; //시퀀스로 번호가 자동으로 상승하므로 0으로 기본설정함.
				FriendVO fr=new FriendVO(idx++,name,friend); //VO 객체를 생성함
				frdao.insertFriend(fr); //insertFriend 메소드를 호출하여 VO 객체를 통해 친구를 생성함.


			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}


		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == label_addFriend) {
				
				label_addFriend.setIcon(iaddfriend_);
				
			}else if(obj==label_delete) {
				label_delete.setIcon(idelete_);
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == label_addFriend) {
				label_addFriend.setIcon(iaddfriend);
			}else if(obj==label_delete) {
				label_delete.setIcon(idelete);
			}

		}

	}

}
