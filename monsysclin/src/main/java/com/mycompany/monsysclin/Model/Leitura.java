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
    
    private Integer idLeitura;
    private String cpuLeitura, bytesRcv, bytesSnd;

    public Leitura(Integer idLeitura, String cpuLeitura, String bytesRcv, String bytesSnd) {
        this.idLeitura = idLeitura;
        this.cpuLeitura = cpuLeitura;
        this.bytesRcv = bytesRcv;
        this.bytesSnd = bytesSnd;
    }

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public String getCpuLeitura() {
        return cpuLeitura;
    }

    public String getBytesRcv() {
        return bytesRcv;
    }

    public String getBytesSnd() {
        return bytesSnd;
    }
    
    
}
