import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class SetPageBeta extends JPanel {
	
	//�г�
	JPanel pN, pNC, pC, pCC, pCCS, pCS, pCSC, pCSS;
	
	//���� �̹���
	JLabel lbmainImage = new JLabel(new ImageIcon("images/musicimages/_musicimage.png"));
	Icon imainImage = new ImageIcon("images/musicimages/_musicimage.png");
	Icon imainImageStart = new ImageIcon("images/musicimages/_musicimagestart.gif");
	
	//���� �߰� ����
	JLabel lbAdd = new JLabel(new ImageIcon("images/musicimages/iconsmallclip+.png"));
	Icon iaddmusic = new ImageIcon("images/musicimages/iconsmallclip+.png");
	Icon iaddmusic_ = new ImageIcon("images/musicimages/iconsmallclip-.png");
	
	JLabel lbDelete = new JLabel(new ImageIcon("images/musicimages/iconsmallcancle+.png"));
	Icon ideletemusic = new ImageIcon("images/musicimages/iconsmallcancle+.png");
	Icon ideletemusic_ = new ImageIcon("images/musicimages/iconsmallcancle-.png");
	
	//Plat and Stop Label
	JLabel lbPlay = new JLabel(new ImageIcon("images/musicimages/iconplay.png"));
	JLabel lbStop = new JLabel(new ImageIcon("images/musicimages/iconstop.png"));
	
	//�� �� ���� ���
	JLabel lbBefore = new JLabel(new ImageIcon("images/musicimages/iconplaybefore.png"));
	JLabel lbAfter = new JLabel(new ImageIcon("images/musicimages/iconplayafter.png"));
	
	//�ڵ鷯
	MusicEventHandler handler;
	
	//��� ���� ����
	int x=0,y=38;
	String songName = "";
	
     //Music class
     MusicPageBeta musicP = new MusicPageBeta();
     
     //boolean type
     boolean bool = true;//������ ��Ʈ��
     boolean isStop=false;//��� ��������
     
     //Table
     JTable musicTable = new JTable();
     DefaultTableModel model;//DataModel
     JScrollPane jScrollPane = new JScrollPane(musicTable);//scroll
     String colHeader[] = {"�뷡��ȣ", "�뷡����"};
     Object[][]data= {{null,null}};
     
     //������
     MusicDAO musicDao;
     
	public SetPageBeta() {
		setLayout(new BorderLayout());
		JPanel p = new JPanel(new BorderLayout());
		add(p, "Center");
		
		//�̹��� �г�
		pN = new JPanel(new BorderLayout());
		pN.setBackground(new Color(48, 110, 159));
		pN.setBorder(new EmptyBorder(20, 0, 0, 0));
		pN.setPreferredSize(new Dimension(ABORT, 400));
		pN.add(lbmainImage);
		p.add(pN, "North");
		
		//�� �� ������� ���� ǥ�� �г�
		pNC = new JPanel();
		pNC.setBackground(new Color(73,159,228));
		pNC.setPreferredSize(new Dimension(ABORT, 20));
		pN.add(pNC, "North");
		
		//�߾� ���� �� �� �г�
		pC = new JPanel(new GridLayout(0, 1));
		pC.setBackground(new Color(48, 110, 159));
		pC.setBorder(new EmptyBorder(10,10,10,10));
		pC.setPreferredSize(new Dimension(ABORT, ABORT));
		p.add(pC, "Center");
		
		//���̺�
		pCC = new JPanel(new BorderLayout());
		pCC.setBackground(new Color(48, 110, 159));
		pCC.setPreferredSize(new Dimension(70, ABORT));
		pC.add(pCC, "Center");
		
		//���� �߰� ���� ��ư �г�
		pCCS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pCCS.setBackground(new Color(73,159,228));
		pCC.add(pCCS,"South");
		
		//�Ʒ� ��ư �г�
		pCS = new JPanel(new BorderLayout());
		p.add(pCS, "South");
				
		//��� ��ư �г�
		pCSC = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pCSC.setBackground(new Color(48, 110, 159));
		pCSC.setBorder(new EmptyBorder(0, 0, 0, 0));
		pCSC.setPreferredSize(new Dimension(ABORT, 70));
		pCS.add(pCSC, "Center");
		
		//���� ����
		pCSS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pCSS.setBackground(new Color(48, 110, 159));
		pCS.add(pCSS,"South");
		
		
		//�߰��ϱ�
		pCC.add(jScrollPane);//���̺�
		
		pCCS.add(lbAdd);//���� �߰�
		pCCS.add(lbDelete);//���� ����
		
		pCSC.add(lbBefore);//�� ���� ���
		pCSC.add(lbPlay);//���� ���
		pCSC.add(lbAfter);//�� ���� ���		
		
		//�ڵ鷯
		handler = new MusicEventHandler(this);
		lbPlay.addMouseListener(handler);
		lbAdd.addMouseListener(handler);
		lbDelete.addMouseListener(handler);
		lbBefore.addMouseListener(handler);
		lbAfter.addMouseListener(handler);
		
		//������
		musicP = null;
		
		
	}//--class
	
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("", Font.BOLD,18));
			g.setColor(Color.white);
			g.drawString(songName, x, y);
		}
		
	   /**DB���� ������ �����͸� JTable�� ����Ͽ� �����ִ� �޼ҵ�*/
		public void showTable(ArrayList<MusicVO> arr) {
			model = (DefaultTableModel)musicTable.getModel();
			Object[][] data = new Object[arr.size()][2];
			
			int i=0;
			int k=1;
			for(MusicVO m:arr) {
				
				data[i][0] = k;
				data[i][1] = m.getLocal();
				i++;
				k++;
				
			}
			model.setDataVector(data, colHeader);
			
		}
		
}