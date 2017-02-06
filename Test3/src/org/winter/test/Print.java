package org.winter.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Print {
	//求出一个数的所有素因子的集合
	public static List<Integer> func1(int n){
		List<Integer> list=new ArrayList<Integer>(8);
		int num=2;
		while(num*num<=n){
			while(n%num==0){
				list.add(num);
				n/=num;
			}
			num++;
		}
		if(n!=1){
			list.add(n);
		}
		return list;
	}
	//给出数字，纵坐标和矩阵，将对应的数字写到矩阵里
	public static void func2(int num,int col,char[][] n){
		switch (num) {
		case 1:
			n[1][col+1]='|';
			n[3][col+1]='|';
			break;
		case 2:
			n[0][col+1]='-';
			n[1][col+2]='|';
			n[2][col+1]='-';
			n[3][col]='|';
			n[4][col+1]='-';
			break;
		case 3:
			n[0][col+1]='-';
			n[1][col+2]='|';
			n[2][col+1]='-';
			n[3][col+2]='|';
			n[4][col+1]='-';
			break;
		case 4:
			n[1][col]='|';
			n[1][col+2]='|';
			n[2][col+1]='-';
			n[3][col+2]='|';
			break;
		case 5:
			n[0][col+1]='-';
			n[1][col]='|';
			n[2][col+1]='-';
			n[3][col+2]='|';
			n[4][col+1]='-';
			break;
		case 6:
			n[0][col+1]='-';
			n[1][col]='|';
			n[2][col+1]='-';
			n[3][col]='|';
			n[3][col+2]='|';
			n[4][col+1]='-';
			break;
		case 7:
			n[0][col+1]='-';
			n[1][col+2]='|';
			n[3][col+2]='|';
			break;
		case 8:
			n[0][col+1]='-';
			n[1][col]='|';
			n[1][col+2]='|';
			n[2][col+1]='-';
			n[3][col]='|';
			n[3][col+2]='|';
			n[4][col+1]='-';
			break;
		case 9:
			n[0][col+1]='-';
			n[1][col]='|';
			n[1][col+2]='|';
			n[2][col+1]='-';
			n[3][col+2]='|';
			n[4][col+1]='-';
			break;

		default:
			break;
		}
	}
	//根据list生成矩阵，再把list生成字符串，遍历字符串调用func2()就OK了
	public static void print(List<Integer> list){
		//这是*的个数
		int count=list.size()-1;
		Collections.sort(list);
		String str="";
		String str2="";
		for(int i:list){
			str+=i+"*";
			str2+=i;
		}
		
		str=str.substring(0, str.length()-1);
		char n[][]=new char[5][str2.length()*3+count];
		System.out.println(n.length*n[0].length);
		int col=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch!='*'){
				int num=ch-'0';
				func2(num,col,n);
				col+=3;
			}else{
				n[2][col++]='*';
			}
		}
		for(int i=0;i<n.length;i++){
			for(int j=0;j<n[0].length;j++){
				System.out.print(n[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(s.hasNext()){
			int n=s.nextInt();
			List<Integer> list=func1(n);
			print(list);
			
		}
	}
}
