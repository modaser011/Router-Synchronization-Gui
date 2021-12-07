package com.company;

class Semaphore {
    protected int value = 0;
    public static GUI gui;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int initial) {
        value = initial;
        if (Network.choice == 2) {
            gui = new GUI();
        }
    }

    public synchronized void semaphoreWait(String name) {

        value--;
        if (value < 0)
            try {
                Device device = Router.searchDevice(name);
                if (device != null) {
                    System.out.println("- (" + device.name + ") " + "(" + device.type + ") " + " arrived and waiting");
                }

                wait();
            } catch (InterruptedException e) {}
    }

    public synchronized void semaphoreSignal(String name) {
        value++;

        if (value <= 0) {
            Device device = Router.searchDevice(name);
            if (device != null) {
                Router.nameList.remove(Router.number(Thread.currentThread().getName()));
                Network.devices.remove(device);

            }
            notify();

        }

    }
}

