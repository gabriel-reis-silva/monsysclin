/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import com.mycompany.monsysclin.View.Leituras;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author gabsg
 */
public class Inserts {

    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();
    Network adaptador0 = new Network();
    Disco disco = new Disco();

    String connectionUrl
            = "jdbc:sqlserver://monsysclin.database.windows.net:1433;"
            + "database=Monsysclin;user=administrador@monsysclin;"
            + "password=#Gfgrupo6;encrypt=true;"
            + "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";

    public void insereDados() {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:m:ss").format(new Date());
                
                try (Connection connection = DriverManager.getConnection(connectionUrl);) {
                    PreparedStatement stmt = connection.prepareStatement("INSERT INTO leitura "
                            + "(cpuLeitura, memoriaLeitura, bytesRecebidos, bytesEnviados, disco, fkMaquina, datahoraLeitura ) values (?, ?, ?, ?, ?, ?, ?)");
                    stmt.setString(1, cpu.toString());
                    stmt.setDouble(2, memoria.getUso());
                    stmt.setLong(3, adaptador0.bytesRecebidos());
                    stmt.setLong(4, adaptador0.bytesEnviados());
                    stmt.setString(5, "1.1");
                    stmt.setInt(6, 15);
                    stmt.setString(7, timeStamp);
                    stmt.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                Leituras leituras = new Leituras();
                leituras.showLeituras();
            }
        }, 5000, 5000);

    }

}
