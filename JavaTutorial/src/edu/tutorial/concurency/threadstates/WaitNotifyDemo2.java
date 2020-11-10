package edu.tutorial.concurency.threadstates;

public class WaitNotifyDemo2 implements Runnable {
	/*
	 * Monitor object used WaitNotifyDemo2.class
	 */
	
	public void run() {
        System.out.println("Hello from a thread!");
        try {
        	synchronized (WaitNotifyDemo2.class) {
        		WaitNotifyDemo2.class.wait();
        		System.out.println("After wait: after notify");
			}        	
        	
		} catch (InterruptedException e) {   
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("After wait");
    }

    public static void main(String args[]) throws InterruptedException {
    	System.out.println("In Main");
    	Object lock = new Object();
    	Thread helloThread = new Thread(new WaitNotifyDemo2(), "HelloThread");
    	helloThread.start();
    	

		Thread.sleep(1000L);

    	System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
    	synchronized (WaitNotifyDemo2.class) {
    		System.out.println("before notify");
    		WaitNotifyDemo2.class.notifyAll();	
    		System.out.println("after notify");
		}
    	
        System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
        Thread.sleep(1000L);
        System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
    }

}