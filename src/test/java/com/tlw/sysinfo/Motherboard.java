package com.tlw.sysinfo;

import org.junit.Test;
import oshi.SystemInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Motherboard {
    public static String getMotherboardSN() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto",".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs =
                    "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                            + "Set colItems = objWMIService.ExecQuery _ \n"
                            + "   (\"Select * from Win32_BaseBoard\") \n"
                            + "For Each objItem in colItems \n"
                            + "    Wscript.Echo objItem.SerialNumber \n"
                            + "    exit for  ' do the first cpu only! \n"
                            + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result.trim();
    }

    public static void main(String[] args){
        //CN0FVGFD717030CK0792
        String cpuId = getMotherboardSN();
        System.out.println(cpuId);
    }

    @Test
    public void test(){
        //CN0FVGFD717030CK0792
        SystemInfo si = new SystemInfo();
        String num = si.getHardware().getComputerSystem().getBaseboard().getSerialNumber();
        System.out.println(num);
    }
}
