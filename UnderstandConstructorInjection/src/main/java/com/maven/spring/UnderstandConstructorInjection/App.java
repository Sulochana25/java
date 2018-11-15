package com.maven.spring.UnderstandConstructorInjection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ConstructorInjection constructorInjection = new ConstructorInjection();
		System.out.println("callingConstructorWithoutSpecifyingType:");
		constructorInjection.callingConstructorWithoutSpecifyingType();

		System.out.println();
		System.out.println("callingConstructorWithSpecifyingType:");
		constructorInjection.callingConstructorWithSpecifyingType();

	}
}
