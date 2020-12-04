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
        netw.get(0).updateAttributes();
        Long bytesRcv = netw.get(0).getBytesRecv();
        return bytesRcv;
    }

    public Long bytesEnviados() {
        netw.get(0).updateAttributes();
        Long bytesSnt = si.getHardware().getNetworkIFs().get(0).getBytesSent();
        return bytesSnt;
    }
}
