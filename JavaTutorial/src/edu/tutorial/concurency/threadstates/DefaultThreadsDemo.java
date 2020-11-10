package edu.tutorial.concurency.threadstates;

import java.util.Set;

public class DefaultThreadsDemo {

    public static void main(String args[]) {
    	System.out.println("In Main");    	
        System.out.println("In Main: after thread start");
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for(Thread threadObj: threadSet) {
        	System.out.format("Name: %s, State: %s%n", threadObj.getName(), threadObj.getState());
        }      
    }

}