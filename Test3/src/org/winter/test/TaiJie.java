package org.winter.test;

import java.util.Scanner;

public class TaiJie {
	public static int func(int l,int r,int m){
		int count=0;
		for(int i=l;i<=r;i++){
			if(func2(i)==m){
				return count;
			}
			count++;
		}
		return -1;
	}
	//求出该数的二进制里有几个1
	public static int func2(int n){
		int count=0;
		while(n!=0){
			if(n%2==1){
				count++;
			}
			n/=2;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int l=s.nextInt();
		int r=s.nextInt();
		int m=s.nextInt();
		System.out.println(func(l,r,m));
	}
}
