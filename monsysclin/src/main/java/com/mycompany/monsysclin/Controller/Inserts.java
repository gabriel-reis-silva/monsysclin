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
import javax.swing.JOptionPane;

/**
 *
 * @author gabsg
 */
public class Inserts {

    Cpu cpu = new Cpu();
    Memoria memoria = new Memoria();
    Network adaptador0 = new Network();

    String connectionUrl
            = "jdbc:sqlserver://monsysclin.database.windows.net:1433;"
            + "database=Monsysclin;user=administrador@monsysclin;"
            + "password=#Gfgrupo6;encrypt=true;"
            + "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";

    public void insereDados() {

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO leitura "
                    + "(cpuLeitura, memoriaLeitura, bytesRecebidos, bytesEnviados, disco, fkMaquina, datahoraLeitura ) values (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, cpu.toString());
            stmt.setDouble(2, memoria.getUso());
            stmt.setLong(3, adaptador0.bytesRecebidos());
            stmt.setLong(4, adaptador0.bytesEnviados());
            stmt.setDouble(5, 1.1);
            stmt.setInt(6, 15);
            stmt.setString(7, "2020-12-03 15:49:50");
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
