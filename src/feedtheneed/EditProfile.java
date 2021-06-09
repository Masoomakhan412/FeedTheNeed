package feedtheneed;

import feedtheneed.FileHandling;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static feedtheneed.FileHandling.WriteToFile;
import static feedtheneed.FileHandling.searchUsername;
import static feedtheneed.DonorRegistration.scaleImage;

public class EditProfile extends FileHandling implements ActionListener, Serializable {

    ArrayList<JTextField> textfields;

    JLabel backgroundpic;
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
//    JLabel gender;
//    JLabel date;
//    JLabel day; //date
//    JLabel month; //date
//    JLabel year; //date
//    
//    JLabel address;
//    JLabel city;
    

    JTextField firstF;
    JTextField lastF;
    JTextField userF;
    JTextField emailF;
    JPasswordField passwordF;
    JPasswordField confirmpassF;
    JTextField cnicF;
    JTextField mobF;
//    JComboBox genderF;
//    JComboBox dayF; //date
//    JComboBox monthF; //date
//    JComboBox yearF; //date
//    JTextField dateF;
//    JComboBox cityF;
//    JTextField addressF;

    JButton back;
    JButton SignIn;
    JButton upload;

    Users user1;
    int copyId;
    ImageIcon ii;

//    String[] Lgender = {"male", "female", "others"};
//    String[] Lday = {"1", "2", "3", "4", "5", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
//    String[] Lmonth = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
//    String[] Lyear = {"2020", "2021"};
//    String[] Lcity = {"Karachi", "Lahore", "Sialkot", "Faisalabad", "Rawalpindi", "Peshawar", "Multan", "Gujranwala", "Islamabad", "Quetta", "Bahawalpur", "Sargodha", "Dera Ghazi Khan", "Muzaffargarh", "Abbottabad", "Swabi", "Dera Ismail Khan", "Muzaffarabad", "Mianwali", "Bannu", "Gwadar", "Hassan Abdal", "Umarkot", "Chitral", "Kotli", "Gilgit", "Jhelum", "Haripur",
//        "Attock City"};

    EditProfile(JLabel backpic, Users u1) {
        backgroundpic = backpic;
        f1 = new JFrame();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 770);
        
        if (searchUserid(u1.userId, "Donors") != null) {
            u1 = searchUserid(u1.userId, "Donors");
            f1.setTitle("Editing Donor's Profile");
        }
        if (searchUserid(u1.userId, "Receivers") != null) {
            u1 = searchUserid(u1.userId, "Receivers");
            f1.setTitle("Editing Receiver's Profile");
        }
        user1 = u1;
        backgroundpic = backpic;
        
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

        upload = new JButton("change your picture");
        upload.setBounds(900, 280, 250, 30);
        upload.setOpaque(false);
        upload.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
        upload.setVisible(true);
        upload.setBackground(Color.BLACK);
        upload.setForeground(Color.BLACK);
        upload.setFont(new Font("Party LET", Font.BOLD, 20));
        upload.addActionListener(this);
        //Sign in === edit profile 
        SignIn=new JButton("S I G N  I N");
        SignIn.setBounds(600, 560, 300, 60);
        SignIn.setBackground(Color.BLACK);
        SignIn.setForeground(new Color(150,28,39));
        SignIn.setFont(new Font("Party LET", Font.BOLD,40));
        SignIn.addActionListener(this);
//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- L A B E L S ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        firstName = new JLabel("FirstName : ");
        firstName.setBounds(40, 70, 300, 100);
        firstName.setForeground(Color.BLACK);
        firstName.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        lastName = new JLabel("LastName : ");
        lastName.setBounds(40, 120, 300, 100);
        lastName.setForeground(Color.BLACK);
        lastName.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        userName = new JLabel("UserName : ");
        userName.setBounds(40, 170, 300, 100);
        userName.setForeground(Color.BLACK);
        userName.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        email = new JLabel("Email : ");
        email.setBounds(40, 220, 300, 100);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        password = new JLabel("Password : ");
        password.setBounds(40, 270, 300, 100);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        confirmPassword = new JLabel("<html> Confirm<br/> Password : ");
        confirmPassword.setBounds(40, 350, 300, 100);
        confirmPassword.setForeground(Color.BLACK);
        confirmPassword.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
        
        cnic = new JLabel("CINC : ");
        cnic.setBounds(40, 410, 300, 100);
        cnic.setForeground(Color.BLACK);
        cnic.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        mobileNumber = new JLabel("MobileNO. : ");
        mobileNumber.setBounds(40, 460, 300, 100);
        mobileNumber.setForeground(Color.BLACK);
        mobileNumber.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
        
        yourpic = new JLabel("");
        yourpic.setBounds(900, 100, 250, 180);
        yourpic.setBackground(Color.black);
        yourpic.setOpaque(false);
        yourpic.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

//        gender = new JLabel("Gender : ");
//        gender.setBounds(40, 270, 300, 100);
//        gender.setForeground(Color.BLACK);
//        gender.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
//
//        date = new JLabel("Date of creation : ");
//        date.setBounds(700, 270, 300, 100);
//        date.setForeground(Color.BLACK);
//        date.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
//
//        day = new JLabel("Day :");
//        day.setBounds(970, 300, 60, 40);
//        day.setForeground(Color.GRAY);
//        day.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
//
//        month = new JLabel("Month :");
//        month.setBounds(1080, 300, 80, 40);
//        month.setForeground(Color.GRAY);
//        month.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
//
//        year = new JLabel("Year :");
//        year.setBounds(1220, 300, 60, 40);
//        year.setForeground(Color.GRAY);
//        year.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));

        

//        address = new JLabel("Address : ");
//        address.setBounds(40, 430, 300, 100);
//        address.setForeground(Color.BLACK);
//        address.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
//
//        city = new JLabel("City : ");
//        city.setBounds(690, 423, 300, 100);
//        city.setForeground(Color.GRAY);
//        city.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));

        

//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- F E I L D S ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        firstF = new JTextField(u1.FirstName);
        firstF.setName("FirstName");
        firstF.setBounds(230, 100, 400, 35);
        firstF.setOpaque(false);
        firstF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        firstF.setForeground(new Color(140, 28, 39));
        firstF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        lastF = new JTextField(u1.LastName);
        lastF.setName("LastName");
        lastF.setBounds(230, 150, 400, 35);
        lastF.setOpaque(false);
        lastF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        lastF.setForeground(new Color(140, 28, 39));
        lastF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        userF = new JTextField(u1.UserName);
        userF.setName("UserName");
        userF.setBounds(230, 200, 400, 35);
        userF.setOpaque(false);
        userF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        userF.setForeground(new Color(140, 28, 39));
        userF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        emailF = new JTextField(u1.Email);
        emailF.setName("Email");
        emailF.setBounds(230, 250, 400, 35);
        emailF.setOpaque(false);
        emailF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        emailF.setForeground(new Color(140, 28, 39));
        emailF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        passwordF = new JPasswordField(u1.Password);
        passwordF.setName("Password");
        passwordF.setBounds(230, 300, 350, 35);
        passwordF.setOpaque(false);
        passwordF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        passwordF.setForeground(new Color(140, 28, 39));
        passwordF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        confirmpassF = new JPasswordField(u1.Password);
        confirmpassF.setName("ConfirmPassword");
        confirmpassF.setBounds(230, 385, 350, 35);
        confirmpassF.setOpaque(false);
        confirmpassF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        confirmpassF.setForeground(new Color(140, 28, 39));
        confirmpassF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
        
        cnicF = new JTextField(u1.CNIC);
        cnicF.setName("CNIC");
        cnicF.setBounds(230, 440, 420, 35);
        cnicF.setOpaque(false);
        cnicF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        cnicF.setForeground(new Color(140, 28, 39));
        cnicF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        mobF = new JTextField(u1.MobileNumber);
        mobF.setName("Mobile Number");
        mobF.setBounds(230, 490, 400, 35);
        mobF.setOpaque(false);
        mobF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        mobF.setForeground(new Color(140, 28, 39));
        mobF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
        
//        genderF = new JComboBox(Lgender);
//        genderF.setBounds(230, 300, 400, 35);
//        genderF.setOpaque(false);
//        genderF.setBackground(Color.black);
//        genderF.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
//        genderF.setForeground(new Color(180, 28, 39));
//        genderF.setFont(new Font("Lucida Calligraphy", Font.TRUETYPE_FONT, 20));
//
//        dayF = new JComboBox(Lday);
//        dayF.setBounds(1028, 310, 50, 22);
//        dayF.setOpaque(false);
//        dayF.setBackground(Color.black);
//        dayF.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
//        dayF.setForeground(new Color(180, 28, 39));
//        dayF.setFont(new Font("Lucida Calligraphy", Font.TRUETYPE_FONT, 20));
//
//        monthF = new JComboBox(Lmonth);
//        monthF.setBounds(1158, 310, 60, 22);
//        monthF.setOpaque(false);
//        monthF.setBackground(Color.black);
//        monthF.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
//        monthF.setForeground(new Color(180, 28, 39));
//        monthF.setFont(new Font("Lucida Calligraphy", Font.TRUETYPE_FONT, 15));
//
//        yearF = new JComboBox(Lyear);
//        yearF.setBounds(1278, 310, 80, 22);
//        yearF.setOpaque(false);
//        yearF.setBackground(Color.black);
//        yearF.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
//        yearF.setForeground(new Color(180, 28, 39));
//        yearF.setFont(new Font("Lucida Calligraphy", Font.TRUETYPE_FONT, 15));
//
//        
//
//        cityF = new JComboBox(Lcity);
//        cityF.setBounds(750, 460, 200, 30);
//        cityF.setOpaque(false);
//        cityF.setBackground(Color.black);
//        cityF.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
//        cityF.setForeground(new Color(180, 28, 39));
//        cityF.setFont(new Font("Lucida Calligraphy", Font.TRUETYPE_FONT, 20));
//
//        addressF = new JTextField(u1.Address);
//        addressF.setName("Address");
//        addressF.setBounds(230, 460, 400, 35);
//        addressF.setOpaque(false);
//        addressF.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
//        addressF.setForeground(new Color(140, 28, 39));
//        addressF.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
        //------------------------------------------------------------------------------------------------------------------------------------------------       
//-------------------------------------------------------------     A D D   ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------

        textfields = new ArrayList<JTextField>();

        textfields.add(firstF);
        textfields.add(lastF);
        textfields.add(userF);
        textfields.add(emailF);
        textfields.add(passwordF);
        textfields.add(confirmpassF);
        textfields.add(cnicF);
        textfields.add(mobF);
        //textfields.add(addressF);

        backpic.add(firstName);
        backpic.add(lastName);
        backpic.add(userName);
        backpic.add(email);
        backpic.add(password);
        backpic.add(confirmPassword);
//        backpic.add(gender);
//        backpic.add(date);
        backpic.add(cnic);
        backpic.add(mobileNumber);
//        backpic.add(address);
//        backpic.add(day);
//        backpic.add(month);
//        backpic.add(year);
//        backpic.add(city);
        backpic.add(upload);
        backpic.add(yourpic);
        backpic.add(u1.pic);
        for (JTextField text : textfields) {
            backpic.add(text);
        }
//        backpic.add(genderF);
//        backpic.add(dayF);
//        backpic.add(monthF);
//        backpic.add(yearF);
//        backpic.add(cityF);

        backpic.add(back);
        backpic.add(SignIn);

        f1.add(backpic);
        f1.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            if (searchUserid(user1.userId, "Donors") != null) {
                f1.dispose();
                backgroundpic.removeAll();
                //System.out.println("----"+user1.UserName+"    "+user1.userId);
                DonorPanel s1 = new DonorPanel(backgroundpic, user1);
            }
//            if (searchUserid(user1.userId, "Receivers") != null) {
//                f1.dispose();
//                backgroundpic.removeAll();
//                //System.out.println("----"+user1.UserName+"    "+user1.userId);
//                ReceiverPanel s1 = new ReceiverPanel(backgroundpic, user1);
//            }

        }
        if (e.getSource() == upload) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                yourpic.setText(filename);
                try {
                    ImageIcon ii = new ImageIcon(scaleImage(250, 180, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
                    yourpic.setIcon(ii);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (NullPointerException ex) {
                System.out.println("NullPointerException caught");

            }

        }

        if (e.getSource() == SignIn) {
            if (searchUserid(user1.userId, "Donors") != null) {
                copyId = user1.userId;
                delete(user1, "Donors");

                if (validInput()) {

                    user1 = new Users(userF.getText(), firstF.getText(), lastF.getText(), emailF.getText(), mobF.getText(), passwordF.getText(), cnicF.getText(), yourpic);
                    user1.userId = copyId;
                    if (WriteToFile(user1, "Donors")) {
                        System.out.println("Successfully writen");
                        backgroundpic.removeAll();
                        f1.dispose();
                        //Users u1=new Users(userF.getText());
                        DonorPanel p1 = new DonorPanel(backgroundpic, user1);

                    } else if (!WriteToFile(user1, "Donors")) {
                        JOptionPane.showMessageDialog(f1, "Your data cannot written successfully, May be program error or file doesnot exist", "FILE Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
            if (searchUserid(user1.userId, "Receivers") != null) {
                System.out.println("butttt");
                copyId = user1.userId;
                delete(user1, "Receivers");
                if (validInput()) {
                    user1 = new Users(userF.getText(), firstF.getText(), lastF.getText(), emailF.getText(), mobF.getText(), passwordF.getText(), cnicF.getText(), yourpic);
                    user1.userId = copyId;
                    if (WriteToFile(user1, "Receivers")) {
                        System.out.println("Successfully writen");
                        backgroundpic.removeAll();
                        f1.dispose();
                        //Users u1=new Users(userF.getText());
                        //ReceiverPanel p1 = new ReceiverPanel(backgroundpic, user1);

                    } else if (!WriteToFile(user1, "Receivers")) {
                        JOptionPane.showMessageDialog(f1, "Your data cannot written successfully, May be program error or file doesnot exist", "FILE Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }

        }
    }

    public boolean validInput() {
        for (JTextField text : textfields) {
            if ("".equals(text.getText())) {
                JOptionPane.showMessageDialog(f1, text.getName() + " must not be empty", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        if ((searchUsername(userF.getText(), "Donors")) || (searchUsername(userF.getText(), "Receivers"))) {
            JOptionPane.showMessageDialog(f1, userF.getText() + " already exists, Please choose a unique Username", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!passwordF.getText().equals(confirmpassF.getText())) {
            JOptionPane.showMessageDialog(f1, " Your password and confirm password does not matches", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if ("".equals(yourpic.getText())) {
            JOptionPane.showMessageDialog(f1, " Please upload your Image", "Image Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }
}
