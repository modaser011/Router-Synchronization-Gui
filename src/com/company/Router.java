package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Router extends Thread {
    static ArrayList<String> nameList = new ArrayList<>();
    static int counter=0;
    static protected Semaphore semaphore;

    public Router(int size) {
        semaphore = new Semaphore(size);
    }


    static protected Device searchDevice(String name) {
        for (Device device : Network.devices) {
            if (Objects.equals(device.name, name)) {
                return device;
            }
        }
        return null;
    }

    static protected int number(String name){
        for (int i=0; i<nameList.size();i++) {
            if (Objects.equals(nameList.get(i), name)) {
                return i;
            }
        }
        return 0;
    }


    @Override
    public void run() {

        semaphore.semaphoreWait(Thread.currentThread().getName());
        Device device = searchDevice(Thread.currentThread().getName());

        Random random = new Random(5);
        if (device != null) {

            System.out.println("- (" + device.name + ") " + "(" + device.type + ") " + " arrived");
            if(Network.choice == 2){
                Semaphore.gui.addUpdates("- (" + device.name + ") " + "(" + device.type + ") " + " arrived\n");
            }
            try {

                Thread.sleep(1000);
                System.out.println("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " Occupied");
                if(Network.choice == 2){
                    Semaphore.gui.addUpdates("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " Occupied\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1200);
                System.out.println("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " login");
                if(Network.choice == 2){
                    Semaphore.gui.addUpdates("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " login\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1500);
                System.out.println("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " performs online activity");
                if(Network.choice == 2){
                    Semaphore.gui.addUpdates("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " performs online activity\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
            try {
                Thread.sleep((random.nextInt(5)+1)*1000);
                System.out.println("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " logged out");
                if(Network.choice == 2){
                    Semaphore.gui.addUpdates("- Connection "+(number(Thread.currentThread().getName())+1)+": "+ device.name  + " logged out\n");
                }
                release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void occupy() {
        for (int i = 0; i < Network.devices.size(); i++) {
            Thread thread = new Thread(this, Network.devices.get(i).name);
            thread.start();
            nameList.add(Network.devices.get(i).name);
        }

    }

    public synchronized void  release() {
        semaphore.semaphoreSignal(Thread.currentThread().getName());
    }
}
