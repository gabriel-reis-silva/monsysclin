/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author gabsg
 */
public class Processos {
    
    public String processos(){
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        
        List<String> testeP = new ArrayList<>();
        
        List<OSProcess> procs = os.getProcesses(os.getProcessCount(), OperatingSystem.ProcessSort.CPU);
        
        for(OSProcess p : procs){
            testeP.add(p.getUser());
        }
        return testeP.get(1).toString();
    }
}
