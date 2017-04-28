package com.seventeenkouer.multithread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wind on 17/4/27.
 */
public class MultiThreadDemo {
    public static void main(String[] args){


        int threadNum =  5000;

        List<MyThread> threads = new ArrayList<>(5000);
        try {

            for (int i = 0; i < threadNum; i++) {
                MyThread t = new MyThread(String.valueOf(i));
                threads.add(t);
                //Thread.sleep(1000);
                //t.start();
            }

            System.out.println("5000 threads created");

           for(MyThread t : threads) {
               t.start();
           }

            System.out.println("5000 threads started, they are working");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.in.read();
        } catch (IOException ex) {

        }

    }
}
