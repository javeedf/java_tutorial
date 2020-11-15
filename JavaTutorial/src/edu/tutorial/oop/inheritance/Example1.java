package edu.tutorial.oop.inheritance;

abstract class Animal {
	public Animal() {
		System.out.println("print in Animal class");
	}
	
	public Animal(String name) {
		System.out.println("print in Animal class with name: ");
	}
	
	void walk(){
		System.out.println("I am walking");
	}
	
	abstract void fly() throws Exception;
}

class Dog extends Animal {
	void fly() throws Exception {
		throw new Exception("Sorry, I cannot fly!!");
	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}
}

class Eagle extends Bird {

	@Override
	void fly() {
		System.out.println("I am flying high");
	}
}

public class Example1 {

	public static void main(String[] args){
		example1();
	}

	public static void example2() {
		Bird bird = new Bird();
		bird.walk();
		bird.fly();
	}

	public static void example1() {
		Bird bird = new Bird();
		bird.walk();
		bird.fly();
	}
	
	public static void example3() {
		Bird bird = new Eagle();
		bird.walk();
		bird.fly();
	}

	public static void example4() {
		Animal animal = new Dog();
		Bird bird = new Bird();
		Eagle eagle = new Eagle();
		
		Animal[] animals = {animal, bird, eagle};
		
		for(Animal animalObj: animals) {
			//animalObj.walk();
			//animalObj.fly();
		}
	}	
}





