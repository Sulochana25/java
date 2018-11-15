package com.maven.spring.AutoWiring;

public class BeanA {
	private BeanB beanB;
	private BeanC beanC;

	public void printMessage() {

		System.out.println("Message of Bean A");
		beanB.printMessage();
		beanC.printMessage();
	}

	public BeanB getBeanB() {
		return beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}

	public BeanC getBeanC() {
		return beanC;
	}

	public void setBeanC(BeanC beanC) {
		this.beanC = beanC;
	}

}
