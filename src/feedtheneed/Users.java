package feedtheneed;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Users extends FileHandling implements Serializable {
    String UserName;
    String FirstName;
    String LastName;
    String Email;
    String MobileNumber;
    String Address;
    String Gender;
    String Password;
    String CNIC;
    String Date;
    int userId;
    JLabel pic;

    public Users(String UserName, String FirstName, String LastName, String Email, String MobileNumber, String Password, String CNIC, JLabel pic) {
        System.out.println("abc");
        this.UserName = UserName;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.MobileNumber = MobileNumber;
        
        this.Password = Password;
        this.CNIC = CNIC;
       
        this.pic=pic;
        
        
    }
//    public Users(String UserName){
//    this.UserName = UserName;
//    
//    }

    Users(String text, String text0, String text1, String text2, String text3, String string, String toString, String text4, String text5, String string0, JLabel yourpic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Users(String text, String text0, String text1, String text2, String text3, String text4, String text5, JLabel yourpic) {
        /*this.UserName = UserName;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.MobileNumber = MobileNumber;
        this.Address = Address;
        this.Gender = Gender;
        this.Password = Password;
        this.CNIC = CNIC;
        this.Date = Date;
        this.pic=pic;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public JLabel getPic() {
        return pic;
    }

//    public ImageIcon getPic() {
//        return pic;
//    }
//
//    public void setPic(ImageIcon pic) {
//        this.pic = pic;
//    }
//
    public void setPic(JLabel pic) {
        this.pic = pic;
    }

//
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
