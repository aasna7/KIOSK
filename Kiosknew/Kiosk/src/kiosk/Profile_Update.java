/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Aasna
 */
public class Profile_Update extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    FileInputStream imageInputStream = null;
    static String path;
    Kiosk_Log klog=new Kiosk_Log();
    String stuno= klog.studentlog_;
    

    /**
     * Creates new form Profile_Update
     */
    public Profile_Update() {
        initComponents();
        propic.setBackground(Color.YELLOW);
                setDefaultCloseOperation(Profile_Update.DISPOSE_ON_CLOSE);
                datacheck();
                

    }
    
    public void datacheck()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROFILE WHERE STUDENT_NO='"+stuno+"'");
            if (rs.next())
            {
                fullnameupdate.setText(rs.getString("FULL_NAME"));
                studentlevelupdate.setText(rs.getString("STUDENT_LEVEL"));
                contactupdate.setText(rs.getString("CONTACT"));
                addressupdate.setText(rs.getString("ADDRESS"));
                byte[] imgData = null;
                 Blob img  = rs.getBlob("PICTURE");
                 imgData = img.getBytes(1,(int)img.length());
   BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
   
   propic.setIcon(new ImageIcon(image.getScaledInstance(propic.getWidth(), propic.getHeight(),Image.SCALE_SMOOTH)));
            }
            
            else
            {
                System.out.println("No data");
            }
             
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fullnameupdate = new javax.swing.JTextField();
        studentlevelupdate = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        upload_image = new javax.swing.JButton();
        propic = new javax.swing.JLabel();
        contactupdate = new javax.swing.JTextField();
        addressupdate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        setLocation(new java.awt.Point(300, 100));
        setMinimumSize(new java.awt.Dimension(550, 500));
        setPreferredSize(new java.awt.Dimension(550, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Sofachrome Rg", 0, 14)); // NOI18N
        jLabel1.setText("Update Profile");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 50, 209, 44);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/finalestlogo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 220, 110);

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel3.setText("Full Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(39, 137, 83, 28);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel4.setText("Student Level");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(39, 187, 89, 25);

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel5.setText("Contact No");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(39, 235, 83, 24);

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel6.setText("Address");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(39, 284, 83, 24);
        getContentPane().add(fullnameupdate);
        fullnameupdate.setBounds(146, 130, 163, 42);

        studentlevelupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentlevelupdateActionPerformed(evt);
            }
        });
        getContentPane().add(studentlevelupdate);
        studentlevelupdate.setBounds(146, 178, 163, 42);

        update.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(178, 344, 94, 27);

        upload_image.setFont(new java.awt.Font("Baskerville Old Face", 1, 12)); // NOI18N
        upload_image.setText("Upload Photo");
        upload_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_imageActionPerformed(evt);
            }
        });
        getContentPane().add(upload_image);
        upload_image.setBounds(360, 320, 113, 21);

        propic.setBackground(new java.awt.Color(102, 0, 153));
        propic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/Capture4.JPG"))); // NOI18N
        propic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(propic);
        propic.setBounds(327, 130, 174, 170);

        contactupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactupdateActionPerformed(evt);
            }
        });
        getContentPane().add(contactupdate);
        contactupdate.setBounds(146, 226, 163, 42);

        addressupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressupdateActionPerformed(evt);
            }
        });
        getContentPane().add(addressupdate);
        addressupdate.setBounds(146, 275, 163, 42);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/brandi-redd-122054-unsplash.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 540, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentlevelupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentlevelupdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentlevelupdateActionPerformed

    private void contactupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactupdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactupdateActionPerformed

    private void addressupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressupdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressupdateActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            null_check();    // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Profile_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void upload_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_imageActionPerformed
JFileChooser file = new JFileChooser();  
file.setCurrentDirectory(new File(System.getProperty("user.home")));
 FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              path = selectedFile.getAbsolutePath();
               propic.setIcon(ResizeImage(path));
 
          }
          
          
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
// TODO add your handling code here:
    }//GEN-LAST:event_upload_imageActionPerformed
 
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(propic.getWidth(), propic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    public void updating() throws FileNotFoundException
    {
        
        
        String  full_name=fullnameupdate.getText();
        String level_=studentlevelupdate.getText();
        String contact_=contactupdate.getText();
        String address_=addressupdate.getText();
        String username_=klog.studentlog_;
        FileInputStream fin=new FileInputStream(path);
        
                    // inform the statement that first parameter in the query is of binary type
		    
        
        
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ps = con.prepareStatement("INSERT INTO PROFILE(STUDENT_NO,FULL_NAME,STUDENT_LEVEL,CONTACT,ADDRESS,PICTURE) VALUES ('"+username_+"','"+full_name+"','"+level_+"','"+contact_+"','"+address_+"',?)");
                    // create an input stream pointing to the image file to store
            imageInputStream = new FileInputStream(new File(path));
                    // inform the statement that first parameter in the query is of binary type
            ps.setBinaryStream(1, imageInputStream);
                    // execute query
            ps.execute();
            
            
            System.out.println("Sucessfully Inserted");
             JOptionPane.showMessageDialog(null, "Inserted Successfully!");
             this.setVisible(false);
             Profile_View pview= new Profile_View();
             pview.setVisible(true);
             
            
            }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }
 
 public void null_check() throws FileNotFoundException
 {
     String  full_name=fullnameupdate.getText();
        String level_=studentlevelupdate.getText();
        String contact_=contactupdate.getText();
        String address_=addressupdate.getText();
        
        if (full_name==" " || level_==" " || contact_==" "|| address_==" ")
        {
            JOptionPane.showMessageDialog(null, "Please fill out all the fields.");
        }
        
        else
        {
            updating();
        }
     
 }
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
            java.util.logging.Logger.getLogger(Profile_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile_Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressupdate;
    private javax.swing.JTextField contactupdate;
    private javax.swing.JTextField fullnameupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel propic;
    private javax.swing.JTextField studentlevelupdate;
    private javax.swing.JButton update;
    private javax.swing.JButton upload_image;
    // End of variables declaration//GEN-END:variables
}