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

public class Rating implements Serializable, ActionListener {
   
    JFrame f1;
    ImageIcon pic;
    ImageIcon pic2;
    JLabel backgroundpic;
    JLabel backpic;
    JButton back;
    Users user1;
    JLabel feedbackpic;


    Rating(JLabel backpic, Users u1) {
        pic=new ImageIcon("C:\\Users\\Masooma Khan\\Documents\\FeedTheNeed\\src\\feedtheneed\\Images\\Donation11.jpg");
    backpic =new JLabel(pic);
    backpic.setBounds(0, 0, 1366, 700);
    backpic.setForeground(Color.WHITE);
    backgroundpic = backpic;
    pic2=new ImageIcon("C:\\Users\\Masooma Khan\\Documents\\FeedTheNeed\\src\\feedtheneed\\Images\\collage.jpg");
    feedbackpic =new JLabel(pic2);
    feedbackpic.setBounds(0, 0, 1366, 700);
    feedbackpic.setForeground(Color.WHITE);
        
        
        f1 = new JFrame();
        f1.setTitle("Feedback panel");
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
        
        feedbackpic.add(back);
        
        f1.add(feedbackpic);
        f1.setVisible(true);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            f1.dispose();
                System.out.println("abc");
                backgroundpic.removeAll();
                System.out.println("----"+user1.UserName+"    "+user1.userId);
                DonorPanel s1 = new DonorPanel(backgroundpic, user1);

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

