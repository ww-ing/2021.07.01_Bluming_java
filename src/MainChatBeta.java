import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.oracle.webservices.internal.api.EnvelopeStyle.Style;

public class MainChatBeta extends JFrame {
	JPanel p = new JPanel();
	JPanel pW, pWC, pWS, pC;
	FriendDAO frdao = new FriendDAO();
	MusicDAO msdao = new MusicDAO();
	// JLabel default icon
	JLabel lbProfile, lbChat, lbFriend, lbSet, lbPower;

	// Pages
	ProfilePageBeta profilePage;
	ChatPageBeta chatPage;
	FriendPageBeta friendPage;
	SetPageBeta setPage;
	LoginChat lc;
	BobEmoticon EMT = new BobEmoticon();
	BobMenu menu = new BobMenu();
	// CardLayout Panel Center
	CardLayout card;

	// Icon clicked acction
	Icon iprofile_, ichat_, ifriend_, iset_, ipower_;
	Icon iprofile, ichat, ifriend, iset, ipower;

	SubChatPageBeta sub = new SubChatPageBeta();

	Socket sock = new Socket();
	final int port = 9999;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	public MainChatBeta(LoginChat lc) {
		super(":::MainChatBeta:::");
		this.lc = lc;
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setLayout(new BorderLayout());

		// PanelWest
		pW = new JPanel(new BorderLayout());
		p.add(pW, "West");
		pW.setBackground(new Color(73, 159, 228));
		pW.setPreferredSize(new Dimension(80, ABORT));

		// PanelWestCenter
		pWC = new JPanel(new GridLayout(0, 1));
		pW.add(pWC, "West");
		pWC.setBackground(new Color(73, 159, 228));
		pWC.setPreferredSize(new Dimension(80, ABORT));
		pWC.setBorder(new EmptyBorder(0, 0, 260, 0));

		// PanelWestSouth
		pWS = new JPanel();
		pW.add(pWS, "South");
		pWS.setBackground(new Color(73, 159, 228));
		pWS.setPreferredSize(new Dimension(80, 80));

		// PanelCenter
		pC = new JPanel();
		p.add(pC, "Center");
		pC.setBackground(new Color(48, 110, 159));
		pC.setLayout(card = new CardLayout());

		// Pages
		profilePage = new ProfilePageBeta(lc);
		chatPage = new ChatPageBeta();
		friendPage = new FriendPageBeta(lc);
		setPage = new SetPageBeta();

		// PanelCenter add Pages
		pC.add("profilePage", profilePage);
		pC.add("chatPage", chatPage);
		pC.add("friendPage", friendPage);
		pC.add("setPage", setPage);

		// Label images (Panel) +
		lbProfile = new JLabel(new ImageIcon("images/iconprofile+.png"), JLabel.CENTER);
		pWC.add(lbProfile);

		lbChat = new JLabel(new ImageIcon("images/iconchat+.png"), JLabel.CENTER);
		pWC.add(lbChat);

		lbFriend = new JLabel(new ImageIcon("images/iconfriend+.png"), JLabel.CENTER);
		pWC.add(lbFriend);

		lbSet = new JLabel(new ImageIcon("images/iconmusic+.png"), JLabel.CENTER);
		pWC.add(lbSet);

		lbPower = new JLabel(new ImageIcon("images/iconpower+.png"), JLabel.CENTER);
		pWS.add(lbPower);

		// LabelListener
		MyHandler handler = new MyHandler();
		lbProfile.addMouseListener(handler);
		lbChat.addMouseListener(handler);
		lbFriend.addMouseListener(handler);
		lbSet.addMouseListener(handler);
		lbPower.addMouseListener(handler);

		sub.lbEmoticon.addMouseListener(handler);
		sub.lbAlarm.addMouseListener(handler);

		// emoticon hanlder
		EMT.lE1.addMouseListener(handler);
		EMT.lE2.addMouseListener(handler);
		EMT.lE3.addMouseListener(handler);
		EMT.lE4.addMouseListener(handler);
		EMT.lE5.addMouseListener(handler);
		EMT.lE6.addMouseListener(handler);
		EMT.lE7.addMouseListener(handler);
		EMT.lE8.addMouseListener(handler);

		// SubChatPageBeta handler
		// revise insert lbClip addmouseListener
		sub.lbClip.addMouseListener(handler);
		// rivise insert lbcall addmoustListner

		sub.tf.addActionListener(handler);
		// Icon
		iprofile_ = new ImageIcon("images/iconprofile-.png");
		ichat_ = new ImageIcon("images/iconchat-.png");
		ifriend_ = new ImageIcon("images/iconfriend-.png");
		iset_ = new ImageIcon("images/iconmusic-.png");
		ipower_ = new ImageIcon("images/iconpower-.png");

		iprofile = new ImageIcon("images/iconprofile+.png");
		ichat = new ImageIcon("images/iconchat+.png");
		ifriend = new ImageIcon("images/iconfriend+.png");
		iset = new ImageIcon("images/iconmusic+.png");
		ipower = new ImageIcon("images/iconpower+.png");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// insert handler
		chatPage.chatTable.addMouseListener(handler);

	}// --

	// 쇼메시지
	private void showMsg(String string) {
		JOptionPane.showMessageDialog(chatPage, string);
	}// --showMsg

//   JTextPane 저장
	private void saveFile() {

		try {
			// sock=new Socket("localhost",port);
			// oos = new ObjectOutputStream(sock.getOutputStream());
			oos = new ObjectOutputStream(new FileOutputStream(
					"chatFile/" + chatPage.handler.userId + "과" + chatPage.handler.tableRow() + "님의 채팅.txt"));

			oos.writeObject(sub.chat1.tp);
			oos.flush();
			return;
		} catch (Exception e) {
			System.out.println("saveFile 예외 : " + e.getMessage());
		}
	}

	private void saveFile2() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					"chatFile/" + chatPage.handler.tableRow() + "과" + chatPage.handler.userId + "님의 채팅.txt"));
			SimpleAttributeSet attr = new SimpleAttributeSet();
			StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
			StyleConstants.setFontFamily(attr, "Default");
			sub.chat1.tp.setParagraphAttributes(attr, true);
			
			oos.writeObject(sub.chat1.tp);
			oos.flush();

		} catch (Exception e) {
			System.out.println("saveFile 예외 : " + e.getMessage());
		}
	}

//JTextPane 출력
	private void readFile() {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(
					"chatFile/" + chatPage.handler.tableRow() + "과" + chatPage.handler.userId + "님의 채팅.txt"));
			sub.chat1.tp = (JTextPane) oos.readObject();
			sub.chat1.sp.setViewportView(sub.chat1.tp);
			sub.chat1.tp.updateUI();
			sub.chat1.tp.setEditable(false); 
			sub.chat1.sp.setBorder(null);
			sub.chat1.sp.setPreferredSize(new Dimension(730,480));
			sub.chat1.tp.setBackground(Color.white);
//	        tp.setBackground(new Color(242,242,242));
//	        tp.setFont(font);
			sub.chat1.tp.setEnabled(false);	
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + ": error");
		}

	}

	// Event Handler
	class MyHandler implements MouseListener, ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == sub.tf) {
				String msg = sub.tf.getText();
				lc.sendMessage(msg + "\n");
				saveFile();
				sub.tf.setText("");
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == chatPage.chatTable) {
				sub.setLocation(430, 0);
				sub.setSize(720, 700);
				sub.setVisible(true);
				sub.chat1.tp.setText("");
				readFile();

			}
			if (obj == menu.lbExit) {
			}

			if (obj == lbProfile) {
				card.show(pC, "profilePage");
			} else if (obj == lbChat) {
				card.show(pC, "chatPage");
//            // sub.setUndecorated(true);
//            sub.setLocation(430, 0);
//            sub.setSize(1070, 700);
//            sub.setVisible(true);

				String id = lc.txId.getText();
				ArrayList<FriendVO> arr = frdao.selectFriendAll(id);

				if (arr == null) {
					return;
				}
				chatPage.showTable(arr);
			} else if (obj == lbFriend) {

				String id = lc.txId.getText();
				ArrayList<FriendVO> arr = frdao.selectFriendAll(id);

				if (arr == null) {
					return;
				}
				friendPage.showTable(arr);

				card.show(pC, "friendPage");

			} else if (obj == lbSet) {
				card.show(pC, "setPage");
				String id = lc.txId.getText();
				ArrayList<MusicVO> arr = msdao.selecMusicAll(id);
				if (arr == null) {
					return;
				}
				setPage.showTable(arr);
			} else if (obj == lbPower) {
				System.exit(0);
			}

			// SubChatPage.chat1

			if (obj == sub.lbEmoticon) {
				EMT.setVisible(true);
				EMT.setBounds(200, 400, 400, 200);

			} else if (obj == sub.lbClip) {
				fileChooser2 select = new fileChooser2();
				select.main(null);

				String ImgName = select.file.getName();
				String ImageLocal = select.file.getAbsoluteFile().toString();

				ImageIcon ic = new ImageIcon(ImageLocal);
				lc.sendImg(ic);

				// 솾 꺂 뒧占쎈떔 뜝 룞 삕占쎈쐻占쎈윥 뜝占 뜝 럥 맶 뜝 럥 쑋占쎌뼚伊됮 얜퀫移계쳸硫멸킀占쎈쐻占쎈윥 굜占
			} 

				// revise vidio setbounds

			
			if (obj == EMT.lE1) {
				lc.sendEmoticon(lc.icon1);
			} else if (obj == EMT.lE2) {
				lc.sendEmoticon(lc.icon2);
			} else if (obj == EMT.lE3) {
				lc.sendEmoticon(lc.icon3);
				EMT.setVisible(false);
			} else if (obj == EMT.lE4) {
				lc.sendEmoticon(lc.icon4);
			} else if (obj == EMT.lE5) {
				lc.sendEmoticon(lc.icon5);
			} else if (obj == EMT.lE6) {
				lc.sendEmoticon(lc.icon6);
			} else if (obj == EMT.lE7) {
				lc.sendEmoticon(lc.icon7);
			} else if (obj == EMT.lE8) {
				lc.sendEmoticon(lc.icon8);
			}
			
	}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		 @Override
	      public void mouseEntered(MouseEvent e) {
	         Object obj=e.getSource();
	         if(obj==lbProfile) {
	            lbProfile.setIcon(iprofile_);
	         }else if(obj==lbChat) {
	            lbChat.setIcon(ichat_);   
	         }else if(obj==lbFriend) {
	            lbFriend.setIcon(ifriend_);
	         }else if(obj==lbSet) {
	            lbSet.setIcon(iset_);
	         }else if(obj==lbPower) {
	            lbPower.setIcon(ipower_);
	         }
	      }

	      @Override
	      public void mouseExited(MouseEvent e) {
	         Object obj=e.getSource();
	         if(obj==lbProfile) {
	            lbProfile.setIcon(iprofile);
	         }else if(obj==lbChat) {
	            lbChat.setIcon(ichat);   
	         }else if(obj==lbFriend) {
	            lbFriend.setIcon(ifriend);
	         }else if(obj==lbSet) {
	            lbSet.setIcon(iset);
	         }else if(obj==lbPower) {
	            lbPower.setIcon(ipower);
	            
	   
	      }
	      
	   } 
	}
}