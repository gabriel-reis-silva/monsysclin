/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import com.mycompany.monsysclin.Model.Selects;
import com.mycompany.monsysclin.View.Login;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gabsg
 */
public class Inserts {

    Login login = new Login();
    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();
    Network adaptador0 = new Network();
    Disco disco = new Disco();
    Conexao conexao = new Conexao();
    Selects maquina = new Selects();
    Machine machine = new Machine();
    Processo processos = new Processo();
    String connectionUrl = conexao.getStringUrl();
    Log logs = new Log();

    public void insereMaquina() {
        if (!maquina.checaMaquina()) {
            System.out.println("Da pra inserir");

            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO maquina "
                        + "(nomeMaquina, modeloMaquina, serialNumber) values (?, ?, ?);");
                stmt.setString(1, machine.getHostname());
                stmt.setString(2, machine.modeloMaquina());
                stmt.setString(3, machine.numeroSerie());
                stmt.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
            System.out.println("Maquina já inserida. Ja foi fio");
        }
    }

    public void insereUsuarioMaquina(Integer idUsuario) {
        if (!maquina.checaUsuarioMaquina(idUsuario)) {
            System.out.println("Da pra associar " + idUsuario);

            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO usuarioMaquina "
                        + "(fkusuario, fkmaquina) values (?, ?);");
                stmt.setInt(1, idUsuario);
                stmt.setInt(2, maquina.getIdMaquina());
                stmt.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no insert da usuarioMaquina" + e);
            }

        } else {
            System.out.println("Maquina já associada. Ja foi fio");
        }
    }

    public void insereDados() {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:m:ss").format(new Date());

                try (Connection connection = DriverManager.getConnection(connectionUrl);) {
                    PreparedStatement stmt = connection.prepareStatement("EXEC insertLeitura ?,?,?,?,?,?,?;");
                    stmt.setString(1, machine.numeroSerie());
                    stmt.setString(2, cpu.toString());
                    stmt.setDouble(3, memoria.getUso());
                    stmt.setLong(4, adaptador0.bytesRecebidos());
                    stmt.setLong(5, adaptador0.bytesEnviados());
                    stmt.setString(6, disco.usodisco());
                    stmt.setString(7, timeStamp);
                    stmt.executeUpdate();
                    logs.validarLog("Leitura Registrada! Dados da leitura: \n"
                            + "Maquina: " + machine.numeroSerie() + " Uso de CPU: " + cpu.toString() + " Uso de Memoria: " + memoria.getUso()
                            + " Bytes Recebidos: " + adaptador0.bytesRecebidos() + " Bytes Enviados: " + adaptador0.bytesEnviados()
                            + " Uso de disco: " + disco.usodisco() + " Horário: " + timeStamp,
                            "Leituras");
                } catch (Exception e) {
                    try {
                        logs.validarLog("Leitura de dados deu errado! Erro: " + e, "Leituras");
                    } catch (IOException ex) {
                        Logger.getLogger(Inserts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }, 5000, 5000);

    }

}
