import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class LoginChat extends JFrame implements Runnable {

	JButton btLogin, btRegist, btExit; //
	JLabel lbId, lbPwd; //
	JTextField txId; //
	JPasswordField txPwd; //
	boolean isLogin = false; //

	// 이미지 아이콘생성
	ImageIcon icon1 = new ImageIcon("images/img1.gif");
	ImageIcon icon2 = new ImageIcon("images/img2.gif");
	ImageIcon icon3 = new ImageIcon("images/img3.png");
	ImageIcon icon4 = new ImageIcon("images/img4.png");
	ImageIcon icon5 = new ImageIcon("images/img5.gif");
	ImageIcon icon6 = new ImageIcon("images/img6.gif");
	ImageIcon icon7 = new ImageIcon("images/img9.png");
	ImageIcon icon8 = new ImageIcon("images/img8.png");
	// 소켓 생성 및 스타일
	private StyledDocument doc;

	Socket sock;
	final int port = 9999;
	ObjectInputStream Din;
	ObjectOutputStream Dout;
	String host, nick, id;

	Thread listener;
	boolean isStop = false;

	BlumingDAO dao = new BlumingDAO();
	Font CS18 = new Font("SF Comic Script", Font.BOLD, 18);
	Font CS24 = new Font("SF Comic Script", Font.BOLD, 24);
	Font CS30 = new Font("SF Comic Script", Font.BOLD, 30);

	JPanel jp; //
	JPanel p = new JPanel(); //

	ImageIcon backgroundImage = new ImageIcon("images/message+white.png");
	Image img = backgroundImage.getImage();
	Image changeImg = img.getScaledInstance(60, 60, DO_NOTHING_ON_CLOSE);
	ImageIcon changIcon = new ImageIcon(changeImg);

	RegisterChat rt = RegisterChat.getInstance();
	MainChatBeta mc;
	SubChatPageBeta sub;

	public LoginChat() {
		super("Bluming Login");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(new Color(73, 159, 228));

		jp = new JPanel() { //
			public void paint(Graphics g) {

				g.drawImage(changeImg, 10, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		p.setLayout(null); //

		jp.setBounds(150, 10, 200, 140);

		lbId = new JLabel("Username:"); //
		lbId.setForeground(Color.white);
		lbId.setBounds(40, 160, 100, 30);
		lbId.setFont(CS18);

		lbPwd = new JLabel("Password :"); //
		lbPwd.setForeground(Color.white);
		lbPwd.setBounds(40, 210, 100, 30);
		lbPwd.setFont(CS18);

		txId = new JTextField(); // text
		txId.setOpaque(false);
		txId.setForeground(Color.white);
		txId.setFont(CS18);
		txId.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));

		txPwd = new JPasswordField(); // password
		txPwd.setOpaque(false);
		txPwd.setForeground(Color.white);
		txPwd.setFont(CS18);
		txPwd.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));

		btLogin = new JButton("Login");
		btLogin.setOpaque(false);
		btLogin.setBorderPainted(false);
		btLogin.setFont(CS18);

		btRegist = new JButton("Join");
		btRegist.setOpaque(false);
		btRegist.setBorderPainted(false);
		btRegist.setFont(CS24);

		btExit = new JButton("Exit");
		btExit.setOpaque(false);
		btExit.setBorderPainted(false);
		btExit.setFont(CS24);

		btLogin.setBounds(85, 270, 200, 70); //
		btLogin.setBackground(Color.BLUE);
		btLogin.setForeground(Color.white);

		btRegist.setBounds(70, 500, 100, 50);
		btRegist.setBackground(Color.BLUE);
		btRegist.setForeground(Color.white);

		btExit.setBounds(200, 500, 100, 50);
		btExit.setBackground(Color.BLUE);
		btExit.setForeground(Color.white);

		txId.setBounds(150, 160, 150, 30);
		txPwd.setBounds(150, 210, 150, 30);

		p.add(jp);
		p.add(txId);
		p.add(txPwd);
		p.add(lbId);
		p.add(lbPwd);
		p.add(btLogin);
		p.add(btRegist);
		p.add(btExit);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x
		this.setUndecorated(true);

		sub = new SubChatPageBeta();
		mc = new MainChatBeta(this);
		doc = mc.sub.chat1.tp.getStyledDocument();

		btLogin.addActionListener(new ActionListener() { //
			public void actionPerformed(ActionEvent e) {

				loginCheck();

				if (isLogin == true) {
					String id;
					id = txId.getText();
					char[] pwd;
					pwd = txPwd.getPassword(); // password
					String upw = new String(pwd);
					ArrayList<BlumingVO> arr = dao.profilePeople(id, upw);
					mc.profilePage.showUsers(arr); // show profile

					mc.setSize(450, 700);
					mc.setVisible(true);
					dispose();
					chatLogin();
				}

			}
		});

		btRegist.addActionListener(new ActionListener() { //
			public void actionPerformed(ActionEvent e) {
				rt.setSize(370, 700);
				rt.setUndecorated(true);
				rt.setVisible(true);
				rt.setLocation(800, 200);
			}
		});

		btExit.addActionListener(new ActionListener() { //
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		rt.btCancel.addActionListener(new ActionListener() { //
			public void actionPerformed(ActionEvent e) {
				rt.setVisible(false);
				rt.dispose();

			}
		});

	}// ------

	public void run() {

		mc.setPage.handler.userId = txId.getText();

		mc.chatPage.handler.userId = mc.profilePage.tfName.getText();

		mc.chatPage.handler.tpMsg = mc.sub.chat1.tp;
		mc.chatPage.handler.jscroll = mc.sub.chat1.sp;

//		mc.sub.row = mc.chatPage.chatTable.getSelectedRow();
//		mc.sub.friendId = (String) mc.chatPage.chatTable.getValueAt(mc.sub.row, 1);

		try {
			sock = new Socket("192.168.0.215", 9999);
			Dout = new ObjectOutputStream(sock.getOutputStream());
			Din = new ObjectInputStream(sock.getInputStream());
			System.out.println(Dout + "/" + nick);
			// 닉네임을 서버쪽에 보내기
			Dout.writeObject(nick);
			Dout.flush();
			// 서버가 보내오는 메시지를 듣는 메소드
			listen();

		} catch (IOException e) {
			String msg = "\n서버 접속 또는 듣는 중 예외 발생" + e + "\n";
			System.out.println("클의 run() 예외" + e + "\n");
			e.printStackTrace();

			try {
				close();
			} catch (IOException e1) {

				System.out.println("오류발생: " + e.getMessage());
			}
		}

	}// --run() 끝

	public void chatLogin() {

		// 스레드 실행
		if (listener == null) {

			listener = new Thread(this);
			listener.start();
		}

	}// --chatLogin() 끝

	public void showImg() {
		while (isStop) {
			try {
				Object serMsg = Din.readObject();

				int pos = doc.getEndPosition().getOffset() - 1;
				mc.sub.chat1.tp.setCaretPosition(pos);
				SimpleAttributeSet attr = new SimpleAttributeSet();
				String reciveMsg = serMsg.toString();
				String sendNick = nick;

				ImageIcon selectImg = new ImageIcon(serMsg.toString());
				JLabel lbImg = new JLabel(nick, selectImg, JLabel.CENTER);
				lbImg.setPreferredSize(new Dimension(700, 200));
				lbImg.setHorizontalTextPosition(JLabel.CENTER);
				lbImg.setVerticalTextPosition(JLabel.TOP);

				if (sendNick.equals(nick)) {
					attr = new SimpleAttributeSet();
					StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
					mc.sub.chat1.tp.setCaretPosition(pos);
					this.setStyle(lbImg, nick, attr);
				} else {
					attr = new SimpleAttributeSet();
					StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
					mc.sub.chat1.tp.setCaretPosition(pos);
					this.setStyle(lbImg, nick, attr);
				}

			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void listen() throws IOException {

		while (!isStop) {
			try {
				Object serMsg = Din.readObject();
				doc = mc.sub.chat1.tp.getStyledDocument();
				int pos = doc.getEndPosition().getOffset() - 1;
				mc.sub.chat1.tp.setCaretPosition(pos);
				SimpleAttributeSet attr = new SimpleAttributeSet();
				String reciveMsg = serMsg.toString();
				String sendNick = reciveMsg.split(">>")[0];

				// Enter Emoticon
				if (reciveMsg.split("/")[0].equals("images")) {
					ImageIcon selectIcon = new ImageIcon(serMsg.toString());
					JLabel lbIcon = new JLabel("[" + nick + "]님의 메세지", selectIcon, JLabel.CENTER);
					lbIcon.setPreferredSize(new Dimension(700, 200));
					lbIcon.setHorizontalTextPosition(JLabel.CENTER);
					lbIcon.setVerticalTextPosition(JLabel.TOP);
					lbIcon.setOpaque(false);

					if (mc.chatPage.handler.userId.equals(mc.chatPage.handler.tableRow())) {
						attr = new SimpleAttributeSet();
						StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
						mc.sub.chat1.tp.setCaretPosition(pos);
						this.setStyle(lbIcon, nick, attr);
						System.out.println(mc.chatPage.handler.userId + "Right");
					} else {
						attr = new SimpleAttributeSet();
						StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
						mc.sub.chat1.tp.setCaretPosition(pos);
						this.setStyle(lbIcon, nick, attr);
						System.out.println(mc.chatPage.handler.userId);

					}
					// send selectImages
				} else if (reciveMsg.split(":")[0].equals("C") || reciveMsg.split(":")[0].equals("D")) {
					ImageIcon selectImg = new ImageIcon(serMsg.toString());
					JLabel lbImg = new JLabel(nick, selectImg, JLabel.CENTER);
					lbImg.setPreferredSize(new Dimension(700, 200));
					lbImg.setHorizontalTextPosition(JLabel.CENTER);
					lbImg.setVerticalTextPosition(JLabel.TOP);

					if (mc.chatPage.handler.userId.equals(mc.chatPage.handler.tableRow())) {
						attr = new SimpleAttributeSet();
						StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
						mc.sub.chat1.tp.setCaretPosition(pos);
						this.setStyle(lbImg, nick, attr);
					} else {
						attr = new SimpleAttributeSet();
						StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
						mc.sub.chat1.tp.setCaretPosition(pos);
						this.setStyle(lbImg, nick, attr);
					}

					// Enter Chat
				} else {

					attr = new SimpleAttributeSet();
					StyleConstants.setFontSize(attr, 22);
					StyleConstants.setForeground(attr, Color.red);
					// My Nick
					if (sendNick.equals(nick)) {
						try {
							StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
							StyleConstants.setBackground(attr, new Color(48,110,159));
							doc.insertString(pos, reciveMsg, attr);

						} catch (BadLocationException e) {
							e.printStackTrace();
						}
						doc.setParagraphAttributes(pos + 1, reciveMsg.length(), attr, true);
						// Your Nick
					} else {
						try {
							StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
							StyleConstants.setBackground(attr, new Color(73,159,228));
							doc.insertString(pos, reciveMsg, attr);
						} catch (BadLocationException e) {
							e.printStackTrace();
						}
						doc.setParagraphAttributes(pos + 1, reciveMsg.length(), attr, true);
					}
				}
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	// --listen() 끝
	public void showEmoticon(String from, ImageIcon icon) {

		String str = "[" + nick + "]님\r\n";
		JLabel lb = new JLabel(str, icon, JLabel.CENTER);
		lb.setPreferredSize(new Dimension(700, 200));
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.TOP);

		SimpleAttributeSet attr = null;

		if (nick.equals(nick)) {
			attr = new SimpleAttributeSet();
			StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);

		} else {
			attr = new SimpleAttributeSet();
			StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
		}
		int pos = doc.getEndPosition().getOffset() - 1;
		mc.sub.chat1.tp.setCaretPosition(pos);
		this.setStyle(lb, str, attr);
	}

	public void setStyle(JLabel lb, String msg, SimpleAttributeSet attr) {

		int pos = doc.getEndPosition().getOffset() - 1;
		mc.sub.chat1.tp.setCaretPosition(pos);
		mc.sub.chat1.tp.insertComponent(lb);
		String enter = "\r\n";
		pos = doc.getEndPosition().getOffset() - 1;
		try {
			doc.insertString(pos, enter, attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		doc.setParagraphAttributes(pos + 1, msg.length(), attr, true);
		mc.sub.chat1.tp.setCaretPosition(pos + 1);
	}

	public void sendMessage(String myMsg) {
		try {
			Dout.writeObject("" + nick + ">>" + myMsg);
			Dout.flush();
		} catch (IOException e) {
			System.out.println("sendMessage()예외: " + e);
		}

	}// --sendMessage() 끝
		//

	public void sendEmoticon(ImageIcon icon) {
		try {
			Dout.writeObject(icon);
			Dout.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendImg(ImageIcon img) {
		try {
			Dout.writeObject(img);
			Dout.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void close() throws IOException {
		isStop = true;
		if (Din != null)
			Din.close();
		if (Dout != null)
			Dout.close();
		if (sock != null)
			sock.close();

	}// --close() 끝

	public void loginCheck() {

		String id;
		id = txId.getText(); // id
		nick = id;
		char[] pwd;

		pwd = txPwd.getPassword(); // password
		String upw = new String(pwd);

		if (id == null || upw == null || id.trim().equals("") || upw.trim().equals("")) {
			showMsg("Please enter your Username and Password");
			return;
		} else {
			boolean b = dao.logincheckPeople(id, upw);
			if (!b) {
				JOptionPane.showMessageDialog(this, "please check ID or Password");
				return;
			} else {
				dao.loginPeople(id, upw);
				showMsg("Welcome to Bluming! " + id + "!!");
				isLogin = true;
			}
		}
		id = id.trim(); // trim
		upw = upw.trim();

	}

	public void showMsg(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public static void main(String[] args) {
		LoginChat my = new LoginChat();
		my.setSize(370, 700);
		my.setUndecorated(true);
		my.setVisible(true);
		my.setLocation(800, 200);
	}

}