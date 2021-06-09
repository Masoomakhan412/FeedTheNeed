package feedtheneed;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Font;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

//import javafx.scene.control.ProgressBar;
//import javax.swing.BorderFactory;
//import javafx.scene.text.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class InitialScreen implements ActionListener,Serializable{
 

    private JFrame f1;
    
    private JLabel backpic1;
    private JLabel intro;
    private JLabel names;
    
    private ImageIcon pic1;
    private JButton screen2;
    
    JProgressBar pb1;
       
    
public InitialScreen(){
    f1= new JFrame();
    f1.setTitle("INTRODUCTORY SCREEN");
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setSize(1366,700);
    
    
    pic1=new ImageIcon("C:\\Users\\Masooma Khan\\Documents\\FeedTheNeed\\src\\feedtheneed\\Images\\Donation.jpg");
    backpic1 =new JLabel(pic1);
    backpic1.setBounds(0, 0, 1366, 700);
    backpic1.setForeground(Color.WHITE);
    /*pic=new ImageIcon("C:\\Users\\Masooma Khan\\Documents\\NetBeansProjects\\SwingProject\\src\\swingproject\\imgs\\Donation11.jpg");
    backpic =new JLabel(pic);
    backpic.setBounds(0, 0, 1366, 700);
    backpic.setForeground(Color.WHITE);*/
    
    intro =new JLabel("<html>FEED THE<br/>  &nbsp;&nbsp;  NEED<br/> ");
    intro.setFont(new Font("Mshtakan",Font.BOLD, 80));
    intro.setBounds(40, -70, 700, 450);
    //intro.setForeground(Color.red);
    intro.setForeground(new Color(150,23,39,100));
    
    /*pb1=new JProgressBar();
    pb1.setBounds(400, 600, 500,40);
    pb1.setBorderPainted(false);
    pb1.setBackground(Color.DARK_GRAY);
    pb1.setForeground(new Color(150,28,39));
    pb1.setString("L O A D I N G");
    pb1.setStringPainted(true);
    pb1.setValue(0);*/
    
    screen2=new JButton(" S T A R T  N O W ");
    screen2.setOpaque(false);
    screen2.setBounds(550, 600, 300, 60);
    screen2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.yellow));
    screen2.setVisible(false);
    screen2.setBackground(new Color(115,113,100));
    screen2.setForeground(new Color(150,28,39));
    screen2.setFont(new Font("Mshtakan",Font.ITALIC, 30));
    screen2.addActionListener(this);
    
    //backpic.add(pb1);
    //backpic.add(names);
    backpic1.add(intro);
    backpic1.add(screen2);
    
    
    
    
        
    f1.add(backpic1);
    f1.setVisible(true);
    
    
   /* for(int k=0;k<=100;k++){
   
    try {
        Thread.sleep(500);
        pb1.setValue(k=k+100);
       
    } catch (InterruptedException ex) {
        System.out.println("Exception in progressbar");
    }
    
    
 
    
    
    }*/
    screen2.setVisible(true);
}
public void actionPerformed(ActionEvent e){
if(e.getSource()==screen2){
    //backpic.remove(pb1);
    //backpic.remove(names);
    backpic1.remove(intro);
    backpic1.remove(screen2);
    //f1.setVisible(false);
      f1.dispose();
DonorReceiver b1=new DonorReceiver(backpic1);

}


}



}


