import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class fileChooser2 {
    File file;
    Scanner fileIn;
    int response;
    JFileChooser chooser = new JFileChooser("");
    SetPageBeta setPage = new SetPageBeta();
    FileNameExtensionFilter filter;

    public fileChooser2() {
    	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    	chooser.setCurrentDirectory(new File("C:\\Users\\ACE\\Desktop\\���ٱ� - ���纻\\�������̸�Ƽ��\\01_��������1\\100x100px\\"));
        filter = new FileNameExtensionFilter("�̹��� ����", "gif","png","jpg");
        chooser.setFileFilter(filter);
    	response= chooser.showOpenDialog(null);
        
        //���� ��� �� �̸� �о����
        if(response == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            
        }

    }

    public static void main(String[] args){
    }

}