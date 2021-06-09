package feedtheneed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import static feedtheneed.FileHandling.displayImage;
//import static feedtheneed.DonorRegisteration.scaleImage;


public class DonorPanel extends FileHandling implements ActionListener, Serializable {

    JFrame f1;

    JLabel backgroundpic;
    JLabel price;
    JLabel productName;
    JLabel sales;
    JLabel welcome;
    JLabel yourProducts;
    JScrollPane scrollPane;
    Users user1;

    JButton showProfile;
    JButton editProfile;
    JButton addProduct;
    JButton Location;
    JButton Requests;
    JButton Feedbacks;
    JButton SignOut;
    JButton del;
    JLabel yourpic;

    ArrayList<JPanel> subPanel = new ArrayList<JPanel>(50);

    DonorPanel(JLabel backpic, Users u1) {
       
        user1 = u1;
        u1=searchUserid(u1.userId,"Donors");
        System.out.println("---->****>>"+u1.UserName+"    "+u1.userId);
        backgroundpic = backpic;
        f1 = new JFrame();
        f1.setTitle("Donor Panel");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1368, 738);


//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- P A N E L S --------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(60, 60, 60, 120));
        p1.setOpaque(false);
        p1.setLayout(new GridLayout(4, 0));
        p1.setBounds(0, 0, 350, 738);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(0, 0, 0));
        //p2.setOpaque(false);
        //p2.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, Color.BLACK));
        p2.setLayout(new GridLayout(0, 2,25,25));
       
//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- B U T T O N S --------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        SignOut = new JButton(" SIGN  OUT");
        //SignOut.setOpaque(false);
        SignOut.setBackground(Color.black);
        //SignOut.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        SignOut.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        SignOut.setForeground(new Color(150,28,39));
        SignOut.setFont(new Font("Party LET", Font.BOLD, 20));
        SignOut.addActionListener(this);
        
        Location= new JButton(" L O C A T I O N ");
        Location.setBounds(650, 240, 500, 80);
        Location.setBackground(new Color(0, 0, 0, 128));
        Location.setOpaque(false);
        Location.setForeground(Color.black);
        Location.setFont(new Font("Palatino", Font.BOLD, 40));
        Location.addActionListener(this);
        
        Requests= new JButton(" VIEW CHARITY REQUESTS ");
        Requests.setBounds(600, 400, 600, 80);
        Requests.setBackground(new Color(0, 0, 0, 128));
        Requests.setOpaque(false);
        Requests.setForeground(Color.black);
        Requests.setFont(new Font("Palatino", Font.BOLD, 40));
        Requests.addActionListener(this);
        
        Feedbacks= new JButton(" VIEW FEEDBACKS ");
        Feedbacks.setBounds(650, 560, 500, 80);
        Feedbacks.setBackground(new Color(0, 0, 0, 128));
        Feedbacks.setOpaque(false);
        Feedbacks.setForeground(Color.black);
        Feedbacks.setFont(new Font("Palatino", Font.BOLD, 40));
        Feedbacks.addActionListener(this);
                

        addProduct = new JButton("<html> PROFILE OPTIONS <br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; BELOW ");
        //addProduct.setOpaque(false);
        addProduct.setForeground(new Color(150,28,39));
        addProduct.setBackground(Color.BLACK);
        addProduct.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        addProduct.setFont(new Font("Party LET", Font.BOLD, 30));
        addProduct.addActionListener(this);

        editProfile = new JButton("EDIT  PROFILE");
        //editProfile.setOpaque(false);
        editProfile.setForeground(new Color(150,28,39));
        editProfile.setBackground(Color.BLACK);
        editProfile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        editProfile.setFont(new Font("Party LET", Font.BOLD, 20));
        editProfile.addActionListener(this);

        showProfile = new JButton("SHOW  PROFILE");
        //showProfile.setOpaque(false);
        showProfile.setBackground(Color.BLACK);
        showProfile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        //showProfile.setBounds(750, 370, 150, 20);
        showProfile.setForeground(new Color(150,28,39));
        showProfile.setFont(new Font("Party LET", Font.BOLD, 20));
        showProfile.addActionListener(this);

//------------------------------------------------------------------------------------------------------------------------------------------------       
//------------------------------------------------------------- L A B E L S --------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        welcome = new JLabel(" D O N O R    P R O F I L E");
        welcome.setBounds(351, -50, 1000, 200);
        welcome.setBackground(new Color(0, 0, 0, 128));
        welcome.setOpaque(true);
        welcome.setForeground(Color.black);
        welcome.setFont(new Font("Palatino", Font.BOLD, 70));

//        yourProducts = new JLabel(" Y O U R   P R O D U C T S");
//        yourProducts.setBounds(500, 70, 700, 180);
//        //yourProducts.setBackground(new Color(0, 0, 0, 128));
//        yourProducts.setOpaque(false);
//        yourProducts.setForeground(new Color(40, 240, 10));
//        yourProducts.setFont(new Font("Palatino", Font.BOLD, 40));

//        yourpic = displayImage(u1.UserName,"Donors");
//        yourpic.setBounds(1120, 0, 250, 180);
//        yourpic.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
//------------------------------------------------------------------------------------------------------------------------------------------------       
//-------------------------------------------------------------     A D D   ----------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
        /*autoPanels(p2);

        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setBounds(250, 180, 1100, 520);
        //scrollPane.setBackground(new Color(60, 60, 255,120));
        scrollPane.setOpaque(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);*/

        p1.add(addProduct);
        p1.add(editProfile);
        p1.add(showProfile);
        p1.add(SignOut);
        

        //backpic.add(scrollPane);        
        backpic.add(welcome);
        backpic.add(p1);
        backpic.add(Location);
        backpic.add(Requests);
        backpic.add(Feedbacks);
        //backpic.add(yourProducts);

        f1.add(backpic);
        f1.setVisible(true);

    }

    DonorPanel(JLabel backgroundpic) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SignOut) {
            f1.dispose();
            backgroundpic.removeAll();
            DonorSignUp s1 = new DonorSignUp(backgroundpic);
        }
        if (e.getSource() == Location) {

            backgroundpic.removeAll();
            f1.dispose();
            Location a1 = new Location(backgroundpic, user1);

        }
        
        if (e.getSource() == Requests) {

            backgroundpic.removeAll();
            f1.dispose();
            CharityReq a1 = new CharityReq(backgroundpic, user1);

        }
        if (e.getSource() == Feedbacks) {

            backgroundpic.removeAll();
            f1.dispose();
            Rating a1 = new Rating(backgroundpic, user1);

        }
        
        if (e.getSource() == showProfile) {

            backgroundpic.removeAll();
            f1.dispose();
            ShowProfile a1 = new ShowProfile(backgroundpic, user1);

        }
        if (e.getSource() == editProfile) {

            backgroundpic.removeAll();
            f1.dispose();
            EditProfile a1 = new EditProfile(backgroundpic, user1);

        }
        

    }
    

    /*public void autoPanels(JPanel p2) {
        JPanel subPanel;
        JLabel name;
        JLabel price;
        JLabel quantity;

        ArrayList<Products> list = ReadFileProducts("Products");
        System.out.println(list.size());
        int i = 0;
        for (Products product : list) {
            System.out.println("---->33333>>"+product.user.UserName+"    "+product.user.userId);
            if (user1.userId==product.user.userId) {
                
                subPanel = new JPanel();
                subPanel.setPreferredSize(new Dimension(50, 400));
                subPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
                subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));
                subPanel.setBackground(Color.gray);
                subPanel.setOpaque(false);

                name = new JLabel("NAME : " + product.name);
                name.setForeground(new Color(40, 210, 40));
                name.setFont(new Font("Palatino", Font.BOLD, 20));
                name.setBounds(0, 0, 30, 40);

                price = new JLabel("PRICE : Rs." + product.price);
                price.setForeground(new Color(40, 210, 40));
                price.setFont(new Font("Palatino", Font.BOLD, 20));
                price.setBounds(0, 10, 30, 40);

                quantity = new JLabel("Quantity : " + product.Quantity);
                quantity.setForeground(new Color(40, 210, 40));
                quantity.setFont(new Font("Palatino", Font.BOLD, 20));

                 del = new JButton(" Delete");
                 //del.setBounds(50, 620, 200, 40);
                 del.setPreferredSize(new Dimension(50, 40));
                 del.setBackground(Color.BLACK);
                 del.setForeground(Color.red);
                 //del.setFont(new Font("Party LET", Font.BOLD, 30));
                del.addActionListener((ActionEvent e) -> {
                    deleteProduct(product,"Products");
                    
                   p2.removeAll();
                   p2.revalidate();
                   p2.repaint();
                   autoPanels(p2);
                });
  
                
                JLabel picture = new JLabel();
                picture = product.pic;
                picture.setPreferredSize(new Dimension(320, 200));
                subPanel.add(name);
                subPanel.add(picture);
                subPanel.add(price);
                subPanel.add(quantity);
                subPanel.add(del);
                p2.add(subPanel);
                i++;
               
            }
        }

    }*/

}
