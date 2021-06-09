package feedtheneed;

import static feedtheneed.FileHandling.searchUserid;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Location implements Serializable, ActionListener {
    JButton add;
    JButton view;
    JFrame f1;
    JLabel backpic;
    ImageIcon pic;
    JLabel backgroundpic;
    JButton back;
    Users user1;

    Location(JLabel backpic, Users u1) {
        backgroundpic = backpic;
        f1 = new JFrame();
        f1.setTitle("Location panel");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 700);
        
        if (searchUserid(u1.userId,"Donors")!=null){
    u1=searchUserid(u1.userId,"Donors");
    f1.setTitle("Showing Donors Profile");
    }
    if (searchUserid(u1.userId,"Receivers")!=null){
    u1=searchUserid(u1.userId,"Receivers");
    f1.setTitle("Showing Receivers Profile");
    }
        System.out.println("---->>>"+u1.UserName+"    "+u1.userId);
    user1=u1;
        
        back = new JButton("B A C K");
        back.setBounds(550, 450, 150, 50);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        back.setVisible(true);
        back.setBackground(Color.BLACK);
        back.setForeground(new Color(0, 0, 0));
        back.setFont(new Font("Party LET", Font.BOLD, 40));
        back.addActionListener(this);
        
        add = new JButton(" A D D   L O C A T I O N ");
        add.setBounds(400, 150, 500, 80);
        add.setBackground(new Color(0, 0, 0, 128));
        add.setOpaque(false);
        add.setForeground(Color.black);
        add.setFont(new Font("Palatino", Font.BOLD, 40));
        add.addActionListener(this);
        
        view= new JButton(" V I E W  L O C A T I O N ");
        view.setBounds(400, 300, 500, 80);
        view.setBackground(new Color(0, 0, 0, 128));
        view.setOpaque(false);
        view.setForeground(Color.black);
        view.setFont(new Font("Palatino", Font.BOLD, 40));
        view.addActionListener(this);
        
        
        backpic.add(back);
        backpic.add(add);
        backpic.add(view);

        f1.add(backpic);
        f1.setVisible(true);
        
       
        
    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            if (searchUserid(user1.userId, "Donors") != null) {
                f1.dispose();
                backgroundpic.removeAll();
                System.out.println("----"+user1.UserName+"    "+user1.userId);
                DonorPanel s1 = new DonorPanel(backgroundpic, user1);
            }
//            if (searchUserid(user1.userId, "Receivers") != null) {
//                f1.dispose();
//                backgroundpic.removeAll();
//                //System.out.println("----"+user1.UserName+"    "+user1.userId);
//                ReceiverPanel s1 = new ReceiverPanel(backgroundpic, user1);
//            }

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   


