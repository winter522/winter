package org.winter.test;

import java.util.Scanner;

public class GuPiao {
	private static int func(int n){
		int start=1;
		int day=1;
		int day2=1;
		while(n>1){
			if(day<=day2){
				start++;
				day++;
			}else{
				start--;
				day2=day2+1;
				day=1;
			}
			n--;
		}
		return start;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(s.hasNext()){
			int n=s.nextInt();
			System.out.println(func(n));
		}
	}
}
