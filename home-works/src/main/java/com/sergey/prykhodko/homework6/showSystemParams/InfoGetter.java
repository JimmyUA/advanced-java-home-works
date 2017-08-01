package com.sergey.prykhodko.homework6.showSystemParams;

/**
 * Created by Sergey on 18.07.2017.
 */
public class InfoGetter {

    public static String getOsArchitecture(){
        return System.getProperty("os.arch");
    }

    public static String getOSVersion(){
        return "" + System.getProperty("os.name") +
                " version: " + System.getProperty("os.version");
    }

    public static String getUserAccountName(){
        return System.getProperty("user.name");
    }

}
