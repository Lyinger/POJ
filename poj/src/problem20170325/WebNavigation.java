package problem20170325;

/**
 *poj 1028
 *栈问题
 *
 *Stack类的使用
 *
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Lyinger
 *
 */
public class WebNavigation {

	public static void main(String[] args) {
		String root="http://www.acm.org/";
		String now=root;
		Stack<String> stackForward,stackBack;
		stackForward=new Stack<String>();
		stackBack=new Stack<String>();
		
		Scanner cin=new Scanner(System.in);
		boolean another=true;
		while(another){
			String opr=cin.next();
			switch(opr.charAt(0)){
			case 'V':
				stackBack.push(now);
				now=cin.next();
				stackForward.clear();
				System.out.println(now);
				break;
			case 'F':
				if(stackForward.isEmpty())
					System.out.println("Ignored");
				else{
					stackBack.push(now);
					now=stackForward.pop();
					System.out.println(now);
				}
				break;
			case 'B':
				if(stackBack.isEmpty())
					System.out.println("Ignored");
				else{
					stackForward.push(now);
					now=stackBack.pop();
					System.out.println(now);
				}
				break;
			case 'Q':
				another=false;
				break;
			}
		}
	}

}
