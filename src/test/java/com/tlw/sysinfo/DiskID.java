package com.tlw.sysinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;

import java.io.IOException;

public class DiskID {
    @Test
    public void test01(){
        //oshi: "serial":"    W -DCW6C1YLSPSLF",
        //windows: diskpart -> select disk=0 -> detail disk => 磁盘ID: 584D2EFE
        //wmic diskdrive get serialnumber => W -DCW6C1YLSPSLF
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        for(HWDiskStore diskStore:hal.getDiskStores()){
            System.out.println(JSON.toJSONString(diskStore, SerializerFeature.PrettyFormat));
        }
        System.out.println("----");
    }

    @Test
    public void test1() throws IOException {

    }
}
