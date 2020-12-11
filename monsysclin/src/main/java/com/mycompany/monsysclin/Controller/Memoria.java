package com.mycompany.monsysclin.Controller;

import oshi.SystemInfo;

public class Memoria {

    private long memoriaDisponivel;
    private long memoriaTotal;
    private double usoMemoria;
    private double percentualUso;
    private SystemInfo si = new SystemInfo();

    public Double getUso() {
        this.memoriaDisponivel = si.getHardware().getMemory().getAvailable();
        this.memoriaTotal = si.getHardware().getMemory().getTotal();
        
        this.usoMemoria = (this.memoriaTotal - this.memoriaDisponivel) / Math.pow(10, 9);
        System.out.println("Uso memória"+usoMemoria);
        return usoMemoria;
    }

    public Double getPercentual() {
        this.memoriaDisponivel = si.getHardware().getMemory().getAvailable();
        this.memoriaTotal = si.getHardware().getMemory().getTotal();

        Double aux = (this.memoriaDisponivel * 100.00) / this.memoriaTotal;

        return this.percentualUso = 100 - aux;
    }

}
