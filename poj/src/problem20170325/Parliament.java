/**
 * poj 1032
 * ������������----ʹ�˻����
 * 
 * ˼·��һ�������ܹ��������������1�����ֵĻ�����˻���Ȼ����С��ԭ�������������
 * ��һ�������Ա����ȫ��2��ʱ����˻���󡣵��ǣ���ĿҪ���ֳɵ����ֲ�����ȣ�
 * ���������Ȼ���ŵĲ�ַ�ʽ�Ǵ�2���ε��������ǿ��ܳ���2+3+4+2������������Ǳ�Ȼ��1
 * �Ӻ�������ֿ�ʼ���𣬼����2+4+5��
 * 
 * ע�⣺��Ҫ�ر��ǣ���19=2+3+4+5+5�����������ĩλ��Ҫ����2�������3+4+5+7��
 * 
 */
package problem20170325;

import java.util.Scanner;

/**
 * @author Lyinger
 *
 */
public class Parliament {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		
		int count=2;
		int sum=n;
		while(count<=sum){
			sum-=count;
			count++;
		}
		count--;//�ӵ����һ����
		//ԭ������=2+3+4+...+count+sum
		for(int i=2;i<=count;i++){
			if(i<=count-sum)
				System.out.print(i+" ");
			else if(i==count&&count==sum)
				System.out.print((i+2)+" ");
			else System.out.print((i+1)+" ");
		}
	}

}
