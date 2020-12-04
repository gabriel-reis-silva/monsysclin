/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;
import oshi.software.os.OSFileStore;

/**
 *
 * @author gabsg
 */
public class Disco {

    OSFileStore disco;
    
public Long totalDisco(){
Long qtdeEspacoDisco = (disco.getUsableSpace());
return qtdeEspacoDisco;
}
//
//List<OSFileStore> disco = new ArrayList<>();
//   Double totalSpace;
//   Double freeSpace;
//   
//   public Double totalDisco(){
//       for(OSFileStore disk : disco){
//            this.totalSpace = (double)disk.getTotalSpace();   
//       }
//       return this.totalSpace;
//   }
//   public Double livreDisco(){
//       for(OSFileStore disk : disco){
//            this.freeSpace = (double)disk.getFreeSpace() / Math.pow(10, 9);  
//       }
//       return this.freeSpace;
//   }   
//   
//   public Double totalUso(){
//       return totalDisco() - livreDisco();
//   }
//
}
