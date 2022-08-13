
package projectoop;
//import the localvariables
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PROJECTOOP {

   
        public static JButton B;
 //adding frame no 1
 public static void main(String[] args) throws SQLException, ClassNotFoundException {
 JFrame F=new JFrame ("Login Here ");
 F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 F.setVisible(true);
 F.setBounds(0,0,500,400);
 F.setLayout(null);

 //creating panel in frame
 JPanel panel = new JPanel();
 panel.setSize(500,400);
 panel.setBounds(0, 0, 500,400);
 panel.setLayout(null);
 F.add(panel);

 //adding image into the button
 JButton B1=new JButton(new ImageIcon("D:\\kisa\\Capture.png"));
 B1.setBounds(0, 0, 500, 400);
 B1.setLayout(null);
 F.add(B1);

 //Adding username
 JLabel L = new JLabel("UserName:");
 L.setBounds(130,100,90,30);
 L.setFont(new Font("Arial",Font.BOLD,14));
 B1.add(L);

 // adding username textfield
 JTextField tf=new JTextField();
 tf.setBounds(210,100,110,25);
 B1.add(tf);
 //login label
 JLabel KL = new JLabel(" PLEASE LOGIN TO CONTINUE ");
 KL.setBounds(100, 55, 270, 30);
 KL.setFont(new Font("Arial",Font.BOLD,17));
 KL.setForeground(Color.black);
 B1.add(KL);

 //affing password label
 JLabel L1 = new JLabel("Password:");
 L1.setBounds(130, 140, 90, 30);
 L1.setFont(new Font("Arial",Font.BOLD,14));
 B1.add(L1);

 //password field
 JPasswordField pf2=new JPasswordField();
 pf2.setBounds(210,140,110,25);
 B1.add(pf2);

 //adding login button
 B=new JButton("LOGIN");
 B.setBounds(130 , 180, 90, 25);
 B.setBackground(Color.black);
 B.setForeground(Color.white);
 B.setFont(new Font("Arial",Font.BOLD,15));
 B1.add(B);

 //Adding rest button
 JButton resetButton=new JButton("RESET");
 resetButton.setBackground(Color.black);
 resetButton.setForeground(Color.white);
 resetButton .setBounds(240,180,90,25);
 resetButton .setFont(new Font("Arial",Font.BOLD,15));

 //event handling on reset
 resetButton.addActionListener(new ActionListener() {
 @Override
 public void actionPerformed(ActionEvent e) {
 tf.setText("");
 pf2.setText("");
 }
 });
 B1.add(resetButton);
 //Adding checkbox of show password
 JButton showPassword=new JButton("Show Password");
 showPassword.setBackground(Color.black);
 showPassword.setForeground(Color.white);
 showPassword.setBounds(160,225,150,20);
 showPassword.setFont(new Font("Arial",Font.BOLD,12));
 B1.add(showPassword);
 
 
 

 //getting connectiong from my database to store the username and password from the each user
 B.addActionListener(new ActionListener(){

 @Override
 public void actionPerformed(ActionEvent e) {
 F.setVisible(false);
 Connection co;
 PreparedStatement p;

 try {
 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 co=DriverManager.getConnection("jdbc:ucanaccess://D:\\kisa\\login.accdb");
 p=co.prepareStatement("insert into logs(UserName,Password) values(?,?)");
 p.setString(1, tf.getText());
 p.setString(2, pf2.getText());
 p.executeUpdate();


 } catch (ClassNotFoundException ex) {
 Logger.getLogger(PROJECTOOP.class.getName()).log(Level.SEVERE, null, ex);
 } catch (SQLException ex) {
 Logger.getLogger(PROJECTOOP.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 


 });
 resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                         
                                    try
                                {
                                    Connection co=null;
                                PreparedStatement pt=null;

                                    
                                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
                                    co=DriverManager.getConnection("jdbc:ucanaccess://D:\\kisa\\login.accdb");

                                String sql="delete from logs";
                                  pt=co.prepareStatement(sql);

                                int a=pt.executeUpdate();
                                if(a>0){
                                     JOptionPane.showMessageDialog(null,"Data deleted successfully");
                                }

                                }
                                catch(Exception ep){
                                    System.out.println(ep);
                                }
                                }
                      
    });
 
              
                
//Adding second frame
 JFrame F1=new JFrame ("WELCOME TO THE BAKERY ");

 F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 F1.setVisible(true);
 F1.setBounds(0,0,750,550);
 F1.setLayout(null);
 //1st layout
 F1.setLayout(new BorderLayout());

 //LABEL adding into the panel and then panel adding into frame
 JLabel labe = new JLabel("welcome to the bakery");
 labe.setForeground(Color.gray);
 JPanel lp = new JPanel ();
 lp.setBackground(Color.black);
 lp.add(labe);
 F1.add(lp);

 //LABEL adding into the button and then button adding into frame
 JLabel labe2 = new JLabel("Continue");
 labe2.setForeground(Color.gray);
 JButton lp1 = new JButton ();
 lp1.setBackground(Color.black);
 lp1.add(labe2);
 F1.add(lp1);

 JButton b5 = new JButton ();
 b5.setBackground(Color.black);
 //2adding grid layout inside the boarder layout center
 b5.setLayout(new GridLayout(3,3 , 5, 5));

 //sides of border layout
 F1.add(b5, BorderLayout.CENTER);
 F1.add(lp, BorderLayout.NORTH);
 F1.add(lp1, BorderLayout.SOUTH);

 //ICONS
 Icon icon = new ImageIcon("D:\\kisa\\1.jpeg");
 JButton iteam1 = new JButton(icon);
 Icon icon1 = new ImageIcon("D:\\kisa\\2.jpeg");
 JButton iteam2 = new JButton(icon1);
 Icon icon2 = new ImageIcon("D:\\kisa\\3.jpeg");
 JButton iteam3 = new JButton(icon2);
 Icon icon3 = new ImageIcon("D:\\kisa\\4.jpeg");
 JButton iteam4 = new JButton(icon3);
 Icon icon4 = new ImageIcon("D:\\kisa\\5.jpeg");
 JButton iteam5 = new JButton(icon4);
 Icon icon5 = new ImageIcon("D:\\kisa\\6.jpeg");
 JButton iteam6 = new JButton(icon5);
 Icon icon6 = new ImageIcon("D:\\kisa\\7.jpeg");
 JButton iteam7= new JButton(icon6);
 Icon icon7 = new ImageIcon("D:\\kisa\\8.jpeg");
 JButton iteam8 = new JButton(icon7);
 Icon icon8 = new ImageIcon("D:\\kisa\\9.jpeg");
 JButton iteam9 = new JButton(icon8);

 
 iteam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                         



 JDialog d1 = new JDialog();
 d1.setBackground(Color.black);
 d1.setTitle("Bakery Order System");
 d1.setSize(400,150);
 d1.setVisible(true);
 
JLabel labeld = new JLabel(" you choose donuts ");
 labeld.setForeground(Color.black);

 labeld.setBounds(60, 25, 300, 20);
 d1.add(labeld);

                        }
 });
 //adding icons into the button
 b5.add(iteam1);
 b5.add(iteam2);
 b5.add(iteam3);
 b5.add(iteam4);
 b5.add(iteam5);
 b5.add(iteam6);
 b5.add(iteam7);
 b5.add(iteam8);
 b5.add(iteam9);
 b5.add(iteam1);

 //Event handling to go to the next page
 lp1.addActionListener(new ActionListener(){

 @Override
 public void actionPerformed(ActionEvent e) {
 F1.setVisible(false);
 }

 });

 JFrame frame3 = new JFrame("PLACE YOUR Order ");
 frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame3.setSize(550,750);
 frame3.setVisible(true);
 frame3.setBackground(Color.black);
 frame3.setLayout(null);



 
 //creating labels of the items
 JLabel la = new JLabel();
 JLabel lb = new JLabel();
 JLabel lc = new JLabel();
 JLabel ld = new JLabel();
 JLabel le = new JLabel();
 JLabel lf = new JLabel();
 JLabel lg = new JLabel();
 JLabel kk = new JLabel();
 JLabel mm = new JLabel();
 JLabel gg = new JLabel();

 //checkbox to select the items
 JCheckBox m1 = new JCheckBox();
 JCheckBox m2 = new JCheckBox();
 JCheckBox m3 = new JCheckBox();
 JCheckBox m4 = new JCheckBox();
 JCheckBox m5 = new JCheckBox();
 JCheckBox m6 = new JCheckBox();
 JCheckBox m7 = new JCheckBox();
 JCheckBox m8 = new JCheckBox();
 JCheckBox m9 = new JCheckBox();
 JCheckBox m10 = new JCheckBox();
 JCheckBox m11 = new JCheckBox();
 JCheckBox m12 = new JCheckBox();
 JCheckBox m13 = new JCheckBox();
 JCheckBox m14 = new JCheckBox();
 JCheckBox m15 = new JCheckBox();
 JCheckBox m16 = new JCheckBox();
 JCheckBox m17 = new JCheckBox();
 JCheckBox m18 = new JCheckBox();



 // now we are creating the menu list
 la.setText("Choose Your Menu Here");
 la.setHorizontalTextPosition(JLabel.CENTER);
 la.setVerticalTextPosition(JLabel.BOTTOM);
 la.setForeground(Color.white);
 la.setFont(new Font("Dialog", Font.PLAIN, 25));
 la.setBounds(0, 10, 550, 30);


 JPanel panel5 = new JPanel();
 panel5.setBackground(Color.gray);
 panel5.setBounds(0, 10, 600, 50);
 frame3.add(panel5);

 lb.setText("milk");
 lb.setForeground(Color.gray);
 lb.setFont(new Font("Arial", Font.BOLD, 18));
 lb.setFocusable(false);


 m1.setText("red velvet Cookies ----------------------- RS 750.");
 m1.setForeground(Color.white);
 m1.setFont(new Font("Arial", Font.BOLD, 15));
 m1.setFocusable(false);
 m1.setBounds(10, 150 , 420, 20);
 m1.setBackground(Color.pink);

 m2.setText("Macaron cookies -------------------------- RS 899.");
 m2.setForeground(Color.white);
 m2.setFont(new Font("Arial", Font.BOLD, 15));
 m2.setFocusable(false);
 m2.setBounds(10, 170, 420, 20);
 m2.setBackground(Color.pink);

 m3.setText("Sugar cookies ---------------------------- RS 870.");
 m3.setForeground(Color.white);
 m3.setFont(new Font("Arial", Font.BOLD, 15));
 m3.setFocusable(false);
 m3.setBounds(10, 190, 420, 20);
 m3.setBackground(Color.pink);

 lb.setText("Cookies");
 lb.setForeground(Color.gray);
 lb.setFont(new Font("Arial", Font.BOLD, 18));
 lb.setFocusable(false);
 lb.setBounds(10, 130, 100, 20);

 lc.setText("PASTRY");
 lc.setForeground(Color.gray);
 lc.setFont(new Font("Arial", Font.BOLD, 18));
 lc.setFocusable(false);
 lc.setBounds(10, 210, 100, 20);

 m4.setText("Strawberry Pastry ------------------------ RS 399.");
 m4.setForeground(Color.white);
 m4.setFont(new Font("Arial", Font.BOLD, 15));
 m4.setFocusable(false);
 m4.setBounds(10, 230 , 420, 20);
 m4.setBackground(Color.pink);

 m5.setText("Chocolate Pastry ------------------------- RS 399.");
 m5.setForeground(Color.white);
 m5.setFont(new Font("Arial", Font.BOLD, 15));
 m5.setFocusable(false);
 m5.setBounds(10, 250 , 420, 20);
 m5.setBackground(Color.pink);

 ld.setText("BREAD");
 ld.setForeground(Color.gray);
 ld.setFont(new Font("Arial", Font.BOLD, 18));
 ld.setFocusable(false);
 ld.setBounds(10, 270, 100, 20);

 m6.setText("Milky Bread ------------------------------ RS 100.");
 m6.setForeground(Color.white);
 m6.setFont(new Font("Arial", Font.BOLD, 15));
 m6.setFocusable(false);
 m6.setBounds(10, 290, 420 , 20);
 m6.setBackground(Color.pink);

 m7.setText("Simple Bread ------------------------------ RS 89.");
 m7.setForeground(Color.white);
 m7.setFont(new Font("Arial", Font.BOLD, 15));
 m7.setFocusable(false);
 m7.setBounds(10, 310, 420, 20);
 m7.setBackground(Color.pink);

 le.setText("CAKE");
 le.setForeground(Color.gray);
 le.setFont(new Font("Arial", Font.BOLD, 18));
 le.setFocusable(false);
 le.setBounds(10,330 , 100, 20);
 m8.setText("Pineapple Cake --------------------------- RS 490.");
 m8.setForeground(Color.white);
 m8.setFont(new Font("Arial", Font.BOLD, 15));
 m8.setFocusable(false);
 m8.setBounds(10, 350, 420, 20);
 m8.setBackground(Color.pink);

 m9.setText("Cheese Cake ------------------------------RS 999.");
 m9.setForeground(Color.white);
 m9.setFont(new Font("Arial", Font.BOLD, 15));
 m9.setFocusable(false);
 m9.setBounds(10, 370, 420, 20);
 m9.setBackground(Color.pink);


 m10.setText("Red Velvet Cake -------------------------RS 999.");
 m10.setForeground(Color.white);
 m10.setFont(new Font("Arial", Font.BOLD, 15));
 m10.setFocusable(false);
 m10.setBounds(10, 390, 420, 20);
 m10.setBackground(Color.pink);

 lf.setText("SANDWICH");
 lf.setForeground(Color.gray);
 lf.setFont(new Font("Arial", Font.BOLD, 18));
 lf.setFocusable(false);
 lf.setBounds(10,410 , 100, 20);

 m11.setText("Club Sandwich ----------------------------RS 499.");
 m11.setForeground(Color.white);
 m11.setFont(new Font("Arial", Font.BOLD, 15));
 m11.setFocusable(false);
 m11.setBounds(10, 430, 420, 20);
 m11.setBackground(Color.pink);


 m12.setText("Chicken Cheese Sandwich ------------------ RS 999.");
 m12.setForeground(Color.white);
 m12.setFont(new Font("Arial", Font.BOLD, 15));
 m12.setFocusable(false);
 m12.setBounds(10, 450, 420, 20);
 m12.setBackground(Color.pink);

 lg.setText("SWEETS");
 lg.setForeground(Color.gray);
 lg.setFont(new Font("Arial", Font.BOLD, 18));
 lg.setFocusable(false);
 lg.setBounds(10,470 , 100, 20);

 m13.setText("Gulab Jamun ----------------------------- RS 499./ per kg");
 m13.setForeground(Color.white);
 m13.setFont(new Font("Arial", Font.BOLD, 15));
 m13.setFocusable(false);
 m13.setBounds(10, 490, 420, 20);
 m13.setBackground(Color.pink);


 m14.setText("Gajar ka halwa ------------------------- RS 999./ per kg");
 m14.setForeground(Color.white);
 m14.setFont(new Font("Arial", Font.BOLD, 15));
 m14.setFocusable(false);
 m14.setBounds(10, 510, 420, 20);
 m14.setBackground(Color.pink);
 kk.setText("MILK");
 kk.setForeground(Color.gray);
 kk.setFont(new Font("Arial", Font.BOLD, 18));
 kk.setFocusable(false);
 kk.setBounds(10,530 , 100, 20);

 m15.setText("MILK ------------------------------ RS 70");
 m15.setForeground(Color.white);
 m15.setFont(new Font("Arial", Font.BOLD, 15));
 m15.setFocusable(false);
 m15.setBounds(10, 550, 420, 20);
 m15.setBackground(Color.pink);

 mm.setText("PATTIES");
 mm.setForeground(Color.gray);
 mm.setFont(new Font("Arial", Font.BOLD, 18));
 mm.setFocusable(false);
 mm.setBounds(10,570 , 100, 20);

 m16.setText("BEEF PATTIES ------------------------------ RS 70");
 m16.setForeground(Color.white);
 m16.setFont(new Font("Arial", Font.BOLD, 15));
 m16.setFocusable(false);
 m16.setBounds(10, 590, 420, 20);
 m16.setBackground(Color.pink);

 m17.setText("BURGER PATTIES ------------------------------ RS 70");
 m17.setForeground(Color.white);
 m17.setFont(new Font("Arial", Font.BOLD, 15));
 m17.setFocusable(false);
 m17.setBounds(10, 610, 420, 20);
 m17.setBackground(Color.pink);



 JButton button5 = new JButton("SUBMIT");
 button5.setBounds(140, 650 , 80, 20);
 button5.setFont(new Font("Comic Sans", Font.BOLD, 15));
 button5.setBackground(Color.gray);
 button5.setForeground(Color.white);
 button5.setBorder(BorderFactory.createEtchedBorder());


 panel5.add(la);
 frame3.add(lb);
 frame3.add(lc);
 frame3.add(ld);
 frame3.add(le);
 frame3.add(lf);
 frame3.add(lg);
 frame3.add(kk);
 frame3.add(mm);
 frame3.add(gg);


 frame3.add(m1);
 frame3.add(m2);
 frame3.add(m3);
 frame3.add(m4);
 frame3.add(m5);
 frame3.add(m6);
 frame3.add(m7);
 frame3.add(m8);
 frame3.add(m9);
 frame3.add(m10);
 frame3.add(m11);
 frame3.add(m12);
 frame3.add(m13);
 frame3.add(m14);
 frame3.add(m15);
 frame3.add(m17);
 frame3.add(m16);
 frame3.add(m18);


 frame3.add(button5);


 button5.addActionListener(new ActionListener() {
 @Override
 public void actionPerformed(ActionEvent e) {



 JDialog d = new JDialog();
 d.setBackground(Color.black);
 d.setTitle("Bakery Order System");
 d.setSize(400,150);
 d.setVisible(true);



 JLabel labelll = new JLabel(" THANK YOU FOR ODERING FROM US ");
 labelll.setForeground(Color.black);
 JLabel label2 = new JLabel(" PLEASE WAIT 15 MINUTES ");
 labelll.setBounds(20, 30, 300, 20);
 label2.setForeground(Color.gray);
 label2.setBounds(60, 80, 300, 20);


 JButton button1 = new JButton("OK");
 button1.setBounds(302, 46, 60, 30);
 button1.setFont(new Font("Comic Sans", Font.BOLD, 18));
 button1.setBackground(Color.gray);
 button1.setForeground(Color.black);
 d.add(button1);
 d.add(labelll);
 d.add(label2);
 button1.setForeground(Color.white);
 button1.setBorder(BorderFactory.createEtchedBorder());
 button1.addActionListener(new ActionListener() {
 @Override
 public void actionPerformed(ActionEvent e) {


 }
 });




 }
});
      
    }
    
}
