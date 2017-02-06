package org.winter.test;

public class Test2 {
	public static void main(String[] args) {
		MyQueue mq=new MyQueue();
		Provider p=new Provider(mq);
		Provider p2=new Provider(mq);
		Provider p3=new Provider(mq);
		Provider p4=new Provider(mq);
		Consumer c=new Consumer(mq);
		Consumer c2=new Consumer(mq);
		Consumer c3=new Consumer(mq);
		p.setNum(20);
		p2.setNum(30);
		p3.setNum(10);
		p4.setNum(22);
		c.setNum(40);
		c2.setNum(50);
		c3.setNum(25);
		p.start();
		p4.start();
		c.start();
		p2.start();
		c2.start();
		p3.start();
		c3.start();
	}
}
