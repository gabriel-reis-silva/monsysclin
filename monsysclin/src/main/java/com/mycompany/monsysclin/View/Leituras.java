/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.View;

import com.mycompany.monsysclin.Controller.*;
import com.mycompany.monsysclin.Model.Processes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author gabsg
 */
public class Leituras extends javax.swing.JFrame {

    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();
    Disco disco = new Disco();
    DefaultPieDataset dataset = new DefaultPieDataset();
    Processo pro = new Processo();

    public Leituras() {
        initComponents();
        fundo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/fundo5.png")).getImage().getScaledInstance(1228, 666, Image.SCALE_SMOOTH)));
        pro.insereProcessos();
        showProcesses();
        pro.insereProcessos();
        txtArea.setText(cpu.cpuInfo().toString());
        atualizaBarras();
        iniciaGrafico();
    }

    public ArrayList<Processes> processesList() {
        ArrayList<Processes> processList = new ArrayList<>();
        Conexao conexao = new Conexao();
        Machine maquina = new Machine();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "select idProcess, idGroupProcess, nomeProcess, usoCpu, usoMemoria, dataHoraProcesso, fkMaquina"
                    + " from processo INNER JOIN maquina on idMaquina = fkMaquina WHERE serialNumber = '"
                    + maquina.numeroSerie() + "'" + " order by usoMemoria desc;";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Processes processos;
            while (rs.next()) {
                processos = new Processes(
                        rs.getInt("idProcess"),
                        rs.getInt("idGroupProcess"),
                        rs.getString("nomeprocess"),
                        rs.getString("usoCpu"),
                        rs.getInt("usoMemoria"),
                        rs.getString("dataHoraProcesso"),
                        rs.getInt("fkMaquina"));
                processList.add(processos);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return processList;
    }

    public void atualizaBarras() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                pbarCpu.setValue(cpu.cpuUsage().intValue());
                pbarMemoria.setValue(memoria.getPercentual().intValue());
                pbarDisco.setValue(disco.usoDiscoPorc().intValue());
                jLabel2.setText("Uso de CPU: " + pbarCpu.getValue() + "%");
                jLabel3.setText("Uso de Memória: " + pbarMemoria.getValue() + "%");
                jLabel1.setText("Uso de Disco: " + pbarDisco.getValue() + "%");
                if (pbarCpu.getValue() <= 69) {
                    pbarCpu.setForeground(Color.green);
                } else if (pbarCpu.getValue() >= 70) {
                    pbarCpu.setForeground(Color.yellow);
                } else if (pbarCpu.getValue() >= 90) {
                    pbarCpu.setForeground(Color.red);
                }

                if (pbarMemoria.getValue() <= 69) {
                    pbarMemoria.setForeground(Color.green);
                } else if (pbarMemoria.getValue() <= 89) {
                    pbarMemoria.setForeground(Color.yellow);
                } else if (pbarMemoria.getValue() >= 90) {
                    pbarMemoria.setForeground(Color.red);
                }

                if (pbarDisco.getValue() <= 69) {
                    pbarDisco.setForeground(Color.green);
                } else if (pbarDisco.getValue() >= 70) {
                    pbarDisco.setForeground(Color.yellow);
                } else if (pbarDisco.getValue() >= 90) {
                    pbarDisco.setForeground(Color.red);
                }
                dataset.setValue(disco.nomeDisco() + " Em uso: " + String.format("%.2f", disco.uso())
                        + " GB ", disco.uso());
                dataset.setValue(disco.nomeDisco() + " Livre: " + String.format("%.2f", disco.livre())
                        + "GB ", disco.livre());
            }
        }, 5000, 5000);
    }
    private transient Map<Integer, OSProcess> priorSnapshotMap = new HashMap<>();

    public void showProcesses() {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                model.setNumRows(0);
//        ArrayList<Processes> list = processesList();
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();

        int cpuCount = si.getHardware().getProcessor().getLogicalProcessorCount();

        List<OSProcess> procs = os.getProcesses(os.getProcessCount(), OperatingSystem.ProcessSort.CPU);

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:m:ss").format(new Date());

        Object[] row = new Object[6];

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 1; i < procs.size(); i++) {
            row[0] = procs.get(i).getProcessID();
            row[1] = procs.get(i).getParentProcessID();
            row[2] = procs.get(i).getName();
            row[3] = String.format("%.1f", procs.get(i).getProcessCpuLoadBetweenTicks(priorSnapshotMap.get(procs)) / cpuCount * 100d) + "%";
            row[4] = procs.get(i).getResidentSetSize() / 1048576 + " mb";
            row[5] = timeStamp;
            model.addRow(row);
        }

//        for (int i = 0; i < list.size(); i++) {
//            row[0] = list.get(i).getIdProcesso();
//            row[1] = list.get(i).getIdGrupoProcesso();
//            row[2] = list.get(i).getNomeProcesso();
//            row[3] = list.get(i).getUsoCpu();
//            row[4] = list.get(i).getUsoMemoria();
//            row[5] = list.get(i).getFkMaquina();
//            row[6] = list.get(i).getDataHoraProcesso();
//            model.addRow(row);
//        }
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
        jPanel1 = new javax.swing.JPanel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Group", "Nome do processo", "Uso CPU ", "Uso memória", "Data e Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(15, 356, 1200, 310);

        btnSair.setBackground(new java.awt.Color(255, 0, 0));
        btnSair.setText("X");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(1160, 0, 70, 25);

        pbarDisco.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(pbarDisco);
        pbarDisco.setBounds(50, 200, 350, 40);

        pbarCpu.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(pbarCpu);
        pbarCpu.setBounds(50, 62, 350, 40);
        pbarCpu.getAccessibleContext().setAccessibleDescription("");

        pbarMemoria.setForeground(new java.awt.Color(0, 0, 0));
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
        jLabel2.setBounds(60, 40, 140, 16);

        jLabel3.setText("Uso de Memória:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 110, 140, 16);

        atualizaDados.setText("Atualizar");
        atualizaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaDadosActionPerformed(evt);
            }
        });
        getContentPane().add(atualizaDados);
        atualizaDados.setBounds(560, 320, 110, 32);

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(420, 10, 390, 310);
        getContentPane().add(fundo);
        fundo.setBounds(0, 0, 1230, 670);

        setSize(new java.awt.Dimension(1228, 676));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void atualizaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaDadosActionPerformed
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
        showProcesses();
//            }
//        }, 5000, 5000);
    }//GEN-LAST:event_atualizaDadosActionPerformed

    public void iniciaGrafico() {
        JFreeChart grafico = ChartFactory.createPieChart3D(
                "Gráfico de uso de Disco",
                dataset,
                true,
                true,
                false);

        PiePlot3D plot = (PiePlot3D) grafico.getPlot();
        plot.setForegroundAlpha(0.7f);
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        ChartPanel painelGrafico = new ChartPanel(grafico);
        jPanel1.removeAll();
        jPanel1.add(painelGrafico, BorderLayout.CENTER);
        jPanel1.validate();
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JProgressBar pbarCpu;
    private javax.swing.JProgressBar pbarDisco;
    private javax.swing.JProgressBar pbarMemoria;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
