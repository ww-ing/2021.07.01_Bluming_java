import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ProfilePageBeta extends JPanel {
	//Main image
	JLabel profileImage;
	
//	ObjectInputStream in;
//	FileInputStream fin;
	RegisterChat rt=RegisterChat.getInstance();
//	LoginChat lc=new LoginChat();
	BlumingDAO dao=new BlumingDAO();
	
	JTextField tfUserid = new JTextField(10);
	JTextField tfName=new JTextField(10); //nameTextField
	JTextField tfTel=new JTextField(15); //telTextField
	JTextField tfEmail=new JTextField(15); //emailTextField
	
	LineBorder lineBorder = new LineBorder(Color.white,0,true);//TextField Border
	Font font= new Font("", Font.BOLD,20);//FontStyle
	
	
	
	
	LoginChat lc;
	
	public ProfilePageBeta(LoginChat lc) { 
		
		this.lc=lc;
		//Panel
		setLayout(new BorderLayout());
		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(new Color(48,110,159));
		add(p, "Center");
		
		//Panel North
		JPanel pN = new JPanel();
		pN.setBackground(new Color(48,110,159));
		pN.setBorder(new EmptyBorder(20,0,0,0));
		p.add(pN, "North");
		
		//Panel Center
		JPanel pC = new JPanel(new GridLayout(0,1));
		pC.setBackground(new Color(48,110,159));
		pC.setBorder(new EmptyBorder(29,0,100,0));
		pC.setPreferredSize(new Dimension(ABORT,370));
		p.add(pC, "Center");
		
		//Panel South
		JPanel pS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pS.setBackground(new Color(48,110,159));
		p.add(pS, "South");
		
		
		// TextField style
		tfUserid.setBorder(lineBorder);// add border
		tfUserid.setFont(font);// add Font
		tfUserid.setForeground(Color.white);// font color
		tfUserid.setOpaque(false);// background color none
		tfUserid.setEnabled(false);// cannot type
		tfUserid.setHorizontalAlignment(JTextField.CENTER);// Align
		
		tfName.setBorder(lineBorder);// add border
		tfName.setFont(font);// add Font
		tfName.setForeground(Color.white);//font color
		tfName.setOpaque(false);//background color none
		tfName.setEnabled(false);//cannot type
		tfName.setHorizontalAlignment(JTextField.CENTER);//Align
		
		tfTel.setBorder(lineBorder);
		tfTel.setFont(font);
		tfTel.setForeground(Color.white);
		tfTel.setOpaque(false);
		tfTel.setEnabled(false);
		tfTel.setHorizontalAlignment(JTextField.CENTER);
		
		tfEmail.setBorder(lineBorder);
		tfEmail.setFont(font);
		tfEmail.setForeground(Color.white);
		tfEmail.setOpaque(false);
		tfEmail.setEnabled(false);
		tfEmail.setHorizontalAlignment(JTextField.CENTER);	
		
		
		//Main image
		profileImage=new JLabel(new ImageIcon(
				"images/_profileimage.png"),JLabel.CENTER);
		pN.add(profileImage);
				
		//TextField add
		pC.add(tfUserid);
		pC.add(tfName);
		pC.add(tfTel);
		pC.add(tfEmail);

		
	

		
	}
	

	
	public void showUsers(ArrayList<BlumingVO> arr) {
		
		for(BlumingVO blum:arr) {
			tfUserid.setText(blum.getUserid());
		    tfName.setText(blum.getName());
			tfTel.setText(blum.getTel());
			tfEmail.setText(blum.getEmail());
		}
	}

}