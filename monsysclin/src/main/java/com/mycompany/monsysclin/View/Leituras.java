/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.View;

import com.mycompany.monsysclin.Controller.Conexao;
import com.mycompany.monsysclin.Controller.Machine;
import com.mycompany.monsysclin.Model.Leitura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        Conexao conexao = new Conexao();
        Machine maquina = new Machine();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "select idLeitura, cpuLeitura, memoriaLeitura, bytesRecebidos,bytesEnviados, disco, fkMaquina, datahoraLeitura"
                    + " from leitura INNER JOIN maquina on idMaquina = fkMaquina WHERE serialNumber = '" + maquina.numeroSerie()+"'";
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
