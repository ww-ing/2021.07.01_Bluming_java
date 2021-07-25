import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.swing.*;
import jdbc.util.DBUtil;



public class RegisterChat extends JFrame {
	

	BlumingDAO dao=new BlumingDAO();
	JLabel lbShow, lbId,lbPwd,lbName,lbTel,lbEmail;  
	JButton btRegist, btCancel; 
	JTextField txId,txName,txTel,txEmail; 
	JPasswordField txPwd; 
	JPanel p = new JPanel();
	Font CS14= new Font("", Font.BOLD,14);
	Font CS214= new Font("", Font.BOLD,14);
	Font CS18= new Font("", Font.BOLD,18);
	Font CS19= new Font("", Font.BOLD,19);
	Font CS24= new Font("", Font.BOLD,24);
	Font CS30= new Font("", Font.BOLD,30);
	ImageIcon backgroundImage =new ImageIcon("images/myacc+.png");
	Image img=backgroundImage.getImage();
	
	
	private RegisterChat() {
		super("Bluming Join");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(new Color(73,159,228));
		p.setLayout(null);
		
		ImageIcon image = new ImageIcon("images/iconprofile+.png");
		lbShow=new JLabel(image,JLabel.CENTER);
		lbShow.setForeground(Color.white);
	    lbShow.setFont(CS18);
	    lbShow.setBounds(140,30,100,100);
		
	    lbShow.addMouseListener(new MouseAdapter() {
	    	  public void mouseEntered(MouseEvent e) {
	    		  ImageIcon image2=new ImageIcon("images/spiderman.png");
	    		  lbShow.setIcon(image2);
	    	  }
	      });
	      lbShow.addMouseListener(new MouseAdapter() {
	    	  public void mousePressed(MouseEvent e) {
	    		  ImageIcon image2=new ImageIcon("images/batman.png");
	    		  lbShow.setIcon(image2);
	    	  }
	      });
	      lbShow.addMouseListener(new MouseAdapter() {
	    	  public void mouseExited(MouseEvent e) {
	    		  ImageIcon image2=new ImageIcon("images/iconprofile+.png");
	    		  lbShow.setIcon(image2);
	    	  }
	      });
		
	      lbId=new JLabel("Username :");
	      lbId.setForeground(Color.white);
	      lbId.setFont(CS214);
	      lbId.setBounds(40,110,100,30);
		
	      lbPwd=new JLabel("Password :");
	      lbPwd.setForeground(Color.white);
	      lbPwd.setFont(CS14);
	      lbPwd.setBounds(40,160,100,30);
		
	      lbName=new JLabel("Name :");
	      lbName.setForeground(Color.white);
	      lbName.setFont(CS214);
	      lbName.setBounds(40,210,100,30);
		
	      lbTel=new JLabel("Tel :");
	      lbTel.setForeground(Color.white);
	      lbTel.setFont(CS14);
	      lbTel.setBounds(40,260,100,30);
		
	      lbEmail=new JLabel("E-mail :");
	      lbEmail.setForeground(Color.white);
	      lbEmail.setFont(CS14);
	      lbEmail.setBounds(40,310,100,30);

		
	      btRegist=new JButton("SignUp");
	      btRegist.setOpaque(false);
	      btRegist.setFont(CS18);
	      
	      btRegist.setBorderPainted(false);
	      btRegist.setBackground(Color.BLUE);
	      btRegist.setForeground(Color.white);
	      btCancel=new JButton("Cancel");
	      btCancel.setOpaque(false);
	      btCancel.setFont(CS18);
	     
	      btCancel.setBorderPainted(false);
	      btCancel.setBackground(Color.BLUE);
	      btCancel.setForeground(Color.white);
		
	      btRegist.setBounds(65,500,110,50);
	      btCancel.setBounds(200, 500, 110, 50);
		
		txId=new JTextField();
		txName=new JTextField();
		txTel=new JTextField();
		txPwd=new JPasswordField();
		txEmail=new JTextField();
		
		  txId.setOpaque(false);
	      txId.setFont(CS14);
	      txId.setForeground(Color.white);
	      txId.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
	      txName.setOpaque(false);
	      //txName.setFont(CS14);
	      txName.setFont(CS214);
	      txName.setForeground(Color.white);
	      txName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
	      txTel.setOpaque(false);
	      txTel.setFont(CS14);
	      txTel.setForeground(Color.white);
	      txTel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
	      txPwd.setOpaque(false);
	      txPwd.setFont(CS14);
	      txPwd.setForeground(Color.white);
	      txPwd.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
	      txEmail.setOpaque(false);
	     // txEmail.setFont(CS14);
	      txEmail.setFont(CS214);
	      txEmail.setForeground(Color.white);
	      txEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
	      
		
	      txId.setBounds(150,110,150,30);
	      txPwd.setBounds(150,160,150,30);
	      txName.setBounds(150,210,150,30);
	      txTel.setBounds(150,260,150,30);
	      txEmail.setBounds(150,310,150,30);
		
		p.add(lbShow);
		p.add(lbId);
		p.add(lbPwd);
		p.add(lbName);
		p.add(lbTel);
		p.add(lbEmail);
		p.add(txId);
		p.add(txPwd);
		p.add(txName);
		p.add(txTel);
		p.add(txEmail);	
		p.add(btRegist);
		p.add(btCancel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		
		btRegist.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				signUp();
				
			}
		});
		
	}
	static RegisterChat rc;
	public static RegisterChat getInstance() {
		if(rc==null)
		    rc=new RegisterChat();
		return rc;
	}
	
	public void signUp() {		
		int idx=0;
		String userid=txId.getText(); 
		
		char[] ch=txPwd.getPassword();	
		String pwd=new String(ch);
		
		String name=txName.getText(); 
		
		String tel=txTel.getText(); 
		
		String email=txEmail.getText(); 
		
			boolean b=dao.signcheckPeople(userid);
			if(!b) {
				JOptionPane.showMessageDialog(this, "이미 존재하는 ID입니다.");
				return;
			}
			BlumingVO user=new BlumingVO(idx++,userid,pwd,name,tel,email);
			dao.insertPeople(user);
			
			
		JOptionPane.showMessageDialog(this,
				"회원가입 성공 ! ");
		clearJoinInput();
		setVisible(false);
		dispose();
		
	}//----------------------
	


	public void clearJoinInput() { // textfield clear
		txId.setText("");
		txPwd.setText("");
		txName.setText("");
		txTel.setText("");
		txEmail.setText("");
		txName.requestFocus();
	}

}