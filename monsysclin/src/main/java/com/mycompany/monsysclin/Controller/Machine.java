/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

public class Machine {

    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private String numeroSerie;
    private String modeloMaquina;
    ComputerSystem computer;

    public String numeroSerie() {
        
        System.out.println("Numero série " + hal.getComputerSystem().getSerialNumber());
        numeroSerie = hal.getComputerSystem().getSerialNumber();
        return numeroSerie;
    }

    public String modeloMaquina() {
        System.out.println("Modelo maquina " + hal.getComputerSystem().getModel());
        modeloMaquina = hal.getComputerSystem().getModel();
        return modeloMaquina;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getModeloMaquina() {
        return modeloMaquina;
    }

    public ComputerSystem getComputer() {
        return computer;
    }

}
