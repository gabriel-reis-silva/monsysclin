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
public class Maquinas {

    private Integer idMaquina;
    private String nomeMaquina, modeloMaquina, serialNumber;

    public Maquinas(Integer idMaquina, String nomeMaquina, String modeloMaquina, String serialNumber) {
        this.idMaquina = idMaquina;
        this.nomeMaquina = nomeMaquina;
        this.modeloMaquina = modeloMaquina;
        this.serialNumber = serialNumber;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public String getModeloMaquina() {
        return modeloMaquina;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
