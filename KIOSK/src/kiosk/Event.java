package kiosk;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Acharya
 */
public class Event extends javax.swing.JPanel {
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps = null;

    /**
     * Creates new form Event
     */
    public Event() {
        initComponents();
        show_event();
    }
public void show_event()
{
    try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EVENT_NO,EVENT_ID,EVENT_NAME,EVENT_IMAGE FROM TOP_EVENTS WHERE EVENT_NO='1' ");
            if (rs.next())
             {
                 byte[] imgData = null;
                 Blob img  = rs.getBlob(4);
                 imgData = img.getBytes(1,(int)img.length());
   BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
   event1.setIcon(new ImageIcon(image.getScaledInstance(118,142,Image.SCALE_SMOOTH)));
                //event1.setIcon();
                
            }
            System.out.println("Sucessfully Inserted");
             
            
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
        topevent = new javax.swing.JLabel();
        event2 = new javax.swing.JLabel();
        event3 = new javax.swing.JLabel();
        event4 = new javax.swing.JLabel();
        event5 = new javax.swing.JLabel();
        event1 = new javax.swing.JLabel();
        eventname1 = new javax.swing.JLabel();
        eventname2 = new javax.swing.JLabel();
        eventname3 = new javax.swing.JLabel();
        eventname4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        event1details = new javax.swing.JButton();
        event2details = new javax.swing.JButton();
        event3details = new javax.swing.JButton();
        event4details = new javax.swing.JButton();
        event5details = new javax.swing.JButton();
        Gallery = new javax.swing.JPanel();
        Event = new javax.swing.JPanel();
        Ev_MaxTab = new javax.swing.JTabbedPane();
        College_Event = new javax.swing.JPanel();
        college_title = new javax.swing.JLabel();
        college_des = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Community_Event = new javax.swing.JPanel();
        comunity_title = new javax.swing.JLabel();
        community_des = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Slogan = new javax.swing.JLabel();
        aboutus = new javax.swing.JButton();
        Login = new javax.swing.JButton();

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        topevent.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        topevent.setText("TOP EVENTS");

        eventname1.setText("See details");

        eventname2.setText("See details");

        eventname3.setText("See details");

        eventname4.setText("See details");

        jLabel6.setText("See details");

        event1details.setText("Show details");

        event2details.setText("Show details");

        event3details.setText("Show details");

        event4details.setText("Show details");

        event5details.setText("Show details");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(topevent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(event1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(event2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(event3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(event4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(event5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(eventname1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(event1details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(eventname2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(eventname3)
                                        .addGap(142, 142, 142)
                                        .addComponent(eventname4)
                                        .addGap(154, 154, 154)
                                        .addComponent(jLabel6))
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(event2details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(event3details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88)
                                        .addComponent(event4details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(event5details, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(topevent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(event5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(event4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(event2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(event3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(event1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventname1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eventname3)
                        .addComponent(eventname4)
                        .addComponent(jLabel6)
                        .addComponent(eventname2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(event1details)
                    .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(event2details, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(event3details)
                        .addComponent(event4details)
                        .addComponent(event5details)))
                .addContainerGap(29595, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", Home);

        javax.swing.GroupLayout GalleryLayout = new javax.swing.GroupLayout(Gallery);
        Gallery.setLayout(GalleryLayout);
        GalleryLayout.setHorizontalGroup(
            GalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
        );
        GalleryLayout.setVerticalGroup(
            GalleryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30014, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gallery", Gallery);

        college_title.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        college_title.setText("College Events");

        college_des.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        college_des.setText("Here Events Related to College will be shown.");

        search.setText("Search");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel1.setText("Event Details");

        javax.swing.GroupLayout College_EventLayout = new javax.swing.GroupLayout(College_Event);
        College_Event.setLayout(College_EventLayout);
        College_EventLayout.setHorizontalGroup(
            College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(College_EventLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(college_des, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(College_EventLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(college_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search)
                .addGap(154, 154, 154))
            .addGroup(College_EventLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        College_EventLayout.setVerticalGroup(
            College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(College_EventLayout.createSequentialGroup()
                .addGroup(College_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(College_EventLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(college_title))
                    .addGroup(College_EventLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(search)))
                .addGap(18, 18, 18)
                .addComponent(college_des, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        Ev_MaxTab.addTab("College Events", College_Event);

        comunity_title.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        comunity_title.setText("Community Events");

        community_des.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        community_des.setText("Here Events Related to Community will be shown.");

        javax.swing.GroupLayout Community_EventLayout = new javax.swing.GroupLayout(Community_Event);
        Community_Event.setLayout(Community_EventLayout);
        Community_EventLayout.setHorizontalGroup(
            Community_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Community_EventLayout.createSequentialGroup()
                .addGroup(Community_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Community_EventLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comunity_title))
                    .addGroup(Community_EventLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(community_des, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(550, Short.MAX_VALUE))
        );
        Community_EventLayout.setVerticalGroup(
            Community_EventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Community_EventLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(comunity_title)
                .addGap(29, 29, 29)
                .addComponent(community_des, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(502, Short.MAX_VALUE))
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

        jTabbedPane1.addTab("Events", Event);

        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/KIosksmallLogo.png"))); // NOI18N

        Slogan.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        Slogan.setText("Kiosk For Your Service.");

        aboutus.setText("know more about the page");
        aboutus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(Slogan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aboutus, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Slogan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aboutus)))
                .addContainerGap())
        );

        Login.setText("Login/Register");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Login)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void aboutusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutusActionPerformed
//new aboutus().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_aboutusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel College_Event;
    private javax.swing.JPanel Community_Event;
    private javax.swing.JTabbedPane Ev_MaxTab;
    private javax.swing.JPanel Event;
    private javax.swing.JPanel Gallery;
    private javax.swing.JPanel Home;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Slogan;
    private javax.swing.JButton aboutus;
    private javax.swing.JLabel college_des;
    private javax.swing.JLabel college_title;
    private javax.swing.JLabel community_des;
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
    private javax.swing.JLabel eventname1;
    private javax.swing.JLabel eventname2;
    private javax.swing.JLabel eventname3;
    private javax.swing.JLabel eventname4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton search;
    private javax.swing.JLabel topevent;
    // End of variables declaration//GEN-END:variables
}