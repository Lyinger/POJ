/**
 * poj 1006
 * �й�ʣ�ඨ���Ӧ��
 * 
 * n%23=p   n%28=e   n%33=i,��n
 * 
 * �ⷨһ��(28*33*a)%23=1  (23*33*b)%28=1  (23*28*c)%33=1
 *        �򣬿��Եõ�һ����
 *        
 *              (28*33*a)*p+(23*33*b)*e+(23*28*c)*i
 *        
 *        ��ͨ��%��󹫱����õ���С��������
 *        
 * �ⷨ����(28*33*a)%23=p  (23*33*b)%28=e  (23*28*c)%33=i
 *        �򣬿��Եõ�һ����
 *        
 *              (28*33*a)+(23*33*b)+(23*28*c)
 *              
 *        ��ͨ��%��󹫱����õ���С��������
 */
package problem20170327;

import java.util.Scanner;

/**
 * @author Lyinger
 *
 */
public class Biorhythms {

	// ���ϵ��
	public static int getCoe(int a, int b, int c) {
		int n = 1;
		while ((a * b * n) % c != 1)
			n++;
		return a * b * n;
	}

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in);

		int p, e, i, d;
		int count = 1;
		
		int a=getCoe(28,33,23);
		int b=getCoe(23,33,28);
		int c=getCoe(23,28,33);
		
		while (cin.hasNext()) {

			p = cin.nextInt();
			e = cin.nextInt();
			i = cin.nextInt();
			d = cin.nextInt();

			if (p == d && d == i && i == e & e == -1)//�����ж�
				break;
			else {
				//�й�ʣ�ඨ��ĵ�һ�ֽⷨ������d�������һ��peak
				int days = (a * (p % 23) + b * (e % 28) + c * (i % 33) - d)% (23 * 28 * 33);
				if (days <= 0)//���ǵ�daysС�ڵ���0�������������Ŀ��˼Ӧ�ò�����С��0�����
					days += (23 * 28 * 33);
				System.out
						.println("Case " + (count++)
								+ ": the next triple peak occurs in " + days
								+ " days.");
			}
		}

	}
}
