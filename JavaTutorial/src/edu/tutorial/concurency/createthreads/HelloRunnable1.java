package edu.tutorial.concurency.createthreads;

import java.util.Set;

public class HelloRunnable1 implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
    	System.out.println("In Main");    	
    	Thread helloThread = new Thread(new HelloRunnable1(), "HelloThread");
    	helloThread.start();
    }

}