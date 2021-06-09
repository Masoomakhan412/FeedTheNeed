package feedtheneed;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import static feedtheneed.addingProduct.scaleImage;

public class ShowProfile extends FileHandling implements Serializable, ActionListener {
    JFrame f1;
    JLabel firstName;
    JLabel lastName;
    JLabel userName;
    JLabel email;
    JLabel password;
    JLabel confirmPassword;
    JLabel cnic;
    JLabel mobileNumber;
    JLabel yourpic;
    JLabel backgroundpic;
    JButton back;
    Users user1;
//    JLabel gender;
//    JLabel date;
//    JLabel day; //date
//    JLabel month; //date
//    JLabel year; //date
//    
//    JLabel address;
//    JLabel city;
    
    
    ShowProfile(JLabel backpic,Users u1){
    backgroundpic=backpic;
    f1 = new JFrame();
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setSize(1368, 738);    
    
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
    
        firstName = new JLabel("FirstName : " +u1.FirstName);
        firstName.setBounds(40, 70, 300, 100);
        firstName.setForeground(Color.BLACK);
        firstName.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        lastName = new JLabel("LastName : "+u1.LastName);
        lastName.setBounds(40, 120, 300, 100);
        lastName.setForeground(Color.BLACK);
        lastName.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        userName = new JLabel("UserName : " +u1.UserName);
        userName.setBounds(40, 170, 300, 100);
        userName.setForeground(Color.BLACK);
        userName.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        email = new JLabel("Email : " +u1.Email);
        email.setBounds(40, 220, 300, 100);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        password = new JLabel("Password : " +u1.Password);
        password.setBounds(40, 270, 300, 100);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
        
        cnic = new JLabel("CINC : " +u1.CNIC);
        cnic.setBounds(40, 320, 300, 100);
        cnic.setForeground(Color.BLACK);
        cnic.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        mobileNumber = new JLabel("MobileNO. : " +u1.MobileNumber);
        mobileNumber.setBounds(40,370, 300, 100);
        mobileNumber.setForeground(Color.BLACK);
        mobileNumber.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
    
        yourpic = new JLabel("");
        yourpic.setBounds(900, 100, 250, 180);
        yourpic.setBackground(Color.black);
        yourpic.setOpaque(false);
        yourpic.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

//    address = new JLabel("Address : "+u1.Address+", ");
//    address.setBounds(40, 430, 500, 100);
//    address.setForeground(Color.BLACK);
//    address.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
//    gender = new JLabel("Gender : "+u1.Gender);
//    gender.setBounds(40, 270, 300, 100);
//    gender.setForeground(Color.BLACK);
//    gender.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

    //city = new JLabel("City :");
    //city.setBounds(690, 423, 300, 100);
    //city.setForeground(Color.GRAY);
    //city.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
    
    
    
    
   
    
    backpic.add(firstName);
    backpic.add(lastName);
    backpic.add(userName);
    backpic.add(email);
    backpic.add(password);
    backpic.add(cnic);
    backpic.add(mobileNumber);
//    backpic.add(gender);
//    backpic.add(address);
    //backpic.add(city);
    backpic.add(yourpic);
    backpic.add(u1.pic);
    backpic.add(back);
    
    f1.add(backpic);
    f1.setVisible(true);
    }
     @Override
     public void actionPerformed(ActionEvent e) 
     {
     
     if(e.getSource()==back){
         if(searchUserid(user1.userId,"Donors")!=null){
     f1.dispose();
     backgroundpic.removeAll();
      //System.out.println("----"+user1.UserName+"    "+user1.userId);
     DonorPanel s1=new DonorPanel(backgroundpic,user1);
     }
//     if(searchUserid(user1.userId,"Receivers")!=null){
//     f1.dispose();
//     backgroundpic.removeAll();
//      //System.out.println("----"+user1.UserName+"    "+user1.userId);
//     ReceiverPanel s1=new ReceiverPanel(backgroundpic,user1);
//     }
     
     
     }
     
     }
    
}
