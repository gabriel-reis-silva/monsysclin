/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Model;

import com.mycompany.monsysclin.Controller.Conexao;
import com.mycompany.monsysclin.Controller.Machine;
import com.mycompany.monsysclin.Model.Maquinas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gabsg
 */
public class Selects {
    //fazer um insert com os dados da maquina e antes do insert rolar rola um select que ve se ja tem aquela máquina no banco só aí faz o insert

    private Boolean checaMaquina;
    public Boolean checaMaquina() {
        Conexao conexao = new Conexao();
        Machine maquina = new Machine();
        try {
            maquina.numeroSerie();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(conexao.getStringUrl());
            String query1 = "SELECT * FROM maquina WHERE serialNumber= '" + maquina.getNumeroSerie()+ "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Maquinas maquinas;
            while (rs.next()) {
                maquinas = new Maquinas(rs.getInt("idMaquina"),
                        rs.getString("nomeMaquina"),
                        rs.getString("funcaoMaquina"),
                        rs.getString("modeloMaquina"),
                        rs.getString("serialNumber"));
            }
            checaMaquina = false;
        } catch (Exception e) {
            checaMaquina = true;
            System.out.println("ERRO: " + e);
        }

        return checaMaquina;
    }
}
