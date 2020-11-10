package edu.tutorial.concurency.threadstates;

public class WaitNotifyDemo1 implements Runnable {
	/*
	 * Monitor object used separate Object lock
	 */
	private Object lock;
	
    public WaitNotifyDemo1(Object lock) {
		this.lock = lock;
	}

	public void run() {
        System.out.println("Hello from a thread!");
        try {
        	synchronized (lock) {
        		lock.wait();
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
    	Thread helloThread = new Thread(new WaitNotifyDemo1(lock), "HelloThread");
    	helloThread.start();
    	

		Thread.sleep(1000L);

    	System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
    	synchronized (lock) {
    		System.out.println("before notify");
    		lock.notifyAll();	
    		System.out.println("after notify");
		}
    	
        System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
        Thread.sleep(1000L);
        System.out.format("Name: %s, State, %s%n", helloThread.getName(), helloThread.getState());
    }

}