package org.winter.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	private static final int max=100;
	private Queue<Food> queue=new LinkedList<>();
	
	public Queue<Food> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Food> queue) {
		this.queue = queue;
	}
	public void production(int num){
		synchronized (queue) {
			while(queue.size()+num>=max){
				System.out.println("需要生产"+num+"个"+"队列已满，不可以再生产了！现存储量是："+queue.size());
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		for(int i=0;i<num;i++){
			/*try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			queue.add(new Food("食品"+i));
		}
		System.out.println("生产完毕，产出量为"+num+",现在的库存量是"+queue.size());
		queue.notifyAll();
		}
	}
	public void consume(int num){
		if(num<=0){
			throw new RuntimeException("脑子有病？");
		}
		synchronized (queue) {
			while(queue.size()<num){
				System.out.println("需要消费"+num+"个,"+"队列存储量不够，请稍后再来取！现存储量是："+queue.size());
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		for(int i=0;i<num;i++){
			/*try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			queue.remove();
		}
		
		System.out.println("消费完毕，消耗量为"+num+",现在的库存量是"+queue.size());
		queue.notifyAll();
		}
	}
}
