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
import javax.swing.JOptionPane;

/**
 *
 * @author Aasna
 */
public class Add_Event extends javax.swing.JPanel {
    Connection con=null;
    Statement stmt=null;
    PreparedStatement ps= null;

    /**
     * Creates new form Add_Event
     */
    
    public Add_Event() {
        initComponents();
        
        

    }
    public void inserting_event()
    {
        String event_add1= event_add.getText();
        String location_add1=location_add.getText();
        String time_add1=time_add.getText();
        String date_add1=date_add.getText();
        String desc_add1=desc_add.getText();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","123456");
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("INSERT INTO EVENTS(EVENT_ID,EVENT_NAME,LOCATION,TIME,EVENT_DATE,DESCRIPTION) VALUES(EVENT_ID.NEXTVAL,'"+event_add+"','"+location_add+"','"+time_add+"','"+date_add+"','"+desc_add+"')");
            
            
           }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR");
        }   
    }
  public  void Oracle_Conn()
  {
      
      
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date_add = new javax.swing.JTextField();
        time_add = new javax.swing.JTextField();
        location_add = new javax.swing.JTextField();
        event_add = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc_add = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(647, 542));
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel3.setText("ADD EVENTS");
        add(jLabel3);
        jLabel3.setBounds(220, 110, 130, 40);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel4.setText("Event Name");
        add(jLabel4);
        jLabel4.setBounds(90, 180, 100, 19);

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel10.setText("Date");
        add(jLabel10);
        jLabel10.setBounds(90, 330, 50, 20);

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel5.setText("Location");
        add(jLabel5);
        jLabel5.setBounds(90, 230, 70, 20);

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel6.setText("Time");
        add(jLabel6);
        jLabel6.setBounds(90, 280, 50, 20);

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel7.setText("Description");
        add(jLabel7);
        jLabel7.setBounds(90, 380, 100, 20);

        date_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_addActionPerformed(evt);
            }
        });
        add(date_add);
        date_add.setBounds(230, 320, 230, 30);

        time_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_addActionPerformed(evt);
            }
        });
        add(time_add);
        time_add.setBounds(230, 270, 230, 30);

        location_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_addActionPerformed(evt);
            }
        });
        add(location_add);
        location_add.setBounds(230, 220, 230, 30);

        event_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event_addActionPerformed(evt);
            }
        });
        add(event_add);
        event_add.setBounds(230, 170, 230, 30);

        desc_add.setColumns(20);
        desc_add.setRows(5);
        jScrollPane1.setViewportView(desc_add);

        add(jScrollPane1);
        jScrollPane1.setBounds(230, 380, 230, 137);

        jButton1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(280, 530, 80, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Photoshop Images\\KIosksmallLogo.png")); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(50, 10, 100, 110);

        jLabel8.setFont(new java.awt.Font("Sofachrome Rg", 0, 24)); // NOI18N
        jLabel8.setText("KIOSK");
        add(jLabel8);
        jLabel8.setBounds(220, 50, 128, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\concertpic.jpg")); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(0, -90, 570, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void event_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_event_addActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void location_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_location_addActionPerformed

    private void time_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_time_addActionPerformed

    private void date_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date_add;
    private javax.swing.JTextArea desc_add;
    private javax.swing.JTextField event_add;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField location_add;
    private javax.swing.JTextField time_add;
    // End of variables declaration//GEN-END:variables
}
