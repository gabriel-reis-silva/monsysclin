/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.View;

import com.mycompany.monsysclin.Controller.Conexao;
import com.mycompany.monsysclin.Controller.Cpu;
import com.mycompany.monsysclin.Controller.Disco;
import com.mycompany.monsysclin.Controller.Machine;
import com.mycompany.monsysclin.Controller.Memoria;
import com.mycompany.monsysclin.Model.Leitura;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabsg
 */
public class Leituras extends javax.swing.JFrame {

    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();
    Disco disco = new Disco();

    public Leituras() {
        initComponents();
        fundo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/fundo5.png")).getImage().getScaledInstance(1228, 666, Image.SCALE_SMOOTH)));
        showLeituras();
        txtArea.setText(cpu.cpuInfo().toString());
        atualizaBarras();
    }

    public ArrayList<Leitura> leituraList() {
        ArrayList<Leitura> leituraList = new ArrayList<>();
        Conexao conexao = new Conexao();
        Machine maquina = new Machine();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "select idLeitura, cpuLeitura, memoriaLeitura, bytesRecebidos,bytesEnviados, disco, fkMaquina, datahoraLeitura"
                    + " from leitura INNER JOIN maquina on idMaquina = fkMaquina WHERE serialNumber = '"
                    + maquina.numeroSerie() + "'";
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

    public void atualizaBarras() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                pbarCpu.setValue(cpu.cpuUsage().intValue());
                pbarMemoria.setValue(memoria.getPercentual().intValue());
                pbarDisco.setValue(disco.usoDiscoPorc().intValue());
            }
        }, 5000, 5000);
    }

    public void showLeituras() {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//                model.setNumRows(0);
        ArrayList<Leitura> list = leituraList();
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

//            }
//        }, 5000, 5000);
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
        btnSair = new javax.swing.JButton();
        pbarDisco = new javax.swing.JProgressBar();
        pbarCpu = new javax.swing.JProgressBar();
        pbarMemoria = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        atualizaDados = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 276, 1216, 376);

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setText("X");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(1160, 0, 70, 25);

        pbarDisco.setForeground(new java.awt.Color(0, 51, 255));
        pbarDisco.setStringPainted(true);
        getContentPane().add(pbarDisco);
        pbarDisco.setBounds(50, 200, 350, 40);

        pbarCpu.setForeground(new java.awt.Color(0, 51, 255));
        pbarCpu.setStringPainted(true);
        getContentPane().add(pbarCpu);
        pbarCpu.setBounds(50, 62, 350, 40);
        pbarCpu.getAccessibleContext().setAccessibleDescription("");

        pbarMemoria.setForeground(new java.awt.Color(0, 51, 255));
        pbarMemoria.setStringPainted(true);
        getContentPane().add(pbarMemoria);
        pbarMemoria.setBounds(50, 130, 350, 40);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(840, 40, 330, 200);

        jLabel1.setText("Uso do Disco:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 180, 140, 16);

        jLabel2.setText("Uso de CPU:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 30, 140, 16);

        jLabel3.setText("Uso de Memória:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 100, 140, 16);

        atualizaDados.setText("Atualizar");
        atualizaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaDadosActionPerformed(evt);
            }
        });
        getContentPane().add(atualizaDados);
        atualizaDados.setBounds(567, 240, 100, 32);
        getContentPane().add(fundo);
        fundo.setBounds(0, 0, 1230, 670);

        setSize(new java.awt.Dimension(1228, 666));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void atualizaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaDadosActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        showLeituras();
    }//GEN-LAST:event_atualizaDadosActionPerformed

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
            java.util.logging.Logger.getLogger(Leituras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leituras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leituras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leituras.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton atualizaDados;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JProgressBar pbarCpu;
    private javax.swing.JProgressBar pbarDisco;
    private javax.swing.JProgressBar pbarMemoria;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
