/**
 * poj 1006
 * 中国剩余定理的应用
 * 
 * n%23=p   n%28=e   n%33=i,求n
 * 
 * 解法一：(28*33*a)%23=1  (23*33*b)%28=1  (23*28*c)%33=1
 *        则，可以得到一个解
 *        
 *              (28*33*a)*p+(23*33*b)*e+(23*28*c)*i
 *        
 *        可通过%最大公倍数得到最小的整数解
 *        
 * 解法二：(28*33*a)%23=p  (23*33*b)%28=e  (23*28*c)%33=i
 *        则，可以得到一个解
 *        
 *              (28*33*a)+(23*33*b)+(23*28*c)
 *              
 *        可通过%最大公倍数得到最小的整数解
 */
package problem20170327;

import java.util.Scanner;

/**
 * @author Lyinger
 *
 */
public class Biorhythms {

	// 求得系数
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

			if (p == d && d == i && i == e & e == -1)//结束判断
				break;
			else {
				//中国剩余定理的第一种解法，距离d最近的下一个peak
				int days = (a * (p % 23) + b * (e % 28) + c * (i % 33) - d)% (23 * 28 * 33);
				if (days <= 0)//考虑到days小于等于0的情况，根据题目意思应该不存在小于0的情况
					days += (23 * 28 * 33);
				System.out
						.println("Case " + (count++)
								+ ": the next triple peak occurs in " + days
								+ " days.");
			}
		}

	}
}
