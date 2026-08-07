package com.hopeway.cam;
public class CameraDevice {
    public String id, name, ip, type;
    public boolean online;
    public int signal, battery;
    public CameraDevice(String id, String name, String ip, String type, boolean online, int signal, int battery) {
        this.id=id; this.name=name; this.ip=ip; this.type=type; this.online=online; this.signal=signal; this.battery=battery;
    }
}