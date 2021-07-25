import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//핸들러 계층
public class MusicEventHandler extends MouseAdapter {
	
	SetPageBeta main;
	MusicDAO musicDao;
	MyThread tr=null;
	String userId;

	public MusicEventHandler(SetPageBeta main) {
		this.main = main;
		musicDao = new MusicDAO();
		listMusic();
		
	}
	
	//음악 리스트
	public void listMusic() {
    	ArrayList<MusicVO> arr = musicDao.selecMusicAll(userId);
    	main.showTable(arr);
		
	}//--listMusic
	
	//쇼메시지
	private void showMsg(String string) {
		JOptionPane.showMessageDialog(main, string);
		
	}//--showMsg
	
	//음악 삭제
	private void deletMusic() {
		int row = main.musicTable.getSelectedRow();
		if(row<0) return;
		String songname = (String) main.musicTable.getValueAt(row, 1);
		
		if(songname==null || songname.trim().isEmpty()) {
			showMsg("삭제할 음악을 선택하세요");
			
		}
		musicDao.deleteMusic(songname);
		
	}
	
	//음악 이름으로 경로 가져오기
	private String selectLocal() {
		int row = main.musicTable.getSelectedRow();
		
		String songname = (String) main.musicTable.getValueAt(row, 1);
		
		if(songname==null || songname.trim().isEmpty()) {
			showMsg("재생할 음악을 선택하세요");
			
		}
		return musicDao.selectLocal(songname);
		
	}
	
	//음악 재생
	private void startMusic(String songlocal) {
		
		main.lbPlay.setIcon(new ImageIcon("images/musicimages/iconstop.png"));
		main.lbmainImage.setIcon(main.imainImageStart);
		main.bool=false;
		    
		    if(main.musicP==null) {
		    	main.musicP = new MusicPageBeta();
				try {
					main.musicP.bgm = new File(songlocal);
					System.out.println(main.musicP.bgm.length());
					main.musicP.start();
					
				
				} catch(Exception ex) {
					System.out.println("음악재생중 에러발생 "+ex);
					
				}
		    }
		
	}
	
	//음악 정지
	private void stopMusic() {
		
		main.lbPlay.setIcon(new ImageIcon("images/musicimages/iconplay.png"));
		main.lbmainImage.setIcon(main.imainImage);
		 
		main.bool=true;
			if(main.musicP!=null) {
				main.musicP.clip.stop();
				main.musicP=null;
				
			}
	}
	
	//이전 음악 재생
	private void beforeMusic() {
		
		int row = main.musicTable.getSelectedRow();//선택한 테이블 행의 값을 구하기
		String songname = (String) main.musicTable.getValueAt(row-1, 1);//선택한 테이블의 이전 값을 구하기

		stopMusic();//기존음악 정지시키기
		
		musicDao.selectLocal(songname);//이전 음악의 경로를 가져오기
		startMusic(""+musicDao.songlocal+"");//이전 음악 재생
		
		//상단 음악 제목 초기화
		stopNameTh();
		startNameTh(songname);
		
		//테이블의 커서 움직이기
		main.musicTable.changeSelection(row-1, i, false, false);

	}
	
	//이후 음악 재생
	private void afterMusic() {
		
		int row = main.musicTable.getSelectedRow();//선택한 테이블 행의 값을 구하기
		String songname = (String) main.musicTable.getValueAt(row+1, 1);//선택한 테이블의 다음 값을 구하기
		
		//마지막 음악이 아니라면 다음곡 재생
		stopMusic();//기존음악 정지시키기
		
		musicDao.selectLocal(songname);//다음 음악의 경로를 가져오기
		startMusic(""+musicDao.songlocal+"");//다음 음악 재생
		
		//상단 음악 제목 초기화
		stopNameTh();
		startNameTh(songname);
		
		main.musicTable.changeSelection(row+1, i, false, false);//테이블의 커서 움직이기
			
		

		
	}
	
	//노래제목 쓰레드 시작
	private void startNameTh(String songname) {
		if(main.isStop=true) {
			main.isStop=false;
			
		}
		
		if(tr==null) {
			main.songName = songname;
			tr=new MyThread();
			tr.start();
			
		}
		
	}
	
	//노래제목 쓰레드 중지 
	private void stopNameTh() {
		if(main.isStop=false) {
			main.isStop=true;
			
		}
		
		if(tr!=null) {
			main.x=0;
			tr.interrupt();
			tr=null;
		}
		
	}
	
	//핸들러
	@Override
	public void mousePressed(MouseEvent e) {
			Object obj= e.getSource();
			
			//음악재생
			if(obj==main.lbPlay && main.bool ==true) {
				String songname = selectLocal();
				startMusic(""+musicDao.songlocal+"");
				
				startNameTh(songname);

				
				
				    
			//음악중지		
			}else if(obj == main.lbPlay && main.bool == false) {
				main.songName="";
				stopMusic();
				
				stopNameTh();
				

			}
			
			//음악 추가
			if(obj==main.lbAdd) {
			
				fileChooser select = new fileChooser();
				select.main(null);
				
				String musicName = select.file.getName();//파일 이름얻기
				String musicLocal = select.file.getAbsoluteFile().toString();//파일 경로얻기	
				
				MusicVO musicVO = new MusicVO(musicName, musicLocal, userId);//파일 이름, 경로 유저이름 넣어주기
				
				musicDao.insertMusic(musicVO);
				showMsg("추가완료");
				listMusic();
				
				
				
			
			//음악 삭제
			}else if(obj==main.lbDelete) {
				deletMusic();
				showMsg("삭제완료");
				listMusic();
			}
			
			//이전 음악 재생
			if(obj==main.lbBefore) {
				int row = main.musicTable.getSelectedRow();//선택한 테이블 행의 값을 구하기
				if(row==0) {
					showMsg("처음 곡 입니다.");
					return;
				}
				beforeMusic();
				
			}
			
			//이후 음악 재생
			if(obj==main.lbAfter) {
				int row = main.musicTable.getSelectedRow();//선택한 테이블 행의 값을 구하기
				if(row==main.model.getRowCount()-1) {
					showMsg("마지막 곡 입니다.");
					return;
				}
				afterMusic();
				
			}
			
		}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==main.lbAdd) {
			main.lbAdd.setIcon(main.iaddmusic_);
			
		}else if(obj==main.lbDelete) {
			main.lbDelete.setIcon(main.ideletemusic_);
		}
		
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==main.lbAdd) {
			main.lbAdd.setIcon(main.iaddmusic);
			
		}else if(obj==main.lbDelete) {
			main.lbDelete.setIcon(main.ideletemusic);
		}
		
	}
	

			//--노래제목 쓰레드
			int i=1;
			class MyThread extends Thread {
				
				@Override
				public void run() {
					while(!main.isStop) {
						
						if(main.x>380) {
							main.x=-225;
						}
						if(main.x<=0) {
							i=1;
						}
						
						main.x+=i;
						main.repaint(); //repaint()를 호출하면 자동으로 paint 호출
						
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
									System.out.println("error: "+e.getMessage());
									break;
							}
							
					  
					}//while---
					
				}
			}

}
