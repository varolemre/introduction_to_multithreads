package com.varolemre;

public class Main {

    public static void main(String[] args) {
        data d = new data();
        d.deger=100;
        d.flag=false;
        producer p = new producer(d);

        consumer c = new consumer(d);
        Thread t = new Thread(c);
        p.start();
        t.start();
    }
}

class producer extends Thread {
    data d;

    public producer(data d){
        this.d=d;
    }
    public void run() {
        for (int i=0; i<10; i++){
            synchronized (d){
                if(!d.flag){
                    d.deger++;
                    System.out.println("uretici: "+d.deger);

                }

            }
            d.flag=true;
        }

    }
}

class consumer implements Runnable{
    data d;
    public consumer(data d){
        this.d=d;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            synchronized (d){
                if(d.flag){
                    d.deger--;
                    System.out.println("tuketici: "+d.deger);

                }

            }
            d.flag=false;
        }

    }
}

class data {
    int deger;
    boolean flag;
}
