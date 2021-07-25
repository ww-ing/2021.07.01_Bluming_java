import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FriendPanel extends JPanel {
	JLabel lbIcon;
	JTextField tf;
	JLabel lbDel;
	public FriendPanel(JLabel lb1,JTextField tf, JLabel lbDel ) {
		this.lbIcon=lb1;
		this.tf=tf;
		this.lbDel=lbDel;
		
		setLayout(new BorderLayout());
		add(lb1,"West");
		add(lbDel,"East");
		add(tf,"Center");
		setBackground(new Color(48, 110, 159));
		
		
	}
}///////////////////////////////////////////
