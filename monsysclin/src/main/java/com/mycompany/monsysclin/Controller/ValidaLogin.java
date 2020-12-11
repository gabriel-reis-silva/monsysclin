package com.mycompany.monsysclin.Controller;

import javax.swing.JOptionPane;

public class ValidaLogin {

    private String login;
    private String senha;

    void Validar(String login, String senha) {
        
        this.login = login;
        this.senha = senha;
        
        if(login.equals("admin") && senha.equals("admin")){
            JOptionPane.showMessageDialog(null, "Credenciais corretas");
        }
    }

}
