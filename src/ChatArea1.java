import java.awt.*;

import javax.swing.*;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import javafx.beans.value.ObservableSetValue;

public class ChatArea1 extends JPanel {

    JTextPane tp=new JTextPane();
    JScrollPane sp = new JScrollPane(tp);

    Font font = new Font("", Font.BOLD,30);
    
    //revise chatarea1
    public ChatArea1() {
    	
    	
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setBackground(new Color(242,242,242));
        add(p, "Center");
        tp.setEditable(false); 
        sp.setBorder(null);
        sp.setPreferredSize(new Dimension(700,540));
        sp.getViewport().getView();
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        tp.setEnabled(false);	
        
        p.add(sp);

    }

}
