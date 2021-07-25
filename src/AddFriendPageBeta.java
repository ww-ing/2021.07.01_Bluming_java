import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AddFriendPageBeta extends JFrame {
	JPanel p = new JPanel(new BorderLayout());
	
	FriendPageBeta fp;
	FriendDAO frdao=new FriendDAO();
	LoginChat lc;
	//Main Text
	JTextField tfNorthText = new JTextField("�߰��� ģ���� ���̵� �Է��ϼ���",20);
	
	//JTextField name
	JTextField tfAddFriend = new JTextField(20);
	
	//TextField style
	LineBorder lineBorder =new LineBorder(Color.white, 5, true);
	LineBorder lineBorder_main =new LineBorder(Color.white, 0, true);
	Font font = new Font("", Font.BOLD,20);
	
	//JLabel images (Panel South)
	JLabel lbAdd = new JLabel(new ImageIcon("images/iconclip+.png"));
	JLabel lbCancel = new JLabel(new ImageIcon("images/iconcancle+.png"));
	
	
	//Icon clicked acction+
	Icon iadd= new ImageIcon("images/iconclip+.png");
	Icon icancel= new ImageIcon("images/iconcancle+.png");
	
	//Icon clecked acttion-
	Icon iadd_= new ImageIcon("images/iconclip-.png");
	Icon icancel_= new ImageIcon("images/iconcancle-.png");
	
	public AddFriendPageBeta(FriendPageBeta fp,LoginChat lc) {
		this.fp=fp;
		this.lc=lc;
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		
		JPanel pN = new JPanel();
		p.add(pN,"North");
		pN.setBackground(new Color(73,159,228));
		pN.setBorder(new EmptyBorder(20,0,0,0));
		
		
		JPanel pC = new JPanel();
		p.add(pC,"Center");
		pC.setBackground(new Color(73,159,228));
		pC.setBorder(new EmptyBorder(10,0,0,0));
		
		JPanel pS = new JPanel(new GridLayout(1,0));
		p.add(pS,"South");
		pS.setBackground(new Color(73,159,228));
		pS.setBorder(new EmptyBorder(0,0,10,0));
		
		//TextField style
		tfAddFriend.setBorder(lineBorder);
		tfAddFriend.setFont(font);
		

		//Main Text
		tfNorthText.setBorder(lineBorder_main);
		tfNorthText.setFont(font);
		tfNorthText.setEnabled(false);
		tfNorthText.setOpaque(false);
		tfNorthText.setForeground(Color.white);
		
		
		//add TextField(Add Friend)
		pN.add(tfNorthText,"Center");
		
		//add TextField
		pC.add(tfAddFriend);
		
		//add Label
		pS.add(lbAdd);
		pS.add(lbCancel);
		
		//Handler
		MyHandler handler = new MyHandler();
		lbAdd.addMouseListener(handler);
		lbCancel.addMouseListener(handler);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//--�깮�꽦�옄
	
	class MyHandler implements MouseListener{
		

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
					
			Object obj=e.getSource();
			if(obj==lbAdd)
			{
				int idx=0;
				String id=lc.txId.getText();
				
				String name=lc.txId.getText();
				String friend=tfAddFriend.getText(); 
				if(name==null||name.trim().isEmpty()) {
					showMsg("�̸��� �Է��ϼ���");
					return;
				}
				FriendVO fr=new FriendVO(idx++,name,friend);
				boolean b=frdao.insertFriend(fr);
				String str=(b)?"ģ�� �߰� ����":"�ش� ���̵�� �������� �ʽ��ϴ�.";
				showMsg(str);
				tfAddFriend.setText("");
				ArrayList<FriendVO> arr= frdao.selectFriendAll(id);
				fp.showTable(arr);
			}else if(obj==lbCancel) {
				lbCancel.setIcon(icancel);
				dispose();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==lbAdd) {
				lbAdd.setIcon(iadd_);
			}else if(obj==lbCancel) {
				lbCancel.setIcon(icancel_);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==lbAdd) {
				lbAdd.setIcon(iadd);
			}else if(obj==lbCancel) {
				lbCancel.setIcon(icancel);
			}
		}
		
	}
	private void showMsg(String str) {
		JOptionPane.showMessageDialog(this, str);
		
	}
}

