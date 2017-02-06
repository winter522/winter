package org.winter.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Printf {
	
	char zero[][]={{' ','-',' '},{'|',' ','|'},{' ',' ',' '},{'|',' ','|'},{' ','-',' '}};
	char one[][]={{' ',' ',' '},{' ',' ','|'},{' ',' ',' '},{' ',' ','|'},{' ',' ',' '}};
	char two[][]={{' ','-',' '},{' ',' ','|'},{' ','-',' '},{'|',' ',' '},{' ','-',' '}};
	char three[][]={{' ','-',' '},{' ',' ','|'},{' ','-',' '},{' ',' ','|'},{' ','-',' '}};
	char fore[][]={{' ',' ',' '},{'|',' ','|'},{' ','-',' '},{' ',' ','|'},{' ',' ',' '}};
	char five[][]={{' ','-',' '},{'|',' ',' '},{' ','-',' '},{' ',' ','|'},{' ','-',' '}};
	char six[][]={{' ','-',' '},{'|',' ',' '},{' ','-',' '},{'|',' ','|'},{' ','-',' '}};
	char seven[][]={{' ','-',' '},{' ',' ','|'},{' ',' ',' '},{' ',' ','|'},{' ',' ',' '}};
	char eight[][]={{' ','-',' '},{'|',' ','|'},{' ','-',' '},{'|',' ','|'},{' ','-',' '}};
	char nine[][]={{' ','-',' '},{'|',' ','|'},{' ','-',' '},{' ',' ','|'},{' ','-',' '}};
	
	
	public static void main(String[] args) {
		Printf P=new Printf();
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		List<Integer> factor=new ArrayList<Integer>();
		//输入的数不得小于2
		for(int i=2;i<=n;){
			if(n%i==0){
				factor.add(i);
				n=n/i;
				i=2;
			}else{
				i=i+1;
			}
		}
//		System.out.println(factor.toString());
//		System.out.println(factor.size());
		char printf[][]=new char[5][factor.size()*15];
		System.out.println(printf.length+","+printf[0].length);
		int order=0;
		int star=0;
		
		for(int i=0;i<factor.size();i++){
			boolean re=true;
			star++;
			int x=factor.get(i);
			int x2=factor.get(i);
			@SuppressWarnings("rawtypes")
			List s=new ArrayList();
			for(;x2!=0;){
				s.add(x2%10);
				x2=x2/10;
			}
			for(int k=0;x!=0;k++){
				order=order+1;
				P.jointNumber(printf, (int) s.get(s.size()-k-1), order,star,re);
				x=x/10;
				re=false;
			}	
			
		}
		for(int i=0;i<printf.length;i++){
			for(int o=0;o<printf[i].length;o++){
				System.out.print(printf[i][o]);
			}
			System.out.println();
		}
	}
	private char[][] jointNumber(char[][] printf,int number,int order,int star,boolean re){
		System.out.println(number+"    "+order+"   "+star);
		order=order-1;
		star=star-1;
		if(number==1){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=one[i][n];
				}
			}
		}else if(number==2){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=two[i][n];
				}
			}
		}else if(number==3){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=three[i][n];
				}
			}
		}else if(number==4){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=fore[i][n];
				}
			}
		}else if(number==5){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=five[i][n];
				}
			}
		}else if(number==6){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=six[i][n];
				}
			}
		}else if(number==7){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=seven[i][n];
				}
			}
		}else if(number==8){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=eight[i][n];
				}
			}
		}else if(number==9){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=nine[i][n];
				}
			}
		}else if(number==0){
			for(int i=0;i<5;i++){
				for(int n=0;n<3;n++){
					printf[i][n+order*3+star]=zero[i][n];
				}
			}
		}
		if(order!=0&&re==true){
		printf[2][order*3+star-1]='*';
		}
		return printf;
	}
}
