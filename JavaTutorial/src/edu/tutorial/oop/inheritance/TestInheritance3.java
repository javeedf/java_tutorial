package edu.tutorial.oop.inheritance;

class Animal1{  
	void bark(){System.out.println("animal sound...");}  
}  

class Dog1 extends Animal1 {  
	void bark(){System.out.println("barking...");}  
}  

class BigDog extends Dog1 {  
	void bark(){System.out.println("high barking ...");}  
}  

public class TestInheritance3{  
	public static void main(String args[]){  
		Dog1 c = new BigDog();  
		c.bark();  
	}
} 