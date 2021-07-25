import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Vector;


public class BobServer extends Thread {

   private ServerSocket server;
   private int port=9999;
   Vector<BluChatHandler> userV=new Vector<>(5,3);
   
   public BobServer() {
      try {
         server=new ServerSocket(port);
         System.out.println("ä�� ������ ���۵ƽ��ϴ�.");
         System.out.println("##["+port+"]��Ʈ���� �����");
         
      } catch (IOException e) {
         System.out.println("ä�� ���� ������ ����"+e+"##");
      }
   }//----------
   public void run() {
      while(true) {
         try {
            Socket sock=server.accept();
            System.out.println("##["+sock.getInetAddress()+"]����  �����߽��ϴ�##");
            BluChatHandler chat=new BluChatHandler(sock,userV);
            chat.start();
            
         } catch (IOException e) {
            System.out.println("bobchatServer run()����"+e);
         }
      }
   }
   
   
   public static void main(String[] args) {
      new BobServer().start();
      
   }

}