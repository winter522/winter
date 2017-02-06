package org.winter.test;

public class Consumer extends Thread{
	private MyQueue mq;
	private int num;
	public Consumer(MyQueue mq) {
		super();
		this.setMq(mq);
	}

	public MyQueue getMq() {
		return mq;
	}

	public void setMq(MyQueue mq) {
		this.mq = mq;
	}
	public void comsume(int num){
		mq.consume(num);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		comsume(num);
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
