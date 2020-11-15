package edu.tutorial.oop.inheritance;

class Vehicle {  
  void run(){System.out.println("Vehicle is running");}  
}  
//Creating a child class  
class Bike2 extends Vehicle {  
  void run(){System.out.println("Bike is running safely");
  }  
}  

public class Example3 {
	  public static void main(String args[]){  
		  Vehicle obj = new Bike2();  
		  obj.run();  
	  }  
}