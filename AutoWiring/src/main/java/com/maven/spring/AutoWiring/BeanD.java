package com.maven.spring.AutoWiring;

public class BeanD {
	private BeanB beanB;
	private BeanC beanC;

	public BeanD(BeanB beanB) {
		this.beanB = beanB;
	}

	public BeanD(BeanB beanB, BeanC beanC) {
		this.beanB = beanB;
		this.beanC = beanC;
	}

	public void printMessage() {
		System.out.println("Message of Bean D");
		beanB.printMessage();
		beanC.printMessage();

	}

}
