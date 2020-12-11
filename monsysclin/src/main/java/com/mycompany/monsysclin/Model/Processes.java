/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Model;

/**
 *
 * @author Luiz Gustavo
 */
public class Processes {

    private int idProcesso;
    private int idGrupoProcesso;
    private String nomeProcesso;
    private String usoCpu;
    private int usoMemoria;
    private int fkMaquina;
    private String dataHoraProcesso;

    public Processes() {

    }

    public Processes(int idProcesso, int idGrupoProcesso, String nomeProcesso, String usoCpu, int usoMemoria, String dataHoraProcesso, int fkMaquina) {
        this.idProcesso = idProcesso;
        this.idGrupoProcesso = idGrupoProcesso;
        this.nomeProcesso = nomeProcesso;
        this.usoCpu = usoCpu;
        this.usoMemoria = usoMemoria;
        this.dataHoraProcesso = dataHoraProcesso;
        this.fkMaquina = fkMaquina;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public int getIdGrupoProcesso() {
        return idGrupoProcesso;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public String getUsoCpu() {
        return usoCpu;
    }

    public int getUsoMemoria() {
        return usoMemoria;
    }

    public int getFkMaquina() {
        return fkMaquina;
    }

    public String getDataHoraProcesso() {
        return dataHoraProcesso;
    }

    @Override
    public String toString() {
        return "Processes{" + "idProcesso=" + idProcesso + ", idGrupoProcesso=" + idGrupoProcesso + ", nomeProcesso=" + nomeProcesso + ", usoCpu=" + usoCpu + ", usoMemoria=" + usoMemoria + '}';
    }
}
