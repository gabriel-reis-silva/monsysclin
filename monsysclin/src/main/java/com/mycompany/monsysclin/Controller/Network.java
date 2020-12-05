package com.mycompany.monsysclin.Controller;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

public class Network {

    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    public List<NetworkIF> netw = hal.getNetworkIFs();

    public Long bytesRecebidos() {
        netw.get(1).updateAttributes();
        Long bytesRcv = netw.get(1).getBytesRecv();
        System.out.println("Bytes Recebidos" + bytesRcv);
        return bytesRcv;
    }

    public Long bytesEnviados() {
        netw.get(1).updateAttributes();
        Long bytesSnt = si.getHardware().getNetworkIFs().get(1).getBytesSent();
        System.out.println("Bytes Enviados" + bytesSnt);
        return bytesSnt;
    }
}
