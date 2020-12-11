/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.View;

import com.mycompany.monsysclin.Controller.Memoria;
import com.mycompany.monsysclin.Controller.Cpu;

/**
 *
 * @author gabsg
 */
public class Tela01 extends javax.swing.JFrame {

    /**
     * Creates new form Tela01
     */
    public Tela01() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaCPU = new javax.swing.JTextArea();
        pbarCPU = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pbarMemo = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblMemoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        jButton1.setText("Pegar dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(200, 330, 150, 32);

        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        txtaCPU.setEditable(false);
        txtaCPU.setColumns(20);
        txtaCPU.setRows(5);
        jScrollPane1.setViewportView(txtaCPU);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 320, 160);

        pbarCPU.setStringPainted(true);
        jPanel1.add(pbarCPU);
        pbarCPU.setBounds(120, 80, 320, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dados do  Processador:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 140, 320, 20);

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setText("X");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(480, 0, 80, 32);

        jLabel3.setFont(new java.awt.Font("Kozuka Gothic Pr6N B", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MonSysClin");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 10, 191, 73);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Uso CPU:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 80, 60, 16);

        pbarMemo.setStringPainted(true);
        jPanel1.add(pbarMemo);
        pbarMemo.setBounds(120, 110, 320, 20);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Uso Memória:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 110, 80, 16);

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(0, 0, 64, 32);

        lblMemoria.setForeground(new java.awt.Color(0, 0, 0));
        lblMemoria.setText("Memória Disponível:");
        jPanel1.add(lblMemoria);
        lblMemoria.setBounds(340, 160, 220, 16);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Users\\gabsg\\Documents\\Faculdade\\Segundo Semestre\\Repositorio\\Sprint 1\\grupo-06-adsb-20201\\Projeto\\monsysclin\\src\\main\\java\\com\\mycompany\\monsysclin\\fundo.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 566, 369);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(561, 369));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        Integer intValue = ((int) cpu.cpuUsage());
//        Integer intMemo = memoria.capturaPorc().intValue();
//        String result = (cpu.cpuInfo().toString());
//        txtaCPU.setText(result);
//        pbarCPU.setValue(intValue);
//        pbarMemo.setValue(intMemo);
//        lblMemoria.setText(memoria.capturaMemoria());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();

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
            java.util.logging.Logger.getLogger(Tela01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela01().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMemoria;
    private javax.swing.JProgressBar pbarCPU;
    private javax.swing.JProgressBar pbarMemo;
    private javax.swing.JTextArea txtaCPU;
    // End of variables declaration//GEN-END:variables
}
