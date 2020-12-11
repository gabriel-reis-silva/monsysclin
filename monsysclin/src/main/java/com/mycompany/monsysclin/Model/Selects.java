/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Model;

import com.mycompany.monsysclin.Controller.Conexao;
import com.mycompany.monsysclin.Controller.Machine;
import com.mycompany.monsysclin.Model.Maquinas;
import com.mycompany.monsysclin.View.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gabsg
 */
public class Selects {

    private Integer idMaquina;
    private Integer idUsuarioMaquina;
    private Boolean checaMaquina;
    private Boolean checaUsuarioMaquina;
Conexao conexao = new Conexao();
        Machine maquina = new Machine();
    public Boolean checaMaquina() {
        try {
            maquina.numeroSerie();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "SELECT * FROM maquina WHERE serialNumber= '" + maquina.numeroSerie() + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Maquinas maquinas = null;
            while (rs.next()) {
                maquinas = new Maquinas(rs.getInt("idMaquina"),
                        rs.getString("nomeMaquina"),
                        rs.getString("modeloMaquina"),
                        rs.getString("serialNumber"));
            }
            if (maquinas == null) {
                checaMaquina = false;
            } else {
                checaMaquina = true;
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        return checaMaquina;
    }

    public Integer pegaIdMaquina() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "SELECT * FROM maquina WHERE serialNumber= '" + maquina.numeroSerie() + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Maquinas maquinas = null;
            while (rs.next()) {
                maquinas = new Maquinas(rs.getInt("idMaquina"),
                        rs.getString("nomeMaquina"),
                        rs.getString("modeloMaquina"),
                        rs.getString("serialNumber"));
                idMaquina = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        return idMaquina;
    }

   
    public Integer getIdMaquina() {
        return idMaquina;
    }

    public Integer pegaIdUsuario() {

        return idMaquina;
    }

    public Integer getIdUsuarioMaquina() {
        return idUsuarioMaquina;
    }
}
