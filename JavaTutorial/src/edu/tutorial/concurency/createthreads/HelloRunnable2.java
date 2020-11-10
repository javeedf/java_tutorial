package edu.tutorial.concurency.createthreads;

class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

}

public class HelloRunnable2 {
    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

}