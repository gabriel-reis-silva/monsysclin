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
        si.getHardware().getNetworkIFs().get(1).updateAttributes();
        Long bytesRcv =  si.getHardware().getNetworkIFs().get(1).getBytesRecv();
        System.out.println("Bytes Recebidos" + bytesRcv);
        return bytesRcv;
    }

    public Long bytesEnviados() {//fazer a diferença entre cada insert para ver o tamanho dos bytes recebidos e enviados na hr
        
        si.getHardware().getNetworkIFs().get(1).updateAttributes();
        Long bytesSnt = si.getHardware().getNetworkIFs().get(1).getBytesSent();
        System.out.println("Bytes Enviados" + bytesSnt);
        return bytesSnt;
    }
}
