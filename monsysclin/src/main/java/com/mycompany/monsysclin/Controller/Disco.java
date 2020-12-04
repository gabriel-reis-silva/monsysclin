/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;
import java.util.ArrayList;
import java.util.List;
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

        public List usodisco() {
            for(OSFileStore ds : fileStores){
                diskUso.add((double)ds.getTotalSpace() / Math.pow(10, 9) - ds.getFreeSpace()/ Math.pow(10, 9));
            }
            return diskUso;
        }
        
        public List espacofree() {
            for(OSFileStore ds : fileStores){
                diskLivre.add(ds.getUsableSpace() / Math.pow(10, 9));
            }
            return diskLivre;
        }
}
