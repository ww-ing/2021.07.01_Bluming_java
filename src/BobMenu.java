import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class BobMenu extends JFrame {
	JPanel pMenu;
	JLabel lbAlarm,lbInvite,lbSetText,lbExit;
	
	boolean AlramOn$off=true;
	public BobMenu() {
		
		pMenu=new JPanel();
		lbAlarm=new JLabel(new ImageIcon("images/notificationOn@.png"));
		lbInvite=new JLabel(new ImageIcon("images/addFriend@.png"));
		lbSetText=new JLabel(new ImageIcon("images/wipeOut@.png"));
		lbExit=new JLabel(new ImageIcon("images/leave@.png"));
		
		add(pMenu);
		
		pMenu.setLayout(new GridLayout(4, 1, 0, 0));
		pMenu.setBackground(Color.pink);
		pMenu.add(lbAlarm);
	    pMenu.add(lbInvite);
	    pMenu.add(lbSetText);
	    pMenu.add(lbExit);
	    
	    
	}

	public static void main(String[] args) {
		BobMenu menu=new BobMenu();
		menu.setBounds(1202, 25, 200, 200);
		menu.setVisible(true);
	}

}
