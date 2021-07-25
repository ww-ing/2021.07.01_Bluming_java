import java.io.File;
import javax.sound.sampled.*;

public class MusicPageBeta extends Thread {
	 File bgm;
     AudioInputStream stream;
     AudioFormat format;
     
     DataLine.Info info;
     Clip clip;
     
     MusicDAO musicDao;
     
        
    	public MusicPageBeta() {
    	
    	}
        
        public void run() {
         
        try {
               stream = AudioSystem.getAudioInputStream(bgm);
               format = stream.getFormat();
               info = new DataLine.Info(Clip.class, format);
               clip = (Clip)AudioSystem.getLine(info);
               clip.open(stream);
               
               clip.start();
               
               
               
               
        } catch (Exception e) {
               System.out.println("err : " + e);
               }
        }
        
 }
