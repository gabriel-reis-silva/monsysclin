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
    private String nomeMaquina, funcaoMaquina, modeloMaquina, serialNumber;

    public Maquinas(Integer idMaquina, String nomeMaquina, String funcaoMaquina, String modeloMaquina, String serialNumber) {
        this.idMaquina = idMaquina;
        this.nomeMaquina = nomeMaquina;
        this.funcaoMaquina = funcaoMaquina;
        this.modeloMaquina = modeloMaquina;
        this.serialNumber = serialNumber;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public String getFuncaoMaquina() {
        return funcaoMaquina;
    }

    public String getModeloMaquina() {
        return modeloMaquina;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
