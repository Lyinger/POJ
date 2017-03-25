/*
 * poj 1004
 * ����������
 * 
 * ������λС��
 * DecimalFormat
 */


package problem20170311;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FinancialManagement {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		float sum=0.0f;
		for(int i=0;i<12;i++){
			sum+=cin.nextFloat();
		}
		sum/=12;
		DecimalFormat df=new DecimalFormat("0.00");
		System.out.println("$"+df.format(sum));//df.format(sum)���ص���String���͵�
	}

}
