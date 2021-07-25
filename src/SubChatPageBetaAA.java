import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class SubChatPageBetaAA extends JFrame {
	JPanel p = new JPanel(new BorderLayout());

	// pages
	ChatArea1 chat1;

	// Font
	Font font = new Font("", Font.BOLD, 20);

	boolean bool = true;

	// Panel
	JPanel pC = new JPanel();
	JPanel pN = new JPanel();
	JPanel pNW = new JPanel();
	JPanel pS = new JPanel();

	JTextField chatWith = new JTextField();
	JTextField tf = new JTextField();

	JLabel lbAlarm = new JLabel(new ImageIcon("images/alarmOn+.png"), JLabel.CENTER);
	JLabel lbBm = new JLabel(new ImageIcon("images/message+white.png"), JLabel.CENTER);
	JLabel lbEmoticon = new JLabel(new ImageIcon("images/iconemoticon+.png"), JLabel.CENTER);
	JLabel lbClip = new JLabel(new ImageIcon("images/iconclip+.png"), JLabel.CENTER);

	Icon iemoticon_ = new ImageIcon("images/iconemoticon-.png");
	Icon iclip_ = new ImageIcon("images/iconclip-.png");

	Icon iemoticon = new ImageIcon("images/iconemoticon+.png");
	Icon iclip = new ImageIcon("images/iconclip+.png");
	Icon iAlarmOn = new ImageIcon("images/alarmOn+.png");
	Icon iAlarmOff = new ImageIcon("images/alarmOff+.png");

	public SubChatPageBetaAA() {
		chatWith.setFont(font);
		chatWith.setForeground(Color.white);
		chatWith.setBorder(null);
		chatWith.setEditable(false);

		// label handler
		MyHandler handler = new MyHandler();
		lbEmoticon.addMouseListener(handler);
		lbClip.addMouseListener(handler);
		lbAlarm.addMouseListener(handler);

		// add ChatPages to Panel Center
		pC.add(chat1, "Center");
		
		pN.setBackground(new Color(73, 159, 228));

		pNW.setBackground(new Color(73, 159, 228));

		chatWith.setBackground(new Color(73, 159, 228));

		GroupLayout pNWLayout = new GroupLayout(pNW);
		pNW.setLayout(pNWLayout);
		pNWLayout
				.setHorizontalGroup(
						pNWLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pNWLayout.createSequentialGroup()
										.addComponent(chatWith, GroupLayout.PREFERRED_SIZE, 217,
												GroupLayout.PREFERRED_SIZE)
										.addGap(0, 133, Short.MAX_VALUE)));
		pNWLayout
				.setVerticalGroup(
						pNWLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pNWLayout.createSequentialGroup()
										.addComponent(chatWith, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(0, 18, Short.MAX_VALUE)));
		GroupLayout pNLayout = new GroupLayout(pN);
		pN.setLayout(pNLayout);
		pNLayout.setHorizontalGroup(pNLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pNLayout.createSequentialGroup()
						.addComponent(pNW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							 	GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbBm, GroupLayout.PREFERRED_SIZE, 80,
							 	GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
						.addComponent(lbAlarm, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		                .addContainerGap())
		        );
		pNLayout.setVerticalGroup(pNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
			 	GroupLayout.Alignment.TRAILING,
				pNLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addGroup(pNLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pNW, GroupLayout.PREFERRED_SIZE,
									 	GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(
										pNLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(lbBm, GroupLayout.Alignment.LEADING,
													 	GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
												.addComponent(lbAlarm, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		        );
		pS.setBackground(new Color(73, 159, 228));

		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tfActionPerformed(evt);
			}
		});

	 	GroupLayout pSLayout = new GroupLayout(pS);
		pS.setLayout(pSLayout);
		pSLayout.setHorizontalGroup(pSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pSLayout.createSequentialGroup()
						.addComponent(lbEmoticon, GroupLayout.PREFERRED_SIZE, 86,
							 	GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lbClip, GroupLayout.PREFERRED_SIZE, 86,
							 	GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tf, GroupLayout.PREFERRED_SIZE, 510,
							 	GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pSLayout.setVerticalGroup(pSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pSLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addGroup(pSLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(lbClip, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lbEmoticon, GroupLayout.DEFAULT_SIZE,
									 	GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(GroupLayout.Alignment.TRAILING, pSLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(tf,
							 	GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(16, 16, 16)));

	 	GroupLayout pCLayout = new GroupLayout(pC);
		pC.setLayout(pCLayout);
		pCLayout.setHorizontalGroup(pCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(pS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pCLayout
						.createSequentialGroup().addComponent(pN, GroupLayout.PREFERRED_SIZE,
							 	GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		pCLayout.setVerticalGroup(pCLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pCLayout.createSequentialGroup()
						.addComponent(pN, GroupLayout.PREFERRED_SIZE, 70,
							 	GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
						.addComponent(pS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							 	GroupLayout.PREFERRED_SIZE)));

	 	GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addComponent(pC, GroupLayout.PREFERRED_SIZE,
							 	GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pC,
			 	GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
		
	
	public void tfActionPerformed(ActionEvent evt) {
	}

	class MyHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();

			if (obj == lbEmoticon) {
				lbEmoticon.setIcon(iemoticon_);
			} else if (obj == lbClip) {
				lbClip.setIcon(iclip_);
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			Object obj = e.getSource();

			if (obj == lbEmoticon) {
				lbEmoticon.setIcon(iemoticon);
			} else if (obj == lbClip) {
				lbClip.setIcon(iclip);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == lbAlarm && bool == true) {
				lbAlarm.setIcon(iAlarmOff);
				bool = false;
			} else if (obj == lbAlarm && bool == false) {
				lbAlarm.setIcon(iAlarmOn);
				bool = true;
			}
		}

	}

}
