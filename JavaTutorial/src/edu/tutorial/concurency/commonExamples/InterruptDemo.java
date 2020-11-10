package edu.tutorial.concurency.commonExamples;

import java.util.Timer;

public class InterruptDemo implements Runnable {

	
	
	public static void main(String[] args) {
		InterruptDemo demo1 = new InterruptDemo();
		
		Thread t1 = new Thread(demo1, "Interrupt Demo1 thread");
		t1.start();
		try {			
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("Called Thread intturnpt from main thread");
	}

	@Override
	public void run() {		
		System.out.println("Hello from a thread!");
		long start = System.currentTimeMillis();
		try {			
			System.out.format("Sleeing for 5s %s %n", start);
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Sleep interupted and waking up");
		}
		long end = start - System.currentTimeMillis();
		System.out.format("Time taken %s ms %n", end);
	}
}
