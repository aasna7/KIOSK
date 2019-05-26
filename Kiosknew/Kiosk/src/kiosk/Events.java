/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.*;
import java.awt.*;

/**
 *
 * @author might
 */
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;  
import java.awt.event.*;  
import net.proteanit.sql.DbUtils;


public class Events extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps = null;
static String event_no;
String event_id;

    public Events() {
        initComponents();
        
        show_event();
        Community_images();
        showTableData();
        
    }
//Code for event panel
    
    
     public void Community_images() {
              Connection con = null;
        Statement st = null;
        Integer EventNum = null;
        String rowCount = null;
        String rowCounti=null;
        Integer j = 0;
        Integer x = 0;
        int d= 0;
        int g= 0;
        int f = 0;
        //JLabel b1 = new JLabel();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select COUNT(*) FROM COMMUNITY_EVENTS");
//              ResultSet rs2 = st.executeQuery("select COUNT(*) FROM EVENTS_IMAGE");
            
                while (rs1.next()) {
                    rowCount = rs1.getString(1);
//                    rowCounti = rs2.getString(2);
                }
                 //ResultSet rsi = stmt.executeQuery("SELECT EVENT_NO,EVENT_IMAGE FROM EVENTS_IMAGE WHERE EVENT_NO='1' ");
            
               ResultSet rs = st.executeQuery("select * from COMMUNITY_EVENTS");
//                ResultSet rsi = st.executeQuery("select * from EVENTS_IMAGE");
//               
            while (rs.next()) {
                 JLabel b1 = new JLabel();//Creates new label b1;
                 JLabel b2= new JLabel();//Creates new label b2;
                 JLabel imgi=new JLabel();
                 JButton b3 = new JButton();//Creates new Button;
                   byte[] imgData = null;
               
                for(int i = 0; i < Integer.parseInt(rowCount); i++){ 
//creates a loop for the no. of row in Events Database.
 
    
        
                                
                imgi.setBounds(70,60+f,400,j+140);
            
                    Blob img  = rs.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                  BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                  //imgi.setBounds(100,100,400,500);
                  imgi.setIcon(new ImageIcon(image.getScaledInstance(172,208,Image.SCALE_SMOOTH)));
                                
                   b1.setFont(new Font("Serif", Font.BOLD, 22));
                   b2.setFont(new Font("Serif", Font.BOLD, 22));
                   b3.setFont(new Font("Serif", Font.BOLD, 16));
                          
                    //b1.setText(rs.getString(i+1));
                    //b1.setLocation(100+j, 10+x);
                    b1.setBounds(400,40+f,400,j+100);
                    b2.setBounds(400,60+f, 400, j+120);
                
                    
                    b3.setText("See Details");
                    b3.setBounds(400, 180+d, 120, 50);
                    x = x + 100;
                    j=j+50;
                    d=d+90;
                    g=g+9;
                    f=f+70;
                    community_event.setAutoscrolls(rootPaneCheckingEnabled);
                    community_event.add(b1);
                    community_event.add(b2);
                    community_event.add(b3);
                    community_event.add(imgi); 
                }
               b1.setText("Event Name: "+rs.getString(2) + "  ");
               b2.setText("Location: "+rs.getString(3));
               
                
                
            }
    } catch (Exception e) {
            e.printStackTrace();
  
        }
          
          }

     public void showTableData(){
       try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery("SELECT EVENT_ID,EVENT_NAME,LOCATION,TIME,EVENT_DATE from EVENT");
        System.out.print("running");
        event_table.setModel(DbUtils.resultSetToTableModel(rs));
      }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex);
        
    }
   }
    
    public void show_event()
{
    
    try{
        
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='1' ");
            if (rs.next())
             {
                 String event_id= rs.getString("EVENT_ID");
                 ResultSet rs1=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs1.next()){
                 
                 byte[] imgData = null;
                 Blob img  = rs1.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
   BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
   event1.setBounds(100,100,400,500);
   event1.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
   event_name1.setText(rs1.getString("EVENT_NAME"));
                //event1.setIcon();
                
                 }
            }
            
            ResultSet rs2 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='2' ");
            if (rs2.next())
             {
                 String event_id= rs2.getString("EVENT_ID");
                 ResultSet rs12=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs12.next()){
                 
                 byte[] imgData = null;
                 Blob img  = rs12.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event2.setBounds(100,100,400,500);
                 event2.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name2.setText(rs12.getString("EVENT_NAME"));
                //event1.setIcon();
                
                 }
            }
            
           ResultSet rs3 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='3' ");
            if (rs3.next())
             {
                 String event_id= rs3.getString("EVENT_ID");
                 ResultSet rs13=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs13.next()){
                 
                 byte[] imgData = null;
                 Blob img  = rs13.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event3.setBounds(100,100,400,500);
                 event3.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name3.setText(rs13.getString("EVENT_NAME"));
                //event1.setIcon();
                
                 }
            }
            
            ResultSet rs4 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='4' ");
            if (rs4.next())
             {
                 String event_id= rs4.getString("EVENT_ID");
                 ResultSet rs14=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs14.next()){
                 
                 byte[] imgData = null;
                 Blob img  = rs14.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event4.setBounds(100,100,400,500);
                 event4.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name4.setText(rs14.getString("EVENT_NAME"));
                //event1.setIcon();
                
                 }
            }
            ResultSet rs5 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='5' ");
            if (rs5.next())
             {
                 String event_id= rs5.getString("EVENT_ID");
                 ResultSet rs15=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs15.next()){
                 
                 byte[] imgData = null;
                 Blob img  = rs15.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event5.setBounds(100,100,400,500);
                 event5.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name5.setText(rs15.getString("EVENT_NAME"));
                //event1.setIcon();
                
             
            }}
            
            
            }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Home = new javax.swing.JPanel();
        top = new javax.swing.JLabel();
        event2 = new javax.swing.JLabel();
        event3 = new javax.swing.JLabel();
        event4 = new javax.swing.JLabel();
        event5 = new javax.swing.JLabel();
        event1 = new javax.swing.JLabel();
        event_name1 = new javax.swing.JLabel();
        event_name2 = new javax.swing.JLabel();
        event_name3 = new javax.swing.JLabel();
        event_name4 = new javax.swing.JLabel();
        event_name5 = new javax.swing.JLabel();
        event1details = new javax.swing.JButton();
        event2details = new javax.swing.JButton();
        event3details = new javax.swing.JButton();
        event4details = new javax.swing.JButton();
        event5details = new javax.swing.JButton();
        Event2 = new javax.swing.JPanel();
        Ev_MaxTab2 = new javax.swing.JTabbedPane();
        College_Event2 = new javax.swing.JPanel();
        college_event1 = new javax.swing.JScrollPane();
        college_events1 = new javax.swing.JPanel();
        college_title2 = new javax.swing.JLabel();
        imgeve = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        event_name = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        location_name = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        time_name = new javax.swing.JLabel();
        date_name = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        desc_name = new javax.swing.JTextPane();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        event_table = new javax.swing.JTable();
        Community_Event2 = new javax.swing.JPanel();
        community_events1 = new javax.swing.JScrollPane();
        community_event = new javax.swing.JPanel();
        comunity_title2 = new javax.swing.JLabel();
        search_community2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        Gallery = new javax.swing.JPanel();
        Top = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Slogan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Info = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        Home.setBackground(new java.awt.Color(255, 255, 255));

        top.setBackground(new java.awt.Color(255, 255, 255));
        top.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        top.setText("Early Events");

        event2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        event3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        event4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        event5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        event1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        event_name1.setText("See details");

        event_name2.setText("See details");

        event_name3.setText("See details");

        event_name4.setText("See details");

        event_name5.setText("See details");

        event1details.setText("Show details");
        event1details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event1detailsActionPerformed(evt);
            }
        });

        event2details.setText("Show details");
        event2details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event2detailsActionPerformed(evt);
            }
        });

        event3details.setText("Show details");
        event3details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event3detailsActionPerformed(evt);
            }
        });

        event4details.setText("Show details");
        event4details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event4detailsActionPerformed(evt);
            }
        });

        event5details.setText("Show details");
        event5details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event5detailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(event1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(event_name1))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(event1details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(event2details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(event3details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(event2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(event_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)))
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(event3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(event_name3)))))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(event4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(event_name4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(event4details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(event5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(event_name5))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(event5details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(633, 633, 633)
                        .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(event4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addComponent(event3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(event_name3)
                            .addComponent(event_name4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(event3details)
                                .addComponent(event2details, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(event1details))
                            .addComponent(event4details)))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(event2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(event1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(event_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(event_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addComponent(event5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(event_name5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(event5details)))
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", Home);

        College_Event2.setBackground(new java.awt.Color(255, 255, 255));
        College_Event2.setAutoscrolls(true);

        college_events1.setBackground(new java.awt.Color(255, 255, 255));

        college_title2.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        college_title2.setText("College Events");

        imgeve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel8.setText("Event Name");

        event_name.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        event_name.setText("Event Name");

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel10.setText("Location");

        location_name.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        location_name.setText("Location");

        jLabel12.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel12.setText("Time");

        time_name.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        time_name.setText("Time");

        date_name.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        date_name.setText("Date");

        jLabel16.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel16.setText("Date");

        desc_name.setEditable(false);
        jScrollPane4.setViewportView(desc_name);

        jLabel18.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel18.setText("P.S. You need to first login to book for a event.");

        event_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Event_No", "Event Name", "Location", "Time", "Date"
            }
        ));
        event_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                event_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(event_table);

        javax.swing.GroupLayout college_events1Layout = new javax.swing.GroupLayout(college_events1);
        college_events1.setLayout(college_events1Layout);
        college_events1Layout.setHorizontalGroup(
            college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(college_events1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(college_title2)
                    .addGroup(college_events1Layout.createSequentialGroup()
                        .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(college_events1Layout.createSequentialGroup()
                                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel16))
                                .addGap(43, 43, 43)
                                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(time_name)
                                    .addComponent(location_name)
                                    .addComponent(date_name)
                                    .addComponent(event_name)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(imgeve, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        college_events1Layout.setVerticalGroup(
            college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(college_events1Layout.createSequentialGroup()
                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(college_events1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(college_title2)
                        .addGap(46, 46, 46)
                        .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgeve, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(college_events1Layout.createSequentialGroup()
                                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(event_name))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(location_name))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(time_name))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(college_events1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(date_name)
                                    .addComponent(jLabel16))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(college_events1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3973, Short.MAX_VALUE))
        );

        college_event1.setViewportView(college_events1);

        javax.swing.GroupLayout College_Event2Layout = new javax.swing.GroupLayout(College_Event2);
        College_Event2.setLayout(College_Event2Layout);
        College_Event2Layout.setHorizontalGroup(
            College_Event2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(College_Event2Layout.createSequentialGroup()
                .addComponent(college_event1, javax.swing.GroupLayout.PREFERRED_SIZE, 1385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        College_Event2Layout.setVerticalGroup(
            College_Event2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(college_event1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        Ev_MaxTab2.addTab("College Events", College_Event2);

        community_event.setBackground(new java.awt.Color(255, 255, 255));

        comunity_title2.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        comunity_title2.setText("Community Events");

        search_community2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        search_community2.setText("Search");
        search_community2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_community2ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout community_eventLayout = new javax.swing.GroupLayout(community_event);
        community_event.setLayout(community_eventLayout);
        community_eventLayout.setHorizontalGroup(
            community_eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(community_eventLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comunity_title2)
                .addGap(555, 555, 555)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(search_community2)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        community_eventLayout.setVerticalGroup(
            community_eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(community_eventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(community_eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comunity_title2)
                    .addGroup(community_eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_community2)))
                .addContainerGap(3861, Short.MAX_VALUE))
        );

        community_events1.setViewportView(community_event);

        javax.swing.GroupLayout Community_Event2Layout = new javax.swing.GroupLayout(Community_Event2);
        Community_Event2.setLayout(Community_Event2Layout);
        Community_Event2Layout.setHorizontalGroup(
            Community_Event2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Community_Event2Layout.createSequentialGroup()
                .addComponent(community_events1, javax.swing.GroupLayout.PREFERRED_SIZE, 1378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        Community_Event2Layout.setVerticalGroup(
            Community_Event2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(community_events1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        Ev_MaxTab2.addTab("Community Events", Community_Event2);

        javax.swing.GroupLayout Event2Layout = new javax.swing.GroupLayout(Event2);
        Event2.setLayout(Event2Layout);
        Event2Layout.setHorizontalGroup(
            Event2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ev_MaxTab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Event2Layout.setVerticalGroup(
            Event2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Event2Layout.createSequentialGroup()
                .addComponent(Ev_MaxTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Event", Event2);

        Gallery.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout GalleryLayout = new javax.swing.GroupLayout(Gallery);
        Gallery.setLayout(GalleryLayout);
        GalleryLayout.setHorizontalGroup(
            GalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1324, Short.MAX_VALUE)
        );
        GalleryLayout.setVerticalGroup(
            GalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Help", Gallery);

        Top.setBackground(new java.awt.Color(255, 255, 255));
        Top.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/uobfinal.jpg"))); // NOI18N

        Slogan.setFont(new java.awt.Font("Sofachrome Rg", 0, 24)); // NOI18N
        Slogan.setText("Kiosk For Your Service");

        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 2, 18)); // NOI18N
        jButton1.setText("Learn More");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 80, 120, 29);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel2.setText("events happening near you...");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 50, 170, 16);

        Info.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        Info.setText("A Platform to find all the amazing ");
        jPanel1.add(Info);
        Info.setBounds(220, 20, 200, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/Capture1.JPG"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -130, 490, 300);

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(Slogan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(Slogan)
                .addGap(57, 57, 57))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Login.setText("Login/Register");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Login)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
Kiosk_Log klog=new Kiosk_Log();
klog.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
AboutUs abus=new AboutUs();
abus.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void event5detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event5detailsActionPerformed
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='5' ");
            if (rs.next()){
                event_no=rs.getString("EVENT_ID");
                Seedetails sde=new Seedetails();
                sde.setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_event5detailsActionPerformed

    private void event4detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event4detailsActionPerformed
        try{
           
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='4' ");
            if (rs.next()){
                event_no=rs.getString("EVENT_ID");
                Seedetails sde=new Seedetails();
                sde.setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_event4detailsActionPerformed

    private void event3detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event3detailsActionPerformed
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='3' ");
            if (rs.next()){
                event_no=rs.getString("EVENT_ID");
                Seedetails sde=new Seedetails();
                sde.setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_event3detailsActionPerformed

    private void event2detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event2detailsActionPerformed
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='2' ");
            if (rs.next()){
                event_no=rs.getString("EVENT_ID");
                Seedetails sde=new Seedetails();
                sde.setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_event2detailsActionPerformed

    private void event1detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event1detailsActionPerformed
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='1' ");
            if (rs.next()){
                event_no=rs.getString("EVENT_ID");
                Seedetails sde=new Seedetails();
                sde.setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_event1detailsActionPerformed

    private void search_community2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_community2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_community2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void event_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_tableMouseClicked
        // TODO add your handling code here:
        int row= event_table.getSelectedRow();
    String click=(event_table.getModel().getValueAt(row,0).toString());
    try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+click+"' ");
            if (rs.next())
            {
                event_id=rs.getString("EVENT_ID");
                event_name.setText(rs.getString("EVENT_NAME"));
                location_name.setText(rs.getString("LOCATION"));
                time_name.setText(rs.getString("TIME"));
                date_name.setText(rs.getString("EVENT_DATE"));
                desc_name.setText(rs.getString("DESCRIPTION"));
                byte[] imgData = null;
                 Blob img  = rs.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 imgeve.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
            }
            
            else
            {
                System.out.println("Error");
            }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_event_tableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Events().setVisible(true);
            }
        });

    }

    /**
     *
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel College_Event2;
    private javax.swing.JPanel Community_Event2;
    private javax.swing.JTabbedPane Ev_MaxTab2;
    private javax.swing.JPanel Event2;
    private javax.swing.JPanel Gallery;
    private javax.swing.JPanel Home;
    private javax.swing.JLabel Info;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Slogan;
    private javax.swing.JPanel Top;
    private javax.swing.JScrollPane college_event1;
    private javax.swing.JPanel college_events1;
    private javax.swing.JLabel college_title2;
    private javax.swing.JPanel community_event;
    private javax.swing.JScrollPane community_events1;
    private javax.swing.JLabel comunity_title2;
    private javax.swing.JLabel date_name;
    private javax.swing.JTextPane desc_name;
    private javax.swing.JLabel event1;
    private javax.swing.JButton event1details;
    private javax.swing.JLabel event2;
    private javax.swing.JButton event2details;
    private javax.swing.JLabel event3;
    private javax.swing.JButton event3details;
    private javax.swing.JLabel event4;
    private javax.swing.JButton event4details;
    private javax.swing.JLabel event5;
    private javax.swing.JButton event5details;
    private javax.swing.JLabel event_name;
    private javax.swing.JLabel event_name1;
    private javax.swing.JLabel event_name2;
    private javax.swing.JLabel event_name3;
    private javax.swing.JLabel event_name4;
    private javax.swing.JLabel event_name5;
    private javax.swing.JTable event_table;
    private javax.swing.JLabel imgeve;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel location_name;
    private javax.swing.JButton search_community2;
    private javax.swing.JLabel time_name;
    private javax.swing.JLabel top;
    // End of variables declaration//GEN-END:variables
}
