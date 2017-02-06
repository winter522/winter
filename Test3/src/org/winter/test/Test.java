package org.winter.test;

//自己写一个回调函数：小李出去跑步，让小张在家帮忙做饭，做好之后打电话通知小李做好了
//回调的Java实现：
public class Test {
	public static void main(String[] args) {
		Li li=new Li();
		Zhang z=new Zhang(li);
		
		z.askHelp();
	}
}
interface CallBack{
	public void tel(String message);
}
class Zhang implements CallBack{
	private Li li;
	public Zhang(Li li) {
		// TODO Auto-generated constructor stub
		this.li=li;
	}
	public void askHelp(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				li.cook(Zhang.this);
			}}).start();
		paobu();
	}
	public void paobu(){
		for(int i=1;i<=5;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("我跑了"+i*1000+"米了");
		}
	}
	@Override
	public void tel(String message) {
		// TODO Auto-generated method stub
		System.out.println("小张打电话告诉我："+message);
	}

	public Li getLi() {
		return li;
	}

	public void setLi(Li li) {
		this.li = li;
	}

}
class Li{
	private String message;
	public void cook(CallBack cb) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(4000);
			System.out.println("两秒钟后...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMessage("饭菜做好了");
		cb.tel(getMessage());
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
