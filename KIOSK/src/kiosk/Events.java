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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Events extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps = null;
static String event_no;

    public Events() {
        initComponents();
        System.out.println("if statement");
        show_event();
        
    }

    public void connectionDb() {
        Connection con = null;
        Statement st = null;
        PreparedStatement ps = null;
        Integer EventNum = null;
        String rowCount = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:aayu", "SYSTEM", "1234Aayu");
            st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select COUNT(*) FROM EVENTS");
                while (rs1.next()) {
                    rowCount = rs1.getString(1);
                }
                
            ResultSet rs = st.executeQuery("select * from EVENTS");
            while (rs.next()) {
                
                Integer j = 0;
                Integer x = 0;
                for(int i = 0; i < Integer.parseInt(rowCount); i++){
                    JLabel b1 = new JLabel();
                   
                    b1.setText(rs.getString(i+1));
                    //b1.setLocation(100, 10+x);
                    b1.setFont(new Font("Serif", Font.PLAIN, 20));
                    b1.setPreferredSize(new Dimension(200,200));
                    b1.setBounds(100,100, 100, 80);
                    //x = j + 100;
                    college_events.add(b1);
                    b1.setVisible(true);
                    System.out.print(b1.getText());
                }
                //b1.setText(rs.getString(2) + "  " + rs.getString(3) + "   ");
                
                
                
                
//             college_events.add(new JLabel(rs.getString(1)));
//               
            }

            //System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void getting_events() {

    }

    public class college_events extends javax.swing.JPanel {

        public void connection() {
            Connection con = null;
            Statement st = null;
            PreparedStatement ps = null;
            Integer EventNum = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:aayu", "SYSTEM", "1234Aayu");
                st = con.createStatement();
                ResultSet rs2 = st.executeQuery("select * from EVENTS");
                while (rs2.next()) {

//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));}
                    //ResultSet rs1=st.executeQuery("select COUNT(*) FROM EVENTS");
                    // String value = new String();
                    //while(rs1.next()){
                    //value = rs1.getString(1);
                    // String number = value;
                    //EventNum = Integer.parseInt(number);
                    //System.out.println(EventNum);
                }

            //System.out.println(value);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        public college_events() {
            initComponents();
            connectionDb();
            connection();
        }

    }
    public void show_event()
{
    System.out.println("if statement");
    try{
        System.out.println("if statement");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='1' ");
            if (rs.next())
             {
                 String event_id= rs.getString("EVENT_ID");
                 ResultSet rs1=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs1.next()){
                 System.out.println("if statement");
                 byte[] imgData = null;
                 Blob img  = rs1.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
   BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
   event1.setBounds(100,100,400,500);
   event1.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
   event_name1.setText(rs1.getString("EVENT_NAME"));
                //event1.setIcon();
                System.out.println("Sucessfully Inserted");
                 }
            }
            
            ResultSet rs2 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='2' ");
            if (rs2.next())
             {
                 String event_id= rs2.getString("EVENT_ID");
                 ResultSet rs12=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs12.next()){
                 System.out.println("if statement");
                 byte[] imgData = null;
                 Blob img  = rs12.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event2.setBounds(100,100,400,500);
                 event2.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name2.setText(rs12.getString("EVENT_NAME"));
                //event1.setIcon();
                System.out.println("Sucessfully Inserted");
                 }
            }
            
           ResultSet rs3 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='3' ");
            if (rs3.next())
             {
                 String event_id= rs3.getString("EVENT_ID");
                 ResultSet rs13=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs13.next()){
                 System.out.println("if statement");
                 byte[] imgData = null;
                 Blob img  = rs13.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event3.setBounds(100,100,400,500);
                 event3.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name3.setText(rs13.getString("EVENT_NAME"));
                //event1.setIcon();
                System.out.println("Sucessfully Inserted");
                 }
            }
            
            ResultSet rs4 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='4' ");
            if (rs4.next())
             {
                 String event_id= rs4.getString("EVENT_ID");
                 ResultSet rs14=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs14.next()){
                 System.out.println("if statement");
                 byte[] imgData = null;
                 Blob img  = rs14.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event4.setBounds(100,100,400,500);
                 event4.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name4.setText(rs14.getString("EVENT_NAME"));
                //event1.setIcon();
                System.out.println("Sucessfully Inserted");
                 }
            }
            ResultSet rs5 = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID FROM TOP_EVENTS WHERE EVENT_NO='5' ");
            if (rs5.next())
             {
                 String event_id= rs5.getString("EVENT_ID");
                 ResultSet rs15=stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_id+"'");
                 if (rs15.next()){
                 System.out.println("if statement");
                 byte[] imgData = null;
                 Blob img  = rs15.getBlob("EVENT_IMAGE");
                 imgData = img.getBytes(1,(int)img.length());
                 BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
                 event5.setBounds(100,100,400,500);
                 event5.setIcon(new ImageIcon(image.getScaledInstance(175,208,Image.SCALE_SMOOTH)));
                 event_name5.setText(rs15.getString("EVENT_NAME"));
                //event1.setIcon();
                System.out.println("Sucessfully Inserted");
             
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
        Event = new javax.swing.JPanel();
        Ev_MaxTab = new javax.swing.JTabbedPane();
        College_Event = new javax.swing.JPanel();
        college_title = new javax.swing.JLabel();
        search_college = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        college_events = new javax.swing.JPanel();
        Community_Event = new javax.swing.JPanel();
        comunity_title = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        search_community = new javax.swing.JButton();
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
        top.setText("Top Events");

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

        College_Event.setBackground(new java.awt.Color(255, 255, 255));

        college_title.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        college_title.setText("College Events");

        search_college.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        search_college.setText("Search");
        search_college.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_collegeActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        college_events.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout college_eventsLayout = new javax.swing.GroupLayout(college_events);
        college_events.setLayout(college_eventsLayout);
        college_eventsLayout.setHorizontalGroup(
            college_eventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1496, Short.MAX_VALUE)
        );
        college_eventsLayout.setVerticalGroup(
            college_eventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(college_events);

        javax.swing.GroupLayout College_EventLayout = new javax.swing.GroupLayout(College_Event);
        College_Event.setLayout(College_EventLayout);
        College_EventLayout.setHorizontalGroup(
            College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(College_EventLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(college_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 615, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_college)
                .addGap(144, 144, 144))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        College_EventLayout.setVerticalGroup(
            College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(College_EventLayout.createSequentialGroup()
                .addGroup(College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(College_EventLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_college)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, College_EventLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(college_title)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        Ev_MaxTab.addTab("College Events", College_Event);

        comunity_title.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        comunity_title.setText("Community Events");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        search_community.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        search_community.setText("Search");
        search_community.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_communityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Community_EventLayout = new javax.swing.GroupLayout(Community_Event);
        Community_Event.setLayout(Community_EventLayout);
        Community_EventLayout.setHorizontalGroup(
            Community_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Community_EventLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(comunity_title)
                .addGap(122, 122, 122)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_community)
                .addContainerGap(601, Short.MAX_VALUE))
        );
        Community_EventLayout.setVerticalGroup(
            Community_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Community_EventLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(Community_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comunity_title)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_community))
                .addContainerGap(647, Short.MAX_VALUE))
        );

        Ev_MaxTab.addTab("Community Events", Community_Event);

        javax.swing.GroupLayout EventLayout = new javax.swing.GroupLayout(Event);
        Event.setLayout(EventLayout);
        EventLayout.setHorizontalGroup(
            EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ev_MaxTab)
                .addContainerGap())
        );
        EventLayout.setVerticalGroup(
            EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EventLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ev_MaxTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Event", Event);

        Gallery.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout GalleryLayout = new javax.swing.GroupLayout(Gallery);
        Gallery.setLayout(GalleryLayout);
        GalleryLayout.setHorizontalGroup(
            GalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1304, Short.MAX_VALUE)
        );
        GalleryLayout.setVerticalGroup(
            GalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gallery", Gallery);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Login)
                        .addGap(93, 93, 93))))
            .addComponent(Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
Kiosk_Log klog=new Kiosk_Log();
klog.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void search_collegeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_collegeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_collegeActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void search_communityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_communityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_communityActionPerformed

    private void event3detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event3detailsActionPerformed
try{
        System.out.println("if statement");
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

    private void event4detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event4detailsActionPerformed
try{
        System.out.println("if statement");
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void event1detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event1detailsActionPerformed
try{
        System.out.println("if statement");
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

    private void event2detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event2detailsActionPerformed
try{
        System.out.println("if statement");
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

    private void event5detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event5detailsActionPerformed
try{
        System.out.println("if statement");
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
    private javax.swing.JPanel College_Event;
    private javax.swing.JPanel Community_Event;
    private javax.swing.JTabbedPane Ev_MaxTab;
    private javax.swing.JPanel Event;
    private javax.swing.JPanel Gallery;
    private javax.swing.JPanel Home;
    private javax.swing.JLabel Info;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Slogan;
    private javax.swing.JPanel Top;
    private javax.swing.JPanel college_events;
    private javax.swing.JLabel college_title;
    private javax.swing.JLabel comunity_title;
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
    private javax.swing.JLabel event_name1;
    private javax.swing.JLabel event_name2;
    private javax.swing.JLabel event_name3;
    private javax.swing.JLabel event_name4;
    private javax.swing.JLabel event_name5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton search_college;
    private javax.swing.JButton search_community;
    private javax.swing.JLabel top;
    // End of variables declaration//GEN-END:variables
}
