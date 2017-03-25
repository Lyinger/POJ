/*
 * poj 1003
 * ��������������
 * 
 * ע�⣺1/n��Ҫ���ӷ�ĸ��Ϊ�����������ܵõ����������������ֻ�ܵõ�0.0
 */

package problem20170311;

import java.util.Scanner;

public class Hangover {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			float overhang=cin.nextFloat();
			float n=1.0f;
			float sum=(float) (1.0/(n+1.0));
			while(sum<overhang){
				n++;
				sum+=(float) (1.0/(n+1.0));
			}
			if(overhang!=0){
				System.out.println((int)n+" card(s)");
			}
		}
	}

}
