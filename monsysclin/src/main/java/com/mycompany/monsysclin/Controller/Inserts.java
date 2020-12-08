/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import com.mycompany.monsysclin.Model.Selects;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author gabsg
 */
public class Inserts {

    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();
    Network adaptador0 = new Network();
    Disco disco = new Disco();
    Conexao conexao = new Conexao();
    Selects maquina = new Selects();
    Machine machine = new Machine();
    Processos processos = new Processos();
    String connectionUrl = conexao.getStringUrl();

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

    public void insereDados() {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:m:ss").format(new Date());

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
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        }, 5000, 5000);

    }

}
