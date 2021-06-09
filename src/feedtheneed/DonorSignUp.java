package feedtheneed;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static feedtheneed.FileHandling.*;

public class DonorSignUp implements ActionListener,MouseListener,Serializable {

    JFrame f1;
    JButton back;
    JButton eye;
    JButton SignIn;
    JButton createAcc;
    JLabel PassEye;
    JLabel backgroundpic;
    JLabel UserName;
    JLabel Password;
    JLabel DonorSignup;
    
    JPasswordField passF; 
    JTextField userF;
    
    
    DonorSignUp(JLabel backpic) {
        backgroundpic = backpic;
        f1 = new JFrame();
        f1.setTitle("Donor Signup");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 700);
        
        DonorSignup = new JLabel("D O N O R - S I G N U P ");
        DonorSignup.setBounds(300, -50, 1000, 180);
        //yourProducts.setBackground(new Color(0, 0, 0, 128));
        DonorSignup.setOpaque(false);
        DonorSignup.setForeground(Color.BLACK);
        DonorSignup.setFont(new Font("Palatino", Font.BOLD, 70));
//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- B U T T O N S --------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        back = new JButton("Back");
        back.setBounds(-20, -5, 100, 40);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        back.setVisible(true);
        back.setBackground(Color.BLACK);
        back.setForeground(new Color(39, 28, 150));
        back.setFont(new Font("Party LET", Font.BOLD, 20));
        back.addActionListener(this);
        
        SignIn=new JButton("S I G N  I N");
        SignIn.setBounds(480, 480, 300, 60);
        //SignIn.setOpaque(false);
        //SignIn.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        //SignIn.setVisible(true);
        SignIn.setBackground(Color.BLACK);
        SignIn.setForeground(new Color(150,28,39));
        SignIn.setFont(new Font("Party LET", Font.BOLD,40));
        SignIn.addActionListener(this);
        
        eye=new JButton("Show password");
        eye.setOpaque(false);
        eye.setBackground(new Color(115,113,100));
        eye.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        eye.setBounds(750, 370, 150, 20);
        eye.setForeground(Color.BLACK);
        eye.setFont(new Font("Party LET", Font.BOLD, 15));
        eye.addMouseListener((MouseListener) this);
        
        
        createAcc=new JButton("Create new account");
        createAcc.setOpaque(false);
        createAcc.setBackground(new Color(115,113,100));
        createAcc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        createAcc.setBounds(750, 230, 150, 20);
        createAcc.setForeground(Color.BLACK);
        createAcc.setFont(new Font("Party LET", Font.BOLD, 15));
        createAcc.addActionListener(this);
//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- L A B E L S ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        UserName=new JLabel("Username : ");
        UserName.setBounds(200, 150, 300, 100);
        UserName.setForeground(Color.BLACK);
        UserName.setFont(new Font("Party LET", Font.BOLD, 35));
        
        Password=new JLabel("Password : ");
        Password.setBounds(200, 300, 300, 100);
        Password.setForeground(Color.black);
        Password.setFont(new Font("Lucida Blackletter", Font.BOLD, 35));
        
        PassEye=new JLabel("");
        PassEye.setBackground(new Color(115,113,100));
        
        PassEye.setBounds(400, 370, 150, 20);
        PassEye.setForeground(Color.BLACK);
        PassEye.setFont(new Font("Party LET", Font.BOLD, 15));
        
        
//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- F E I L D S ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        
        userF=new JTextField();
        userF.setBounds(400, 175, 500, 50);
        //userF.setBackground(Color.BLACK);
        userF.setOpaque(false);
        userF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        userF.setForeground(new Color(120,28,39));
        userF.setFont(new Font("Party LET", Font.TRUETYPE_FONT, 30));
        
        passF= new JPasswordField();
        passF.setBounds(400, 320, 500, 50);
        passF.setOpaque(false);
        passF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        //passF.setBackground(Color.BLACK);
        passF.setForeground(new Color(120,28,39));
        passF.setFont(new Font("Party LET", Font.TRUETYPE_FONT, 30));
        
        
        
//------------------------------------------------------------------------------------------------------------------------------------------------       
//-------------------------------------------------------------     A D D   ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        backpic.add(PassEye);
        backpic.add(userF);
        backpic.add(passF);
        backpic.add(Password);
        backpic.add(UserName);
        backpic.add(createAcc);
        backpic.add(back);
        backpic.add(eye);
        backpic.add(SignIn);
        backpic.add(DonorSignup);
        
        
        f1.add(backpic);
        f1.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            f1.setVisible(false);
            backgroundpic.remove(PassEye);
            backgroundpic.remove(userF);
            backgroundpic.remove(passF);
            backgroundpic.remove(Password);
            backgroundpic.remove(UserName);
            backgroundpic.remove(back);
            backgroundpic.remove(SignIn);
            backgroundpic.remove(eye);
            backgroundpic.remove(createAcc);
            backgroundpic.remove(DonorSignup);
            DonorReceiver b1 = new DonorReceiver(backgroundpic);
        }
        if(e.getSource()==SignIn)
        {
          
            
           if(search(userF.getText(),passF.getText(),"Donors")){
           f1.setVisible(false);
           

              backgroundpic.removeAll();
              Users u1=searchUser(userF.getText(),"Donors");
            DonorPanel p1=new DonorPanel(backgroundpic,u1);
           }
           else{
           
            JOptionPane.showMessageDialog(f1,
    "Your username and password doesnot matche.",
    "Input Error",
    JOptionPane.ERROR_MESSAGE);
            
           }
           
           
        
        }
       if(e.getSource()==createAcc){
       f1.setVisible(false);
//            backgroundpic.remove(PassEye);
//            backgroundpic.remove(userF);
//            backgroundpic.remove(passF);
//            backgroundpic.remove(Password);
//            backgroundpic.remove(UserName);
//            backgroundpic.remove(back);
//            backgroundpic.remove(SignIn);
//            backgroundpic.remove(eye);
            backgroundpic.removeAll();
            DonorRegistration s1=new DonorRegistration(backgroundpic);
       
       }
       
       
    }
    @Override
   public void mousePressed(MouseEvent m) {
       if(m.getSource()==eye){
       PassEye.setText(passF.getText());
       }
    }

    @Override
    public void mouseReleased(MouseEvent m) {
       if(m.getSource()==eye){
       PassEye.setText("");
       }
    }

    @Override
    public void mouseClicked(MouseEvent me) {}
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
    
}
