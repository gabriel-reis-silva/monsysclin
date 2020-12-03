/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Model;

/**
 *
 * @author gabsg
 */
public class Usuario {

    private Integer idUsuario, tipo_usuario;
    private String nomeUsuario, emailUsuario, senhaUsuario;

    public Usuario(Integer idUsuario, Integer tipo_usuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.tipo_usuario = tipo_usuario;

    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario= " + idUsuario + ", tipo_usuario=" + tipo_usuario + ", nomeUsuario=" + nomeUsuario + ", emailUsuario=" + emailUsuario + ", senhaUsuario=" + senhaUsuario + '}';
    }

    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getTipo_usuario() {
        return tipo_usuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

}
