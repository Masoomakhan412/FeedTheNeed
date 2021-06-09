package feedtheneed;

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

public class DonorReceiver implements ActionListener,Serializable {

    JButton receiver;
    JButton donor;
    JFrame f1;
    JLabel backpic;
    ImageIcon pic;
    JLabel backgroundpic;
    JButton back;
    JLabel option;
    DonorReceiver(JLabel backpic) {
        pic=new ImageIcon("C:\\Users\\Masooma Khan\\Documents\\FeedTheNeed\\src\\feedtheneed\\Images\\Donation11.jpg");
    backpic =new JLabel(pic);
    backpic.setBounds(0, 0, 1366, 700);
    backpic.setForeground(Color.WHITE);
        backgroundpic = backpic;
    
        f1 = new JFrame();
        f1.setTitle("donor-receiver Panel");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 700);
        
        option = new JLabel(" You Want To Sign-In As ? ");
        option.setBounds(270, 70, 900, 180);
        //yourProducts.setBackground(new Color(0, 0, 0, 128));
        option.setOpaque(false);
        option.setForeground(Color.BLACK);
        option.setFont(new Font("Palatino", Font.BOLD, 70));

        receiver = new JButton(" R E C E I V E R ");
        receiver.setBounds(350, 350, 300, 80);
        receiver.setBackground(Color.BLACK);
        receiver.setForeground(new Color(150, 28, 39));
        receiver.setFont(new Font("Party LET", Font.BOLD, 30));
        receiver.addActionListener(this);

        donor = new JButton(" D O N O R");
        donor.setBounds(750, 350, 300, 80);
        donor.setBackground(Color.black);
        //donor.setForeground(Color.WHITE);        
        donor.setForeground(new Color(150, 28, 39));
        donor.setFont(new Font("Party LET", Font.BOLD, 30));
        donor.addActionListener(this);
        
        
        back = new JButton("B A C K");
        back.setBounds(650, 550, 150, 50);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        back.setVisible(true);
        back.setBackground(Color.BLACK);
        back.setForeground(new Color(0, 0, 0));
        back.setFont(new Font("Party LET", Font.BOLD, 40));
        back.addActionListener(this);
        
        
        backpic.add(back);
        backpic.add(option);
        backpic.add(donor);
        backpic.add(receiver);

        f1.add(backpic);
        f1.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == receiver) {
            backgroundpic.remove(donor);
            backgroundpic.remove(receiver);
            backgroundpic.remove(back);
            backgroundpic.remove(option);
            // f1.setVisible(false);
            
             f1.dispose();
            //ReceiverSignUp b1 = new ReceiverSignUp(backgroundpic);
           
        }
        if (e.getSource() == donor) {
            backgroundpic.remove(donor);
            backgroundpic.remove(receiver);
            backgroundpic.remove(back);
            backgroundpic.remove(option);
            //f1.setVisible(false);
            
              f1.dispose();
            DonorSignUp s1 = new DonorSignUp(backgroundpic);
            
        }
        if (e.getSource() == back) {
            
            f1.dispose();
             //f1.setVisible(false);
            InitialScreen s1 = new InitialScreen();
            
        }
        
    }
}
