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

public class CharityReq implements Serializable, ActionListener {
    JFrame f1;
    JLabel backpic;
    ImageIcon pic;
    JLabel backgroundpic;
    JButton back;
    JLabel notify;
    Users user1;

    CharityReq(JLabel backpic, Users u1) {
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
        
        back = new JButton("Back");
        back.setBounds(-20, -5, 100, 40);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        back.setVisible(true);
        back.setBackground(Color.BLACK);
        back.setForeground(new Color(39, 28, 150));
        back.setFont(new Font("Party LET", Font.BOLD, 20));
        back.addActionListener(this);
        
        notify = new JLabel(" N O   N O T I F I C A T I O N S   Y E T ");
        notify.setBounds(351, -50, 1000, 200);
        notify.setBackground(new Color(0, 0, 0, 128));
        notify.setOpaque(false);
        notify.setForeground(Color.black);
        notify.setFont(new Font("Palatino", Font.BOLD, 50));
        
        backpic.add(back);
        backpic.add(notify);
        
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
