import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AddMusicPageBeta extends JFrame {
	JPanel p = new JPanel(new BorderLayout());
	
	//Main Text
	JTextField tfNorthText = new JTextField("Add Music",7);
	
	//JTextField name
	JTextField tfAddMusicName = new JTextField("Music Name",20);
	JTextField tfAddMusicLocation = new JTextField("Music Location",20);
	
	//TextField style
	LineBorder lineBorder =new LineBorder(Color.white, 5, true);
	LineBorder lineBorder_main =new LineBorder(Color.white, 0, true);
	Font font = new Font("", Font.BOLD,13);
	
	//JLabel images (Panel South)
	JLabel lbAdd = new JLabel(new ImageIcon("images/iconclip+.png"));
	JLabel lbCancle = new JLabel(new ImageIcon("images/iconcancle+.png"));
	
	
	//Icon clicked acction+
	Icon iadd= new ImageIcon("images/iconclip+.png");
	Icon icancle= new ImageIcon("images/iconcancle+.png");
	
	//Icon clecked acttion-
	Icon iadd_= new ImageIcon("images/iconclip-.png");
	Icon icancle_= new ImageIcon("images/iconcancle-.png");
	
	public AddMusicPageBeta() {
		super("AddMusicPageBeta");
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
		tfAddMusicName.setBorder(lineBorder);
		tfAddMusicName.setFont(font);
		tfAddMusicLocation.setBorder(lineBorder);

		//Main Text
		tfNorthText.setBorder(lineBorder_main);
		tfNorthText.setFont(font);
		tfNorthText.setEnabled(false);
		tfNorthText.setOpaque(false);
		tfNorthText.setForeground(Color.white);
		
		
		//add TextField(Add Friend)
		pN.add(tfNorthText,"Center");
		
		//add TextField
		pC.add(tfAddMusicName);
		pC.add(tfAddMusicLocation);
		//add Label
		pS.add(lbAdd);
		pS.add(lbCancle);
		
		//Handler
		MyHandler handler = new MyHandler();
		lbAdd.addMouseListener(handler);
		lbCancle.addMouseListener(handler);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//--�깮�꽦�옄
	
	class MyHandler implements MouseListener{
		

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			Object obj=e.getSource();
			if(obj==lbCancle) {
				lbCancle.setIcon(icancle);
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
				
			}else if(obj==lbCancle) {
				lbCancle.setIcon(icancle_);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==lbAdd) {
				lbAdd.setIcon(iadd);
			}else if(obj==lbCancle) {
				lbCancle.setIcon(icancle);
			}
		}
		
	}

}
