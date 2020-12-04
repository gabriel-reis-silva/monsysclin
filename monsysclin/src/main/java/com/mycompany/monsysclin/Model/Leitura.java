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
public class Leitura {

    private Integer idLeitura, fkMaquina;
    private String cpuLeitura, memoriaLeitura, bytesRecebidos, bytesEnviados, disco, datahoraLeitura;

    public Leitura(Integer idLeitura, Integer fkMaquina, String cpuLeitura, String memoriaLeitura, String bytesRecebidos, String bytesEnviados, String disco, String datahoraLeitura) {
        this.idLeitura = idLeitura;
        this.fkMaquina = fkMaquina;
        this.cpuLeitura = cpuLeitura;
        this.memoriaLeitura = memoriaLeitura;
        this.bytesRecebidos = bytesRecebidos;
        this.bytesEnviados = bytesEnviados;
        this.disco = disco;
        this.datahoraLeitura = datahoraLeitura;
    }

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public String getCpuLeitura() {
        return cpuLeitura;
    }

    public String getMemoriaLeitura() {
        return memoriaLeitura;
    }

    
    public String getBytesRecebidos() {
        return bytesRecebidos;
    }

    public String getBytesEnviados() {
        return bytesEnviados;
    }

    public String getDisco() {
        return disco;
    }

    public String getDatahoraLeitura() {
        return datahoraLeitura;
    }

    

    
}
