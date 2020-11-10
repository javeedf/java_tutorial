package edu.tutorial.oop.inheritance;

class Animal {
	void walk(){
		System.out.println("I am walking");
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
		Animal animal = new Animal();
		Bird bird = new Bird();
		Eagle eagle = new Eagle();
		
		Animal[] animals = {animal, bird, eagle};
		
		for(Animal animalObj: animals) {
			//animalObj.walk();
			//animalObj.fly();
		}
	}	
}





