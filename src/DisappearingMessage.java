import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class DisappearingMessage implements ActionListener
{
    private final int ONE_SECOND = 1000;

    private Timer timer;
    private JFrame frame;
    private JLabel msgLabel;
    SubChatPageBeta22 sub=new SubChatPageBeta22();
    
public DisappearingMessage (String str, int seconds) 
{
frame = new JFrame ("Test Message");
msgLabel = new JLabel (str, SwingConstants.CENTER);
msgLabel.setPreferredSize(new Dimension(200, 60));
frame.setUndecorated(true);

timer = new Timer (this.ONE_SECOND * seconds, this);
// only need to fire up once to make the message box disappear
timer.setRepeats(false);
}

/**
 * Start the timer
 */
public void start ()
{
// make the message box appear and start the timer
frame.getContentPane().add(msgLabel, BorderLayout.CENTER);
frame.pack();
frame.setLocationRelativeTo(sub); 
frame.setVisible(true);

timer.start();
}

/**
 * Handling the event fired by the timer
 */
public void actionPerformed (ActionEvent event)
{
// stop the timer and kill the message box
timer.stop();
frame.dispose();
}
public void st() {
DisappearingMessage dm = new DisappearingMessage("�˸��� Ȱ��ȭ �ƽ��ϴ�", 3);

}
public static void main (String[] args)
{
DisappearingMessage dm = new DisappearingMessage("�˸��� ��Ȱ��ȭ �ƽ��ϴ�", 3);
dm.start();

}
}
