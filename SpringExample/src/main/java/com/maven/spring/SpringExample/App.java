package com.maven.spring.SpringExample;

public class App {
	public static void main(String[] args) {

		UnderstandingBeans understandingBeans = new UnderstandingBeans();

		System.out.println("---- Understanding Scopes -----");
		understandingBeans.beanScopes();

		System.out.println();
		System.out.println("--- Bean Definition inheritance ---");
		understandingBeans.beanInheritance();

		System.out.println();
		System.out.println("--- Bean life cycle ----");
		understandingBeans.beanLifeCycle();

	}
}
