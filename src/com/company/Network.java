package com.company;

import java.util.ArrayList;

public class Network {
    static protected ArrayList<Device> devices = new ArrayList<>();
    static int maxSize;
    static int numberOfConnection;
    static int choice = 2;

    public static void main(String[] args) throws InterruptedException {
// console
//        Router router = new Router(Network.maxSize);
//
//        for (int i=1; i<=4; i++){
//            Device device=new Device("c"+i,"mobile");
//            devices.add(device);
//        }
        //router.occupy();


        // GUI
        SystemGui systemGui = new SystemGui();

    }
}
