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
public class UsuarioMaquina {
    
    private Integer idUsuarioMaquina, fkusuario, fkmaquina;

    public UsuarioMaquina(Integer idUsuarioMaquina, Integer fkusuario, Integer fkmaquina) {
        this.idUsuarioMaquina = idUsuarioMaquina;
        this.fkusuario = fkusuario;
        this.fkmaquina = fkmaquina;
    }

    public Integer getIdUsuarioMaquina() {
        return idUsuarioMaquina;
    }

    public Integer getFkusuario() {
        return fkusuario;
    }

    public Integer getFkmaquina() {
        return fkmaquina;
    }
    
    
    
}
