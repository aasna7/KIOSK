/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 *
 * @author Aasna
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Seedetailsbook extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps = null;
Home_Login hlog= new Home_Login();
        String event_no1= hlog.event_no;
    /**
     * Creates new form Seedetails
     */
    public Seedetailsbook() {
        initComponents();
        show_details();
        
        
        
    }

    public void show_details()
    {
        try{
        System.out.println("if statement");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123456");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EVENT WHERE EVENT_ID='"+event_no1+"' ");
            eventnamesee.setText(rs.getString("EVENT_NAME"));
            locationsee.setText(rs.getString("LOCATION"));
            timesee.setText(rs.getString("TIME"));
            datesee.setText(rs.getString("EVENT_DATE"));
            descsee.setText(rs.getString("DESCRIPTION"));
            
            
}
catch(Exception e)
{
    e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imagesee = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descsee = new javax.swing.JTextPane();
        eventnamesee = new javax.swing.JLabel();
        locationsee = new javax.swing.JLabel();
        timesee = new javax.swing.JLabel();
        datesee = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Sofachrome Rg", 0, 14)); // NOI18N
        jLabel1.setText("EVENT DETAILS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 60, 194, 24);

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel2.setText("Event Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 130, 80, 15);

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel3.setText("Location");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 180, 57, 15);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel4.setText("Time");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(200, 240, 34, 15);

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel5.setText("Date");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 290, 31, 15);

        imagesee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(imagesee);
        imagesee.setBounds(60, 130, 122, 169);

        descsee.setEditable(false);
        jScrollPane1.setViewportView(descsee);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 320, 378, 80);

        eventnamesee.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        eventnamesee.setText("eventname");
        jPanel1.add(eventnamesee);
        eventnamesee.setBounds(300, 130, 59, 15);

        locationsee.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        locationsee.setText("location");
        jPanel1.add(locationsee);
        locationsee.setBounds(300, 180, 43, 15);

        timesee.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        timesee.setText("time");
        jPanel1.add(timesee);
        timesee.setBounds(300, 240, 24, 15);

        datesee.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        datesee.setText("date");
        jPanel1.add(datesee);
        datesee.setBounds(300, 290, 23, 15);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kiosk/finalestlogo.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(-20, -10, 210, 120);

        jButton1.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jButton1.setText("BOOK");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(200, 430, 90, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Seedetailsbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seedetailsbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seedetailsbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seedetailsbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seedetailsbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datesee;
    private javax.swing.JTextPane descsee;
    private javax.swing.JLabel eventnamesee;
    private javax.swing.JLabel imagesee;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationsee;
    private javax.swing.JLabel timesee;
    // End of variables declaration//GEN-END:variables
}
