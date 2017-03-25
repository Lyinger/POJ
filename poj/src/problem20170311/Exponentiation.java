/*
 * poj 1001
 * 大数问题 BigDecimal
 * 
 * 大数的指数运算
 */


package problem20170311;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String data=cin.next();
			int exp=cin.nextInt();
			BigDecimal result=new BigDecimal(data);
			result=result.pow(exp).stripTrailingZeros();
			String finResult=result.toPlainString();
			if(finResult.charAt(0)=='0') System.out.println(finResult.substring(1));
			else System.out.println(finResult);
		}
	}

}
