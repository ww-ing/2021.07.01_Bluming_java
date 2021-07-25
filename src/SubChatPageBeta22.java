import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SubChatPageBeta22 extends JFrame {
   JPanel p = new JPanel(new BorderLayout());
   JPanel pN, pS, pC;
   
   JTextField tf=new JTextField("",45);
   JTextField chatName=new JTextField("",45);
   JTextField chatWith=new JTextField("",45);
   
   //JLabel default icon
   JLabel lbEmoticon, lbClip, lbMenu;
   
   //Icon clecked acction
   Icon iemoticon_, iclip_, imenu_;
   Icon iemoticon, iclip, imenu;
   
   //TextField style
   LineBorder lineBorder =new LineBorder(Color.white, 5, true);
   LineBorder lineBorderChatName =new LineBorder(Color.white, 0, true);
   
   Font font = new Font("", Font.BOLD,20);
  
   
   
   //�떆�옉
   //�씠紐⑦ �� ��� 
//   list lE = new list(); //�  �찓�씤 �씠紐⑦ �� ���  �겢 ���� �� �굹�삤�뒗 �봽�젅�엫
//   JPanel pEmoticon = new JPanel(); //�봽�젅�엫�쓽 硫붿 ���뙣�꼸 
    
//   JLabel lE1,lE2,lE3,lE4,lE5,lE6,lE7,lE8;//�씠紐⑦ �� ���  �씪踰�
   
   //�뵆�윭�뒪踰꾪 ��
   JFrame lP = new JFrame();//�  �찓�씤 �뵆�윭�뒪 �겢 ���� �� �굹�삤�뒗 �봽�젅�엫
   JPanel pPlus =  new JPanel();//�  �찓�씤 �뵆�윭�뒪 �겢 ���� �� �굹�삤�뒗 �뙣�꼸
   
   //�꽱�뱶
   
   //硫붾 ��
   		list lM = new list();//�  �찓�씤 硫붾 �� �겢 ���� �� �굹�삤�뒗 �봽�젅�엫
   		JPanel pMenu = new JPanel();//�  �찓�씤 硫붾 �� �겢 ���� �� �굹�삤�뒗 硫붾 ��李�
      //硫붾 �� �븣 �� ��� �듉
      JLabel lm1=new JLabel();//硫붾 ��李� 泥ル쾲吏�  �븣 �� ��� �듉 �씪踰�
      boolean b1 = true;//�븣 ���  �삩�삤�봽 true or false
      //硫붾 �� 移쒓 �� �� ����� 湲� �씪踰�
      JLabel lm2=new JLabel(); //硫붾 ��李� �몢踰덉 �� 移쒓 �� �� ���  �씪踰�
      JFrame fr=new JFrame();//移쒓 �� �� ���  �겢 ���� �� �굹�삤�뒗 �쟾泥댄봽� ���엫
      JPanel pInvite=new JPanel();////移쒓 �� �� ���  �겢 ���� �� �굹�삤�뒗�뙣�꼸 洹몃 ���뱶 1�뻾3�뿴
      JPanel pi=new JPanel();//�봽濡쒗�  �씠誘몄�  �쇊履� �뙣�꼸  4�뻾1�뿴
      JLabel lPf1 = new JLabel();//�봽濡쒗�  �씠誘몄�  �쇊履�  ���꼸 �씠誘몄�  �씪踰�
      JLabel lPf2 = new JLabel();
      JLabel lPf3 = new JLabel();
      JLabel lPf4 = new JLabel();
      JPanel pC2=new JPanel();//�씠 ���  + �옄湲곗 ��媛쒓�  媛��슫�뜲 �뙣�꼸 8�뻾1�뿴
      JPanel pIE=new JPanel();// �� ���蹂  궡湲� "+"踰꾪 �� �삤 ����そ �뙣�꼸 4�뻾 1�뿴
      JLabel l1,l2,l3,l4,l5,l6,l7,l8;//�씠 ���  諛� �옄湲곗 ��媛쒓�  �씪踰�
      JButton BInvite1,BInvite2,BInvite3,BInvite4;// �� ����� 湲�"+"踰꾪 ��
      //硫붾 �� �궡�슜 �� ��린� ��
      JLabel lm3=new JLabel();//硫붾 ��李� 3踰덉 �� 湲��옄吏��슦湲�
      //� 꾪똿李� �떕湲�
      JLabel lm4=new JLabel();//硫붾�ㅻ�  4踰덉 �� � 꾪똿李쎈걚湲� 
      
   // ��꾨뵒�삤 李� 
   JPanel lbVidio= new JPanel();//�  �찓�씤  ��꾨뵒�삤�씪踰�
   JFrame lV=new JFrame();// ��꾨뵒�삤�씪踰� �겢 ���� �� �굹�삤�뒗 �봽�젅�엫
   JPanel pVidio = new JPanel();//�봽�젅�엫�쓽 �쟾泥댄 ���꼸   
   JPanel pVS=new JPanel(); //�븘�옒踰꾪 ���뙣�꼸
   JButton Bmic= new JButton();
   JButton Bsound = new JButton();;
   JButton Bexitcall = new JButton();;
   JButton BVolume = new JButton();//留덉 ���겕�삩�삤�봽/�궗�슫�뱶�삩�삤�봽/�쟾�솕  �� ���� /蹂쇰 ��議곗 ��
   boolean b4=true , b5=true;//4�뒗 留덉 ���겕 �삩�삤�봽/5�뒗 �궗�슫�뱶 �삩�삤�봽   
   
   //revise insert Frame
   JFrame fC=new JFrame();
   JPanel pCN=new JPanel();
   JPanel pNN=new JPanel(new FlowLayout(20,0,0));
   JPanel pSS=new JPanel();
   JPanel pNW=new JPanel();
   JLabel lS=new JLabel();
   JButton Bcall;
   boolean bf = true;
   
   //CardLayout Panel Center
   CardLayout card;
   
   //Pages
   ChatArea1 chat1;

   public SubChatPageBeta22() {
      super(":::SubChatPageBeta:::");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      
      //PanelNorth
      pN=new JPanel(new FlowLayout(2,30,10));
      p.add(pN,"North");
      pN.setBackground(new Color(73,159,228));
      pN.setPreferredSize(new Dimension(ABORT,70));
      
      pNW=new JPanel(new BorderLayout(0,0));//--------------------Edited------------------------
      pNW.setPreferredSize(new Dimension(ABORT,40));
      //PanelSouth
      pS=new JPanel(new FlowLayout(0,30,5));
      p.add(pS,"South");
      pS.setBackground(new Color(73,159,228));
      pS.setPreferredSize(new Dimension(ABORT,65));
      
      //PanelCenter
      pC=new JPanel();
      p.add(pC,"Center");
      pC.setPreferredSize(new Dimension(ABORT,ABORT));
      pC.setBackground(new Color(242,242,242));
      pC.setLayout(card=new CardLayout());
      
      //Pages
      chat1=new ChatArea1();
      
      //add ChatPages to Panel Center
      pC.add(chat1,"Center");
      
      //Label images (Panel)
      lbEmoticon=new JLabel(new ImageIcon(
            "images/iconemoticon+.png"),JLabel.CENTER);
      
      lbClip=new JLabel(new ImageIcon(
            "images/iconclip+.png"),JLabel.CENTER);
      
      lbMenu=new JLabel(new ImageIcon(
            "images/iconmenu+.png"),JLabel.CENTER);
      
      //TextField style
      tf.setBorder(lineBorder);
      tf.setFont(font);
//      tf.setOpaque(false);
      tf.setForeground(Color.black);
      
      chatName.setBorder(lineBorderChatName);
      chatName.setFont(font);
      chatName.setEnabled(true);
      chatName.setOpaque(true);
      chatName.setForeground(Color.white);
      
      chatName.setBorder(lineBorder);
      chatWith.setFont(font);
      chatWith.setForeground(Color.white);
      
      
      //add Label
      pS.add(lbEmoticon);
      pS.add(lbClip);
      pS.add(tf);
      pN.add(chatName);
      pN.add(lbMenu);
      pN.add(pNW,"West");
      
      pNW.add(chatWith);
      
      
      lV.add(lPf1);
      lV.add(lPf2);
      lV.add(pVidio);
      lV.add(pVS,"South");
      
      //revise vidio 
      JLabel lvImages=new JLabel(new ImageIcon("Images/callGIF.gif"));
      lV.add(pVidio);
      lV.add(lvImages);
      lV.add(pVS,"South");
      
      //LabelListener
      MyHandler handler = new MyHandler();
      lbEmoticon.addMouseListener(handler);
      lbClip.addMouseListener(handler);
      lbMenu.addMouseListener(handler);
      
      //Icon
      iemoticon_=new ImageIcon("images/iconemoticon-.png");
      iclip_=new ImageIcon("images/iconclip-.png");
      imenu_=new ImageIcon("images/iconmenu-.png");
      
      iemoticon=new ImageIcon("images/iconemoticon+.png");
      iclip=new ImageIcon("images/iconclip+.png");
      imenu=new ImageIcon("images/iconmenu+.png");
      
      //�씠紐⑦ �� ���  �뙣�꼸
//      pEmoticon.setBackground(Color.white);
//      pEmoticon.setLayout(new GridLayout(2, 4, 2, 0));
      //硫붾 �� �뙣�꼸
      pMenu.setLayout(new GridLayout(4, 1, 0, 0));
      
      //硫붾 �� 移쒓 �� �� ���  踰꾪 �� 
      Font CS50 = new Font("", Font.BOLD,50);
      BInvite1=new JButton("+");
      BInvite1.setOpaque(false);
      BInvite1.setBorderPainted(false);
      BInvite1.setBackground(Color.BLUE);
      BInvite1.setForeground(Color.white);
      BInvite1.setFont(CS50);
            
      BInvite2=new JButton("+");
      BInvite2.setOpaque(false);
      BInvite2.setBorderPainted(false);
      BInvite2.setBackground(Color.BLUE);
      BInvite2.setForeground(Color.white);
      BInvite2.setFont(CS50);
            
      BInvite3=new JButton("+");
      BInvite3.setOpaque(false);
      BInvite3.setBorderPainted(false);
      BInvite3.setBackground(Color.BLUE);
      BInvite3.setForeground(Color.white);
      BInvite3.setFont(CS50);
            
      BInvite4=new JButton("+");
      BInvite4.setOpaque(false);
      BInvite4.setBorderPainted(false);
      BInvite4.setBackground(Color.BLUE);
      BInvite4.setForeground(Color.white);
      BInvite4.setFont(CS50);
      
      // ��꾨뵒�삤 留덉 ���겕
      Bmic=new JButton(new ImageIcon("Images/micon.png"));
      Bmic.setOpaque(false);
      Bmic.setBackground(new Color(73,159,228));
      Bmic.setBorderPainted(false);
      
      Bsound=new JButton(new ImageIcon("Images/soundOn.png"));
      Bsound.setOpaque(false);
      Bsound.setBackground(new Color(73,159,228));
      Bsound.setBorderPainted(false);
      
      Bexitcall=new JButton(new ImageIcon("Images/callOff.png"));
      Bexitcall.setOpaque(false);
      Bexitcall.setBackground(new Color(73,159,228));
      Bexitcall.setBorderPainted(false);
      
      //revise iconimages
      BVolume=new JButton(new ImageIcon("Images/vidCall.png"));
      BVolume.setOpaque(false);
      BVolume.setBackground(new Color(73,159,228));
      BVolume.setBorderPainted(false);
      
      //revise insert call
      
      Bcall = new JButton(new ImageIcon("Images/callOff.png"));
      Bcall.setOpaque(false);
      Bcall.setBorderPainted(false);
      Bcall.setBackground(Color.BLUE);
      Bcall.setForeground(Color.white);
            
      fC.setBounds(1475,0,300,570);
      fC.add(pCN);
      pCN.setBackground(new Color(73,159,228));
      fC.add(pNN,"North");
      pNN.setBackground(new Color(73,159,228));
      fC.add(pSS,"South");
      pSS.setBackground(new Color(73,159,228));
      pSS.add(Bcall);
      
      //revise imoticon
//      lE1 = new JLabel(new ImageIcon("Images/img1.gif"));
//      lE2 = new JLabel(new ImageIcon("Images/img2.gif"));
//      lE3 = new JLabel(new ImageIcon("Images/img3.png"));
//      lE4 = new JLabel(new ImageIcon("Images/img4.png"));
//      lE5 = new JLabel(new ImageIcon("Images/img5.gif"));
//      lE6 = new JLabel(new ImageIcon("Images/img6.gif"));
//      lE7 = new JLabel(new ImageIcon("Images/img9.png"));
//      lE8 = new JLabel(new ImageIcon("Images/img8.png"));
//      
//      pEmoticon.add(lE1);
//      pEmoticon.add(lE2);
//      pEmoticon.add(lE3);
//      pEmoticon.add(lE4);
//      pEmoticon.add(lE5);
//      pEmoticon.add(lE6);
//      pEmoticon.add(lE7);
//      pEmoticon.add(lE8);

      //硫붾 ��李� �뿉�뱶
      lm1 = new JLabel(new ImageIcon("Images/notificationOn@.png"));
      lm2 = new JLabel(new ImageIcon("Images/addFriend@.png"));
      lm3 = new JLabel(new ImageIcon("Images/wipeOut@.png"));
      lm4 = new JLabel(new ImageIcon("Images/leave@.png"));
      
      pMenu.add(lm1);
      pMenu.add(lm2);
      pMenu.add(lm3);
      pMenu.add(lm4);
            
      l1=new JLabel("Park Hyungsuck");
      l2=new JLabel("my name is Hyungsuck Park, Nice to Meet you");
      l3=new JLabel("Wang Hyun sik");
      l4=new JLabel("my name is Hyunsik Wang , Nice to Meet you");
      l5=new JLabel("No Wonwoo");
      l6=new JLabel("my name is Wonwoo No , Nice to Meet you");
      l7=new JLabel("Choi Junmook");
      l8=new JLabel("my name is Junmook Choi , Nice to Meet you");
      // ��꾨뵒�삤李� �뿉�뱶
      
      
      lPf1= new JLabel(new ImageIcon("Images/profile1.png"));
      lPf2= new JLabel(new ImageIcon("Images/profile2.png"));
      lPf3= new JLabel(new ImageIcon("Images/profile3.png"));
      lPf4= new JLabel(new ImageIcon("Images/profile4.png"));
      
      
      pVS.setBackground(new Color(73,159,228));
      pVS.add(Bmic);
      pVS.add(Bsound);
      pVS.add(Bexitcall);
      pVS.add(BVolume);
      
      
      
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   }//-- �� ��문占 �� �� �� �� ��
   
   class MyHandler implements MouseListener {

      @Override
      public void mouseClicked(MouseEvent e) {         
      }

        @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
         Object obj=e.getSource();
         
         if(obj==lbEmoticon) {
            lbEmoticon.setIcon(iemoticon_);
         }else if(obj==lbClip) {
            lbClip.setIcon(iclip_);
         }else if(obj==lbMenu) {
            lbMenu.setIcon(imenu_);
         }
   
      }

      @Override
      public void mouseExited(MouseEvent e) {
         Object obj=e.getSource();
         
         if(obj==lbEmoticon) {
            lbEmoticon.setIcon(iemoticon);
         }else if(obj==lbClip) {
            lbClip.setIcon(iclip);
         }else if(obj==lbMenu) {
            lbMenu.setIcon(imenu);
         }   
      }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
      
   }

}