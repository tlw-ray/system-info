package com.tlw.sysinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

//wmic CPU get ProcessorID
//CPU  SN:BFEBFBFF000106A5
public class CpuID {
    @Test
    public void test(){
        System.out.println(System.getenv("COMPUTERNAME"));
    }

    @Test
    public void test02(){
        //Board
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
//        System.out.println(JSON.toJSONString(hal.getComputerSystem(), SerializerFeature.PrettyFormat));
        System.out.println(JSON.toJSONString(hal.getProcessor(), SerializerFeature.PrettyFormat));
    }

}
