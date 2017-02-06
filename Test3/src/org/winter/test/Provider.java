package org.winter.test;

public class Provider extends Thread{
	private MyQueue mq;
	private int num;
	public Provider(MyQueue mq) {
		super();
		this.setMq(mq);
	}

	public MyQueue getMq() {
		return mq;
	}

	public void setMq(MyQueue mq) {
		this.mq = mq;
	}
	public void provide(int num){
		mq.production(num);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		provide(num);
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
