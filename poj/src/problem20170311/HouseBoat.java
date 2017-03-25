package problem20170311;

/*
 * poj 1005
 */

import java.util.Scanner;

public class HouseBoat {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int i=0;i<n;i++){
			float x=cin.nextFloat();
			float y=cin.nextFloat();
			int year=(int) Math.ceil(Math.PI*(Math.pow(x, 2)+Math.pow(y, 2))/100);
			System.out.println("Property "+(i+1)+": This property will begin eroding in year "+year+".");
		}
		System.out.println("END OF OUTPUT.");
		cin.close();
	}

}
