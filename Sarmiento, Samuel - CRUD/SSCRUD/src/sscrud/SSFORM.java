
package sscrud;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class SSFORM extends javax.swing.JFrame {


    public SSFORM() {
        initComponents();
        Connect();
        LoadPlayerNo();
        Fetch();
    }

Connection con;
PreparedStatement pst;
ResultSet rs;

public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public void LoadPlayerNo() {
    
        try {
            pst = con.prepareStatement("SELECT id FROM player_tbl");
            rs = pst.executeQuery();
            txtPID.removeAllItems();
            while (rs.next()) {
                txtPID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
}

  private void Fetch() {
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM player_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a=1; a <= 1; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("ptag"));
                    v2.add(rs.getString("prank"));
                    v2.add(rs.getString("pmrole"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUd = new javax.swing.JButton();
        btnDlt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        btnSr = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        txtDName = new javax.swing.JTextField();
        txtTag = new javax.swing.JTextField();
        txtRank = new javax.swing.JTextField();
        txtMRole = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPID = new javax.swing.JComboBox<>();
        btnpdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label5.setText("Player ID");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUd.setText("Update");
        btnUd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUdActionPerformed(evt);
            }
        });

        btnDlt.setText("Delete");
        btnDlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("VALORANT Player List");

        btnExport.setText("Export to CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnSr.setText("Search");
        btnSr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSrActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Player Display Name:");

        label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label2.setText("Player Tag (w/o #):");

        label3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label3.setText("Player Rank:");

        label4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label4.setText("Player Main Role:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Player ID", "Player Name", "Player Tag", "Player Rank", "Main Role"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        txtPID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnpdf.setText("Export to PDF");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(label4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUd)
                                .addGap(18, 18, 18)
                                .addComponent(btnDlt)
                                .addGap(18, 18, 18)
                                .addComponent(btnExport)
                                .addGap(18, 18, 18)
                                .addComponent(btnpdf)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(193, 193, 193)
                                        .addComponent(jLabel1))
                                    .addComponent(txtDName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTag, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMRole)
                                        .addComponent(txtRank, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1)
                                    .addComponent(label2))
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSr))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(txtDName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(txtTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(txtRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(txtMRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUd)
                    .addComponent(btnDlt)
                    .addComponent(btnExport)
                    .addComponent(btnpdf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if (txtDName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Player Display Name is empty!");
        }
        else if (txtTag.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Player Tag is empty!");
        }
        else if (txtRank.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Player Rank is empty!");
        }
        else if (txtMRole.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Main Role is empty!");
        }
        else {
        try {
            String pname = txtDName.getText();
            String ptag = txtTag.getText();
            String prank = txtRank.getText();
            String pmrole = txtMRole.getText();
            
            pst = con.prepareStatement("INSERT INTO player_tbl (pname,ptag,prank,pmrole)VALUES(?,?,?,?)");
            pst.setString(1,pname);
            pst.setString(2, ptag);
            pst.setString(3, prank);
            pst.setString(4, pmrole);
            
            int k = pst.executeUpdate();
            
            if (k==1) {
                JOptionPane.showMessageDialog(this, "Record added successfully!");
                txtDName.setText("");
                txtTag.setText("");
                txtRank.setText("");
                txtMRole.setText("");
                Fetch();
                LoadPlayerNo();
            }
            else {
                JOptionPane.showMessageDialog(this, "Record failed to save!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSrActionPerformed
        try {
            // TODO add your handling code here:
            
            String pid = txtPID.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM player_tbl WHERE id=?");
            pst.setString(1, pid);
            rs=pst.executeQuery();
            
            if(rs.next()==true) {
                txtDName.setText(rs.getString(2));
                txtTag.setText(rs.getString(3));
                txtRank.setText(rs.getString(4));
                txtMRole.setText(rs.getString(5));
            }
            else {
                JOptionPane.showMessageDialog(this, "No record found!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSrActionPerformed

    private void btnUdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUdActionPerformed
        if (txtDName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Player Display Name is empty!");
        }
        else if (txtTag.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Player Tag is empty!");
        }
        else if (txtRank.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Player Rank is empty!");
        }
        else if (txtMRole.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Main Role is empty!");
        }
        else {
        
        try {
            // TODO add your handling code here:
            
            String pname = txtDName.getText();
            String ptag = txtTag.getText();
            String prank = txtRank.getText();
            String pmrole = txtMRole.getText();
            String pid = txtPID.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE player_tbl SET pname=?,ptag=?,prank=?,pmrole=? WHERE id=?");
            
            pst.setString(1,pname);
            pst.setString(2, ptag);
            pst.setString(3, prank);
            pst.setString(4, pmrole);
            pst.setString(5, pid);
            
            int k=pst.executeUpdate();
            if (k==1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully updated!");
                    txtDName.setText("");
                    txtTag.setText("");
                    txtRank.setText("");
                    txtMRole.setText("");
                    txtDName.requestFocus();
                    Fetch();
                    LoadPlayerNo();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnUdActionPerformed

    private void btnDltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltActionPerformed
        try {
            // TODO add your handling code here:
            
            String pid = txtPID.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM player_tbl WHERE id=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
            
            if (k==1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted!");
                txtDName.setText("");
                txtTag.setText("");
                txtRank.setText("");
                txtMRole.setText("");
                txtDName.requestFocus();
                Fetch();
                LoadPlayerNo();
            }
            else {
                JOptionPane.showMessageDialog(this, "Record could not be deleted!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDltActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        
        String filename = "D:\\ValorantPListJava.csv";
        
        try {
            FileWriter fw = new FileWriter(filename);
            pst = con.prepareStatement("SELECT * FROM player_tbl");
            rs = pst.executeQuery();
           
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append('\n');
            }
            JOptionPane.showMessageDialog(this, "List was exported successfully to CSV!");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
        try {
            // TODO add your handling code here:
            
            pst = con.prepareStatement("SELECT * FROM player_tbl");
            rs = pst.executeQuery();
            
            Document PDFreport = new Document();
            PdfWriter.getInstance(PDFreport, new FileOutputStream("D:\\ValorantPListJava"));
            
            PDFreport.open();
            
            PdfPTable PDFTable = new PdfPTable(5);
            PdfPCell table_cell;
            
            while (rs.next()) {
                
                String pid = rs.getString("id");
                table_cell = new PdfPCell(new Phrase(pid));
                PDFTable.addCell(table_cell);
                
                String pname = rs.getString("pname");
                table_cell = new PdfPCell(new Phrase(pname));
                PDFTable.addCell(table_cell);
                
                String ptag = rs.getString("ptag");
                table_cell = new PdfPCell(new Phrase(ptag));
                PDFTable.addCell(table_cell);
                
                String prank = rs.getString("prank");
                table_cell = new PdfPCell(new Phrase(prank));
                PDFTable.addCell(table_cell);
                
                String pmrole = rs.getString("pmrole");
                table_cell = new PdfPCell(new Phrase(pmrole));
                PDFTable.addCell(table_cell);
            }
            JOptionPane.showMessageDialog(this, "List was exported successfully to PDF!");
            
            PDFreport.add(PDFTable);
            PDFreport.close();
        } catch (SQLException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SSFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnpdfActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDlt;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSr;
    private javax.swing.JButton btnUd;
    private javax.swing.JButton btnpdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JTextField txtDName;
    private javax.swing.JTextField txtMRole;
    private javax.swing.JComboBox<String> txtPID;
    private javax.swing.JTextField txtRank;
    private javax.swing.JTextField txtTag;
    // End of variables declaration//GEN-END:variables
}
