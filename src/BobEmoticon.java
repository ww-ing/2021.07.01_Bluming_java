import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BobEmoticon extends JFrame{
	
	JPanel pEmoticon;//main Panel
	JLabel lE1,lE2,lE3,lE4,lE5,lE6,lE7,lE8;//Emoticon Img Label
	
	public BobEmoticon() {
		
	  pEmoticon=new JPanel();
	  
		 
		
	  add(pEmoticon);
	  pEmoticon.setBackground(Color.white);
      pEmoticon.setLayout(new GridLayout(2, 4, 2, 0));
	
	  lE1 = new JLabel(new ImageIcon("images/img1.gif"));
      lE2 = new JLabel(new ImageIcon("images/img2.gif"));
      lE3 = new JLabel(new ImageIcon("images/img3.png"));
      lE4 = new JLabel(new ImageIcon("images/img4.png"));
      lE5 = new JLabel(new ImageIcon("images/img5.gif"));
      lE6 = new JLabel(new ImageIcon("images/img6.gif"));
      lE7 = new JLabel(new ImageIcon("images/img9.png"));
      lE8 = new JLabel(new ImageIcon("images/img8.png"));
      
      
      pEmoticon.add(lE1);
      pEmoticon.add(lE2);
      pEmoticon.add(lE3);
      pEmoticon.add(lE4);
      pEmoticon.add(lE5);
      pEmoticon.add(lE6);
      pEmoticon.add(lE7);
      pEmoticon.add(lE8);
      
      
      setUndecorated(true);
	}
	
	public static void main(String[] args) {
		BobEmoticon be=new BobEmoticon();
		be.setSize(500,500);
		be.setVisible(true);
	}
	
}
