/**
 * poj 1002
 * 将号码中的字母转换成对应数字，再计算重复数目
 * 
 * 
 * HashMap类，TreeSet类
 * 
 * ----利用HashMap类中的键key值不能重复
 * --------KeySet()返回键值集合
 * 
 * ----利用TreeSet类输出时的自动排序
 * --------利用自带的遍历器iterator（next(),hasNext()）遍历
 * 
 * 
 * 注意：题目简单，但必须注意时间复杂度
 * -----当数据量大时，BufferedReader读入比普通scanner的读入要快
 * 
 */
package problem20170326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Lyinger
 *
 */
public class TelePhoneMemoery {

	public static String replace(String a) {
		for (int i = 0; i < a.length(); i++) {
			if (!Character.isDigit(a.charAt(i))) {
				switch (a.charAt(i)) {
				case 'A':
				case 'B':
				case 'C':
					a = a.substring(0, i) + "2" + a.substring(i+1);
					break;
				case 'D':
				case 'E':
				case 'F':
					a = a.substring(0, i) + "3" + a.substring(i+1);
					break;
				case 'G':
				case 'H':
				case 'I':
					a = a.substring(0, i) + "4" + a.substring(i+1);
					break;
				case 'J':
				case 'K':
				case 'L':
					a = a.substring(0, i) + "5" + a.substring(i+1);
					break;
				case 'M':
				case 'N':
				case 'O':
					a = a.substring(0, i) + "6" + a.substring(i+1);
					break;
				case 'P':
				case 'R':
				case 'S':
					a = a.substring(0, i) + "7" + a.substring(i+1);
					break;
				case 'T':
				case 'U':
				case 'V':
					a = a.substring(0, i) + "8" + a.substring(i+1);
					break;
				case 'W':
				case 'X':
				case 'Y':
					a = a.substring(0, i) + "9" + a.substring(i+1);
					break;
				}
			}

		}
//		System.out.println(a);
		return a;
	}

	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try {
			
			
			int n = Integer.parseInt(bf.readLine());
			for (int i = 0; i < n; i++) {
				String number = TelePhoneMemoery.replace(bf.readLine()
						.replaceAll("-", ""));//读入，并去除“-”，替换字母
				Integer count = map.get(number);
				map.put(number, count == null ? 1 : count + 1);// 利用hashMap不能重复的特性，在读入的同时，计算每个电话号码的重复值
			}
			
			TreeSet<String> sets = new TreeSet<String>(map.keySet());//键值的集合
			boolean hasDuplicate = false;
			for (Iterator<String> i = sets.iterator(); i.hasNext();) {
				String key = i.next();//第一次使用iterator.next()返回的是其第一个元素
				if (map.get(key) > 1) {
					hasDuplicate = true;
					System.out.println(key.substring(0, 3) + "-"
							+ key.substring(3) + " " + map.get(key));
				}
			}
			
			
			if (!hasDuplicate)
				System.out.println("No duplicates.");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// //TIME LIMIT EXCEEDED
	// public static void main(String[] args) {
	// Scanner cin=new Scanner(System.in);
	// int n=cin.nextInt();
	//
	// //读入数据
	// LinkedList<String> numbers=new LinkedList<String>();
	// String[] duplicates=new String[n];//存放有重复值的电话号码
	// int[] duplicateNum=new int[n]; //存放有重复值的电话号码的重复值
	// for(int i=0;i<n;i++){
	// numbers.add(TelePhoneMemoery.replace(cin.next().replaceAll("-",
	// "")));//去除-并将字母转化成对应的数字
	// duplicateNum[i]=0;
	// }
	//
	// int index=0,count=0;
	// String now;
	// while(numbers.size()!=0){//两层循环找相同值
	// index=0;
	// now=numbers.getFirst();
	// numbers.remove(index);
	// for(int i=index;i<numbers.size();i++){
	// if(numbers.get(i).equals(now)){
	// duplicateNum[count]++;
	// numbers.remove(i);
	// i--;
	// }
	//
	// }
	// if(duplicateNum[count]!=0){
	// duplicateNum[count]++;
	// duplicates[count]=now;
	// count++;
	// }
	// }
	//
	// //冒泡排序
	// for(int i=0;i<count-1;i++){
	// for(int j=1;j<count-i;j++){
	// if(Long.parseLong(duplicates[j])<Long.parseLong(duplicates[j-1])){
	// String temp=duplicates[j];
	// duplicates[j]=duplicates[j-1];
	// duplicates[j-1]=temp;
	// int middle=duplicateNum[j];
	// duplicateNum[j]=duplicateNum[j-1];
	// duplicateNum[j-1]=middle;
	// }
	//
	//
	// }
	// }

	// //输出
	// for(int i=0;i<count;i++){
	// System.out.println(duplicates[i].substring(0,
	// 3)+"-"+duplicates[i].substring(3)+" "+duplicateNum[i]);
	// }

	// //没有重复的电话号码时
	// if(count==0)
	// System.out.println("No duplicates.");
	// }

}
