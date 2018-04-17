package com.tlw.sysinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//Java 直接获得网卡信息
public class NetworkMac {
    @Test
    public void test01() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while(networkInterfaceEnumeration.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            if(!networkInterface.isVirtual() && networkInterface.getHardwareAddress() != null && !networkInterface.isPointToPoint() && !networkInterface.isUp()){
                System.out.println(JSON.toJSON(networkInterface));
            }
        }
    }

    @Test
    public void test03(){
        //Board
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        for(NetworkIF networkIF:hal.getNetworkIFs()){
            System.out.println(JSON.toJSONString(networkIF, SerializerFeature.PrettyFormat));
        }
    }
}
