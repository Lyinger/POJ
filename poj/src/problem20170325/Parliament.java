/**
 * poj 1032
 * 整数划分问题----使乘积最大
 * 
 * 思路：一个数字能够被拆成两个大于1的数字的话，其乘积必然不会小于原来的数。因而，
 * 当一个数可以被拆成全是2的时，其乘积最大。但是，题目要求拆分成的数字不能相等，
 * 所以这里必然最优的拆分方式是从2依次递增，但是可能出现2+3+4+2这种情况，这是必然将1
 * 从后面的数字开始加起，即变成2+4+5。
 * 
 * 注意：需要特别考虑，如19=2+3+4+5+5这种情况，最末位需要加上2，即变成3+4+5+7。
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
		count--;//加的最后一个数
		//原来的数=2+3+4+...+count+sum
		for(int i=2;i<=count;i++){
			if(i<=count-sum)
				System.out.print(i+" ");
			else if(i==count&&count==sum)
				System.out.print((i+2)+" ");
			else System.out.print((i+1)+" ");
		}
	}

}
