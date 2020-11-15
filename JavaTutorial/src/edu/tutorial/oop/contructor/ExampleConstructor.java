package edu.tutorial.oop.contructor;

class Animal {
	public Animal() {
		System.out.println("print in Animal class");
	}
	
	public Animal(String name) {
		System.out.println("print in Animal class with name: " + name);
	}
}

class Dog extends Animal {
	public Dog() {
		System.out.println("print in Dog class");
	}
	public Dog(String name) {
		System.out.println("print in Dog class with name: " + name);
	}
}

public class ExampleConstructor {
	public static void main(String[] args){
		//Animal animal = new Animal();
		Dog dog = new Dog("Doggie");
	}
}

class Bird extends Animal {
	public Bird() {
		System.out.println("print in Bird class");
	}
	public Bird(String name) {
		System.out.println("print in Bird class with name: " + name);
	}
}

class Eagle extends Bird {
	public Eagle() {
		System.out.println("print in Eagle class");
	}
	public Eagle(String name) {
		System.out.println("print in Eagle class with name: " + name);
	}
}






