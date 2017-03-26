/**
 * poj 1002
 * �������е���ĸת���ɶ�Ӧ���֣��ټ����ظ���Ŀ
 * 
 * 
 * HashMap�࣬TreeSet��
 * 
 * ----����HashMap���еļ�keyֵ�����ظ�
 * --------KeySet()���ؼ�ֵ����
 * 
 * ----����TreeSet�����ʱ���Զ�����
 * --------�����Դ��ı�����iterator��next(),hasNext()������
 * 
 * 
 * ע�⣺��Ŀ�򵥣�������ע��ʱ�临�Ӷ�
 * -----����������ʱ��BufferedReader�������ͨscanner�Ķ���Ҫ��
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
						.replaceAll("-", ""));//���룬��ȥ����-�����滻��ĸ
				Integer count = map.get(number);
				map.put(number, count == null ? 1 : count + 1);// ����hashMap�����ظ������ԣ��ڶ����ͬʱ������ÿ���绰������ظ�ֵ
			}
			
			TreeSet<String> sets = new TreeSet<String>(map.keySet());//��ֵ�ļ���
			boolean hasDuplicate = false;
			for (Iterator<String> i = sets.iterator(); i.hasNext();) {
				String key = i.next();//��һ��ʹ��iterator.next()���ص������һ��Ԫ��
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
	// //��������
	// LinkedList<String> numbers=new LinkedList<String>();
	// String[] duplicates=new String[n];//������ظ�ֵ�ĵ绰����
	// int[] duplicateNum=new int[n]; //������ظ�ֵ�ĵ绰������ظ�ֵ
	// for(int i=0;i<n;i++){
	// numbers.add(TelePhoneMemoery.replace(cin.next().replaceAll("-",
	// "")));//ȥ��-������ĸת���ɶ�Ӧ������
	// duplicateNum[i]=0;
	// }
	//
	// int index=0,count=0;
	// String now;
	// while(numbers.size()!=0){//����ѭ������ֵͬ
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
	// //ð������
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

	// //���
	// for(int i=0;i<count;i++){
	// System.out.println(duplicates[i].substring(0,
	// 3)+"-"+duplicates[i].substring(3)+" "+duplicateNum[i]);
	// }

	// //û���ظ��ĵ绰����ʱ
	// if(count==0)
	// System.out.println("No duplicates.");
	// }

}
