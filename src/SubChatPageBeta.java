import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SubChatPageBeta extends javax.swing.JFrame {
	
	JTextField chatWith;
	JLabel lbClip;
	JLabel lbEmoticon;
	JLabel lbAlarm;
	JLabel lbBm;
	JPanel p;
	JPanel pC;
	JPanel pN;
	JPanel pNW;
	JPanel pS;
	JTextField tf;
	
	int row;
	String friendId;
	// Pages
	ChatArea1 chat1;

	// Font
	Font font = new Font("", Font.BOLD, 20);

	// Icon clicked action
	Icon iemoticon_, iclip_;
	Icon iemoticon, iclip, iAlarmOn, iAlarmOff;

	boolean bool = true;

	public SubChatPageBeta() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	public void initComponents() {

		p = new javax.swing.JPanel();//Panel Center
		pC = new javax.swing.JPanel();//Panel Center
		pN = new javax.swing.JPanel();//Panel North
		pNW = new javax.swing.JPanel();//Panel North West
		chatWith = new javax.swing.JTextField();//Chatting with 
		lbAlarm = new javax.swing.JLabel();
		lbBm = new javax.swing.JLabel();
		pS = new javax.swing.JPanel();
		lbEmoticon = new javax.swing.JLabel();
		lbClip = new javax.swing.JLabel();
		tf = new javax.swing.JTextField();

		chat1 = new ChatArea1();

		// Label images (Panel)
		lbBm = new JLabel(new ImageIcon("images/message+white.png"), JLabel.CENTER);
		lbEmoticon = new JLabel(new ImageIcon("images/iconemoticon+.png"), JLabel.CENTER);
		lbClip = new JLabel(new ImageIcon("images/iconclip+.png"), JLabel.CENTER);
		lbAlarm = new JLabel(new ImageIcon("images/alarmOn+.png"), JLabel.CENTER);

		iemoticon_ = new ImageIcon("images/iconemoticon-.png");
		iclip_ = new ImageIcon("images/iconclip-.png");

		iemoticon = new ImageIcon("images/iconemoticon+.png");
		iclip = new ImageIcon("images/iconclip+.png");
		iAlarmOn = new ImageIcon("images/alarmOn+.png");
		iAlarmOff = new ImageIcon("images/alarmOff+.png");

		//Chatting with(Panel North West)
		chatWith.setFont(font);
		chatWith.setForeground(Color.white);
		chatWith.setBorder(null);
		chatWith.setEditable(false);
		
		//chatWith.add(tableRow());
		
		// label handler
		MyHandler handler = new MyHandler();
		lbEmoticon.addMouseListener(handler);
		lbClip.addMouseListener(handler);
		lbAlarm.addMouseListener(handler);
		
		//add ChatPages to Panel Center
		pC.add(chat1,"Center");
		

		// --------------VV--AUTO NETBEAN CODES--VV----------------------

		pN.setBackground(new java.awt.Color(73, 159, 228));

		pNW.setBackground(new java.awt.Color(73, 159, 228));

		chatWith.setBackground(new java.awt.Color(73, 159, 228));

		javax.swing.GroupLayout pNWLayout = new javax.swing.GroupLayout(pNW);
        pNW.setLayout(pNWLayout);
        pNWLayout.setHorizontalGroup(
            pNWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNWLayout.createSequentialGroup()
                .addComponent(chatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        pNWLayout.setVerticalGroup(
            pNWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pNLayout = new javax.swing.GroupLayout(pN);
        pN.setLayout(pNLayout);
        pNLayout.setHorizontalGroup(
            pNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNLayout.createSequentialGroup()
                .addComponent(pNW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(lbAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pNLayout.setVerticalGroup(
            pNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbBm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAlarm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pNW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pS.setBackground(new java.awt.Color(73, 159, 228));

        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSLayout = new javax.swing.GroupLayout(pS);
        pS.setLayout(pSLayout);
        pSLayout.setHorizontalGroup(
            pSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSLayout.createSequentialGroup()
                .addComponent(lbClip, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmoticon, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pSLayout.setVerticalGroup(
            pSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbClip, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(lbEmoticon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pLayout.createSequentialGroup()
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addComponent(pN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

	public void tfActionPerformed(java.awt.event.ActionEvent evt) {
	}

//	public String tableRow() {
//		   
//		   int row=this.row;
//		   String friendId=this.friendId;
//		   
//		   return friendId;
//	   }
	

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