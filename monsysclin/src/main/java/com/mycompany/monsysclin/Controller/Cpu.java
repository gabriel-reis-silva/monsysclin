package com.mycompany.monsysclin.Controller;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class Cpu {

    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private CentralProcessor cpu = hal.getProcessor();
    private long[] oldTicks = cpu.getSystemCpuLoadTicks();

    public CentralProcessor cpuInfo() {
        return cpu;
    }

    public Double cpuUsage() {
        double d = cpu.getSystemCpuLoadBetweenTicks(oldTicks);
        return (100d * d);
    }
    
    @Override
    public String toString() {
        System.out.println(String.format("Uso CPU %.2f", cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100d));
        return String.format("%.2f", cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100d);
    }

}
