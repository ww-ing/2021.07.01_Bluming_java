import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class fileChooser {
	File file;
	Scanner fileIn;
	int response;
	JFileChooser chooser = new JFileChooser("");
	SetPageBeta setPage = new SetPageBeta();
	LoginChat lc;
	
	MusicEventHandler handlerP = new MusicEventHandler(setPage);
	
	public fileChooser() {
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		response= chooser.showOpenDialog(null);
		
		//파일 경로 및 이름 읽어오기
		if(response == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			
		}
		
	}

	public static void main(String[] args){
	}
	
}
