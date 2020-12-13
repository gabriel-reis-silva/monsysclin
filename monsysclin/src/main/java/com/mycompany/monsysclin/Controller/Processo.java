/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import com.mycompany.monsysclin.Model.Processes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class Processo {

//    public List printProcesses() {
//        SystemInfo si = new SystemInfo();
//        OperatingSystem os = si.getOperatingSystem();
//        HardwareAbstractionLayer hal = si.getHardware();
//        GlobalMemory memory = hal.getMemory();
//        
//        List<String> proces = new ArrayList<>();
//
//        OSProcess myProc = os.getProcess(os.getProcessId());
//        // current process will never be null. Other code should check for null here
//        proces.add(
//                "My PID: " + myProc.getProcessID() + " with affinity " + Long.toBinaryString(myProc.getAffinityMask()));
//        proces.add("Processes: " + os.getProcessCount() + ", Threads: " + os.getThreadCount());
//
//        // Sort by highest CPU
//        List<OSProcess> procs = os.getProcesses(os.getProcessCount(), OperatingSystem.ProcessSort.CPU);
//
//        proces.add("   PID  %CPU %MEM       VSZ       RSS Name\n");
//
//        for (OSProcess p : procs) {
//            proces.add(String.format(" Id: %5d |-| Uso CPU: %5.1f |-| Uso Mem: %4.1f |-| VSZ: %9s |-| RSS: %9s |-| Nome: %s\n", p.getProcessID(),
//                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
//                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
//                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
//        }
//        return proces;
//    }
    Conexao conexao = new Conexao();
    String connectionUrl = conexao.getStringUrl();
    Machine machine = new Machine();
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();

    private transient Map<Integer, OSProcess> priorSnapshotMap = new HashMap<>();

    public List listaProcessos() {

        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();

        int cpuCount = si.getHardware().getProcessor().getLogicalProcessorCount();

        List<OSProcess> procs = os.getProcesses(os.getProcessCount(), OperatingSystem.ProcessSort.CPU);
        List<String> testeP = new ArrayList<>();
        for (OSProcess p : procs) {
            testeP.add("\n  ID = " + p.getProcessID() + "  ||  Nome = " + p.getName()
                    + "  ||  ID grupo = " + p.getParentProcessID() + "  ||  Memoria consumida = " + p.getResidentSetSize() / 1048576
                    + "  ||  Uso cpu = " + String.format("%.1f", 100d * p.getProcessCpuLoadBetweenTicks(priorSnapshotMap.get(p)) / cpuCount));
        }
        return testeP;
    }

    public void insereProcessos() {
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();

        int cpuCount = si.getHardware().getProcessor().getLogicalProcessorCount();

        List<OSProcess> procs = os.getProcesses(os.getProcessCount(), OperatingSystem.ProcessSort.CPU);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:m:ss").format(new Date());
                try (Connection connection = DriverManager.getConnection(connectionUrl);) {
                    for (OSProcess p : procs) {
                        PreparedStatement stmt = connection.prepareStatement("EXEC insertProcesso ?, ?, ?, ?, ?, ?, ?;");
                        stmt.setString(1, machine.numeroSerie());
                        stmt.setLong(2, p.getResidentSetSize() / 1048576);
                        stmt.setString(3, p.getName());
                        stmt.setInt(4, p.getParentProcessID());
                        stmt.setString(5, String.format("%.1f", 100d * p.getProcessCpuLoadBetweenTicks(priorSnapshotMap.get(p)) / cpuCount));
                        stmt.setInt(6, p.getProcessID());
                        stmt.setString(7, timeStamp);
                        stmt.executeUpdate();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }, 5000, 5000);
    }
}
