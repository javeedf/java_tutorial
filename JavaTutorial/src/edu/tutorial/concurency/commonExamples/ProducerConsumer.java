package edu.tutorial.concurency.commonExamples;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		Thread t1 = new Thread(new Producer(list));
		Thread t2 = new Thread(new Consumer(list), "Raihan");
		Thread t3 = new Thread(new Consumer(list), "Kumar");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Producer implements Runnable {

	private List<String> list;

	Producer(LinkedList<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		int counter = 1;
		while (true) {
			synchronized (list) {
				for(int i=0; i<3; i++) {
					String serialNumber = "FERA" + counter++;
					list.add(serialNumber);
					System.out.println("Produced ::" + serialNumber);
				}
				try {
					list.notify();
					list.wait();				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Consumer implements Runnable {

	private LinkedList<String> list;

	Consumer(LinkedList<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (list) {
				while (list.size() == 0) {
					try {
						list.notify();
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String value = list.removeFirst();
				System.out.format("%s Consumed :: %s %n", Thread.currentThread().getName(), value);
				try {					
					list.notify();
					Thread.sleep(3000L);
					list.wait();					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}