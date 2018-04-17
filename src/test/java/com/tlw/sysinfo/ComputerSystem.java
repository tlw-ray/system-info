package com.tlw.sysinfo;

import org.junit.Test;
import oshi.SystemInfo;

public class ComputerSystem {
    @Test
    public void test(){
        SystemInfo si = new SystemInfo();
        String num = si.getHardware().getComputerSystem().getSerialNumber();
        System.out.println(num);

    }
}
