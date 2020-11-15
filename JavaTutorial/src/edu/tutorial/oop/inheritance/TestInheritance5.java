package edu.tutorial.oop.inheritance;

class Bark {  
	public static void bark() {
		{System.out.println("high barking from static method...");}
	}
}  
 
class Dog3 extends Bark {  
	public static void bark(){System.out.println("high barking ...");}
}

public class TestInheritance5 {  
	public static void main(String args[]){  
		Dog3 c= new Dog3();  
		c.bark();  
	}
} 