/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.View;

import com.mycompany.monsysclin.Model.Leitura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabsg
 */
public class Leituras extends javax.swing.JFrame {

    /**
     * Creates new form Leituras
     */
    public Leituras() {
        initComponents();
        showLeituras();
    }

    public ArrayList<Leitura> leituraList() {

        ArrayList<Leitura> leituraList = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = ("jdbc:sqlserver:"
                    + "//monsysclin.database.windows.net:1433;"
                    + "database=Monsysclin;"
                    + "user=administrador@monsysclin;"
                    + "password={#Gfgrupo6};"
                    + "encrypt=true;"
                    + "trustServerCertificate=false;"
                    + "hostNameInCertificate=*.database.windows.net;"
                    + "loginTimeout=30;");
            Connection conn = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM leitura";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Leitura leitura;
            while (rs.next()) {
                leitura = new Leitura(rs.getInt("idLeitura"), 
                        rs.getInt("fkMaquina"),
                        rs.getString("cpuLeitura"),
                        rs.getString("memoriaLeitura"),
                        rs.getString("bytesRecebidos"),
                        rs.getString("bytesEnviados"),
                        rs.getString("disco"),
                        rs.getString("datahoraLeitura"));
                leituraList.add(leitura);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return leituraList;
    }

    public void showLeituras() {

        ArrayList<Leitura> list = leituraList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getIdLeitura();
            row[1] = list.get(i).getCpuLeitura();
            row[2] = list.get(i).getMemoriaLeitura();
            row[3] = list.get(i).getBytesRecebidos();
            row[4] = list.get(i).getBytesEnviados();
            row[5] = list.get(i).getDisco();
            row[6] = list.get(i).getFkMaquina();
            row[7] = list.get(i).getDatahoraLeitura();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPU", "Memória", "Bytes Recebidos", "Bytes Enviados", "Disco", "Maquina ID", "Data Leitura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(19, 19, 19)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
            java.util.logging.Logger.getLogger(Leituras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leituras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leituras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leituras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leituras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
