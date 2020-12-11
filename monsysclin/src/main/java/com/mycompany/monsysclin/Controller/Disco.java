/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import java.util.ArrayList;
import java.util.List;
import oshi.hardware.ComputerSystem;
import oshi.SystemInfo;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author gabsg
 */
public class Disco {

    SystemInfo si = new SystemInfo();
    OperatingSystem os = si.getOperatingSystem();
    List<OSFileStore> fileStores = os.getFileSystem().getFileStores();
    List<Double> diskUso = new ArrayList<>();
    List<Double> diskLivre = new ArrayList<>();

    public String usodisco() {
        Double uso = (fileStores.get(0).getTotalSpace() / Math.pow(10, 9) - fileStores.get(0).getFreeSpace() / Math.pow(10, 9));
        Double porc = (uso * 100) / (fileStores.get(0).getTotalSpace() / Math.pow(10, 9));
        System.out.println("espaco de disco em uso " + porc + "%");
        return String.format("%.2f", porc);
    }

    public String nomeDisco() {
        return fileStores.get(0).getName();
    }

    public Double usoDiscoPorc() {
        Double uso = (fileStores.get(0).getTotalSpace() / Math.pow(10, 9) - fileStores.get(0).getFreeSpace() / Math.pow(10, 9));
        Double porc = (uso * 100) / (fileStores.get(0).getTotalSpace() / Math.pow(10, 9));
        return porc;
    }

    public Double livreDiscoPorc() {
        return (fileStores.get(0).getFreeSpace() / Math.pow(10, 9) * 100) / (fileStores.get(0).getTotalSpace() / Math.pow(10, 9));
    }

    public Double uso() {
        return (fileStores.get(0).getTotalSpace() / Math.pow(10, 9) - fileStores.get(0).getFreeSpace() / Math.pow(10, 9));
    }

    public Double livre() {
        return fileStores.get(0).getFreeSpace() / Math.pow(10, 9);
    }

    public List espacofree() {
        for (OSFileStore ds : fileStores) {
            diskLivre.add(ds.getUsableSpace() / Math.pow(10, 9));
        }
        return diskLivre;
    }

}
