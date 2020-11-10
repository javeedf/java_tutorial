package edu.tutorial.concurency.threadstates;

public class WaitNotifyDemo3 implements Runnable {
	/*
	 * Monitor object used is Runnable WaitNotifyDemo3 object
	 */
	public void run() {
        System.out.println("Hello from a thread!");
        try {
        	synchronized (this) {
        		this.wait();
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
    	
    	Runnable runnableWaitNotify = new WaitNotifyDemo3();
    	Thread helloThread = new Thread(runnableWaitNotify, "HelloThread");
    	helloThread.start();
    	
		Thread.sleep(1000L);

    	System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
    	synchronized (runnableWaitNotify) {
    		System.out.println("before notify");
    		runnableWaitNotify.notifyAll();	
    		System.out.println("after notify");
		}
    	
        System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
        Thread.sleep(1000L);
        System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
    }

}