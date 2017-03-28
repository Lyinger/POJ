/**
 * poj 1008
 * 玛雅日历——两种日历的转换
 * 
 * 注意：注意边界——TzolKin每年的最后一天，每月的最后一天等
 * 
 */
package problem20170328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Lyinger
 *
 */
public class MayaCalendar {

	private static String[] TzolKinDay={
		"imix","ik","akbal","kan","chicchan",
		"cimi","manik","lamat","muluk","ok",
		"chuen","eb","ben","ix","mem",
		"cib","caban","eznab","canac","ahau"
	};
	
	private static HashMap<String,Integer>  HaabMonth=new HashMap<String,Integer>();
	private static int HaabYear;
	private static int TzolKinYear;
	static{
		HaabYear=20*18+5;
		TzolKinYear=20*13;
		
		HaabMonth.put("pop", 1);
		HaabMonth.put("no", 2);
		HaabMonth.put("zip", 3);
		HaabMonth.put("zotz", 4);
		HaabMonth.put("tzec", 5);
		HaabMonth.put("xul", 6);
		HaabMonth.put("yoxkin", 7);
		HaabMonth.put("mol", 8);
		HaabMonth.put("chen", 9);
		HaabMonth.put("yax", 10);
		HaabMonth.put("zac", 11);
		HaabMonth.put("ceh", 12);
		HaabMonth.put("mac", 13);
		HaabMonth.put("kankin", 14);
		HaabMonth.put("muan", 15);
		HaabMonth.put("pax", 16);
		HaabMonth.put("koyab", 17);
		HaabMonth.put("cumhu", 18);
		HaabMonth.put("uayet", 19);

	}
	
	
	
	public static void main(String[] args) {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		try {
			int n=Integer.parseInt(bf.readLine());

			System.out.println(n);
			int day,month,year,sum;
			for(int i=0;i<n;i++){
				String[] date=bf.readLine().split(" ");
				day=Integer.parseInt(date[0].replace(".", ""))+1;
				month=HaabMonth.get(date[1]);
				year=Integer.parseInt(date[2]);
				
				sum=year*HaabYear+(month-1)*20+day;
				
				year=(sum%TzolKinYear==0)?(sum/TzolKinYear-1):sum/TzolKinYear;
				day=(sum%TzolKinYear%20==0?20:sum%TzolKinYear%20);
				month=(sum%TzolKinYear)%13==0?13:(sum%TzolKinYear)%13;
				
				System.out.println(month+" "+TzolKinDay[day-1]+" "+year);
				
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
