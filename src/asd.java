import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class asd {
	
    public static void main(String[] args){
        try{
            //���� ��ü ����
            File file = new File("C:\\Users\\ACE\\Desktop\\workspace\\BlueMingRealFinal\\chatFile\\a������������ ä��.txt");
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            int singleCh = 0;
            while((singleCh = filereader.read()) != -1){
                System.out.print((char)singleCh);
            }
            filereader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }


}
