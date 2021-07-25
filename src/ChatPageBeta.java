import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ChatPageBeta extends JPanel {

	//�뙣�꼸
	JPanel pN, pC, pCC, pCCS;
	
	//硫붿씤 �씠誘몄�
	JLabel lbmainImage = new JLabel(new ImageIcon("images/_chatimage.png"));
	
	
	
	JLabel lbDelete = new JLabel(new ImageIcon("images/musicimages/iconsmallcancle+.png"));
	Icon ideletechat = new ImageIcon("images/musicimages/iconsmallcancle+.png");
	Icon ideletechat_ = new ImageIcon("images/musicimages/iconsmallcancle-.png");

	//�빖�뱾�윭
	ChatPageEventHandler handler;
     
     //Table
     JTable chatTable = new JTable();
     DefaultTableModel model;//DataModel
     JScrollPane jScrollPane = new JScrollPane(chatTable);//scroll
     String colHeader[] = {"No", "name"};
     Object[][]data= {{null,null}};
     
     //�뜲�씠�꽣
     ChatPageDAO chatPageDao;
     
     
	public ChatPageBeta() {
		
		setLayout(new BorderLayout());
		JPanel p = new JPanel(new BorderLayout());
		add(p, "Center");
		
		//�씠誘몄� �뙣�꼸
		pN = new JPanel(new BorderLayout());
		pN.setBackground(new Color(48, 110, 159));
		pN.setBorder(new EmptyBorder(20, 0, 0, 0));
		pN.setPreferredSize(new Dimension(ABORT, 400));
		pN.add(lbmainImage);
		p.add(pN, "North");
		
		//以묒븰 �꽱�꽣 �뮘 履� �뙣�꼸
		pC = new JPanel(new GridLayout(0, 1));
		pC.setBackground(new Color(48, 110, 159));
		pC.setBorder(new EmptyBorder(10,10,10,10));
		pC.setPreferredSize(new Dimension(ABORT, ABORT));
		p.add(pC, "Center");
		
		//�뀒�씠釉�
		pCC = new JPanel(new BorderLayout());
		pCC.setBackground(new Color(48, 110, 159));
		pCC.setPreferredSize(new Dimension(70, ABORT));
		pC.add(pCC, "Center");
		
		//移쒓뎄 �궘�젣 踰꾪듉 �뙣�꼸
		pCCS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pCCS.setBackground(new Color(73,159,228));
		pCC.add(pCCS,"South");
		
		//異붽��븯湲�
		pCC.add(jScrollPane);//�뀒�씠釉�
		
		
		pCCS.add(lbDelete);//移쒓뎄 �궘�젣
		
		//�빖�뱾�윭
		handler = new ChatPageEventHandler(this);
		lbDelete.addMouseListener(handler);
	
		chatTable.addMouseListener(handler);

	}
	
	//Table Data Setting
	public void showTable(ArrayList<FriendVO> arr) {
		model = (DefaultTableModel)chatTable.getModel();
		Object[][] data = new Object[arr.size()][2];
		
		int i=0;
		int k=1;
		for(FriendVO f:arr) {
			data[i][0] =k;
			data[i][1]= f.getFriend();
			
			i++;
			k++;
		}
			
		model.setDataVector(data, colHeader);
		chatTable.setModel(model);
		
	}
	
}