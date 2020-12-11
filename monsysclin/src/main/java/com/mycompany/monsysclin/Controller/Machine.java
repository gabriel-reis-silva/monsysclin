/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
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
        String OSName = System.getProperty("os.name");
        if (OSName.contains("Windows")) {
            System.out.println("Numero série " + hal.getComputerSystem().getSerialNumber());
            numeroSerie = hal.getComputerSystem().getSerialNumber();
            System.out.println("SO: WINDOWS");
        } else {
            String command = "sudo dmidecode -s system-serial-number";
            String sNum = null;
            try {
                Process SerNumProcess = Runtime.getRuntime().exec(command);
                BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                sNum = sNumReader.readLine().trim();
                SerNumProcess.waitFor();
                sNumReader.close();
            } catch (Exception ex) {
                System.err.println("Linux Motherboard Exp : " + ex.getMessage());
                sNum = null;
            }
            System.out.println("SO: LINUX" + sNum);
            numeroSerie = sNum;
            return sNum;
        }   
        return numeroSerie;
    }

    public String modeloMaquina() {
        System.out.println("Modelo maquina " + hal.getComputerSystem().getModel());
        modeloMaquina = hal.getComputerSystem().getModel();
        return modeloMaquina;
    }

    public String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
        }
        return "Maquina sem nome";
    }

    public String nomeMaquina() {
        return hal.getComputerSystem().getManufacturer();
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
