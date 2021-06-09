package feedtheneed;

import java.awt.Component;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FileHandling implements Icon, Serializable {
    
    public static boolean WriteToFile(Users stu, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        System.out.println(stu.UserName);
        
        list.add(stu);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(list);
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
/*public static boolean WriteToFileProducts(Products stu, String FileName) {
        ArrayList<Products> list = ReadFileProducts(FileName);
        list.add(stu);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(list);
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }*/



    static ArrayList<Users> ReadFileUsers(String FileName) {

        ArrayList<Users> list = new ArrayList<Users>();
        boolean EndOfFile = false;
        System.out.println("hina  "+ list.toString());

        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(FileName));

            list = (ArrayList<Users>) oi.readObject();
            oi.close();

        } catch (IOException e) {
            EndOfFile = true;
        } catch (ClassCastException c) {
            c.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return list;
    }
    /*static ArrayList<Products> ReadFileProducts(String FileName) {

        ArrayList<Products> list = new ArrayList<Products>();
        boolean EndOfFile = false;

        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(FileName));

            list = (ArrayList<Products>) oi.readObject();
            oi.close();

        } catch (IOException e) {
            EndOfFile = true;
        } catch (ClassCastException c) {
            c.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return list;
    }*/
    
    

    static void display(String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users users : list) {
            System.out.println(users.getUserName());
        }
    }
    static JLabel displayImage(String Username,String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users users : list) {
            if(users.UserName.equals(Username)){
            
            
            return users.pic;}
        }
        return null;
    }

    static boolean search(String name, String pass, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users Users : list) {
            if (Users.getUserName().equals(name)) {

                if (Users.getPassword().equals(pass)) {

                    return true;
                }
            }

        }
        return false;
    }

    static boolean searchUsername(String name, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users Users : list) {
            if (Users.getUserName().equals(name)) {

                return true;
            }
        }

        return false;
    }

    static JLabel searchImage(String name, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users Users : list) {
            if (Users.getUserName().equals(name)) {
                return Users.getPic();

            }
        }

        return null;
    }
////
    static void delete(Users s, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).userId==s.userId) {
                list.remove(i);
                break;
            }
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(list);
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Users searchUser(String name, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users users : list) {
            if (users.getUserName().equals(name)) {

                return users;
            }
        }

        return null;
    }
    static Users searchUserid(int id, String FileName) {
        ArrayList<Users> list = ReadFileUsers(FileName);
        for (Users users : list) {
            if (users.userId==id) {

                return users;
            }
        }

        return null;
    }
    /*static void deleteProduct(Products product, String FileName) {
        ArrayList<Products> list = ReadFileProducts(FileName);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).productId==product.productId) {
                list.remove(i);
                break;
            }
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(list);
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void buyProduct(Products product, String FileName) {
        ArrayList<Products> list = ReadFileProducts(FileName);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).productId==product.productId) {
                list.get(i).Quantity=Integer.toString(Integer.parseInt(product.Quantity)-1);
//                    if(list.get(i).Quantity=="0"){
//                    deleteProduct(list.get(i),"Products");
//                    }
                break;
            }
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(list);
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    static void updateList(Products product, String q, String FileName) {
//        ArrayList<Products> list = ReadFileProducts(FileName);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getUserName().equalsIgnoreCase(u.getUserName())) {
//
//                break;
//            }
//        }
//        try {
//            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
//            output.writeObject(list);
//            output.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }*/
//    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIconWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIconHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
