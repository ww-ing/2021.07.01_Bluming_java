import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;


public class BluChatHandler extends Thread{
   Socket sock;
   Vector<BluChatHandler> userV;
   
   ObjectInputStream in;
   ObjectOutputStream out;
   
   boolean isStop = false;

   public BluChatHandler(Socket socket, Vector<BluChatHandler> vector) {
      this.sock = socket;
      this.userV = vector;
      
      userV.add(this);
      
      try {
         in = new ObjectInputStream(sock.getInputStream());
         out = new ObjectOutputStream(sock.getOutputStream());
         
      }catch(IOException e) {
         System.out.println("Handler - ������ ����: "+e);
      }
      
   }
    
	public void run() {

		try {

			Object obj = in.readObject();
			System.out.println("##" + obj + "���� ������##");
			broadcast("##[" + obj + "]���� �����Ͽ����ϴ�.##" + "\r\n");
			broadcast("\n");
			while (!isStop) {
				Object cMsg = in.readObject();
				System.out.println(cMsg);
				String temp = cMsg.toString();
				System.out.println(temp);
				if (temp.split("/")[0].equals("images")) {
					broadcast_Emo((ImageIcon)cMsg);
				} else {
					broadcast(cMsg.toString());
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();

		}
	}
   
   
   

//���α׷� �ݱ�
   public void close() 
   throws IOException
   {
      isStop = true;
      if(in!=null) in.close();
      if(out!=null) out.close();
      if(sock!=null) sock.close();
   }      
   
   //��� �������� �޽��� ����
   private synchronized void broadcast(String msg) {
      for(BluChatHandler userChat:userV) {
         try {
        	userChat.out.writeObject(msg);
            userChat.out.flush();
            
         }catch(IOException e) {
            System.out.println("sendMessageAll()����: "+e);
            userV.remove(userChat);
            break;
         }
      }
   }

   private synchronized void broadcast_Emo(ImageIcon icon) {
	      for(BluChatHandler userChat:userV) {
	         try {
	        	userChat.out.writeObject(icon);
	            userChat.out.flush();
	            
	         }catch(IOException e) {
	            System.out.println("sendMessageAll()����: "+e);
	            userV.remove(userChat);
	            break;
	         }
	      }
	   }
  
}//handler
