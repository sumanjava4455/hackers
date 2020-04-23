package hackers;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LottoryCoupons {
	
	
private static int getlottery(int lotteryNum) {
		
		int sum = 0;
		while (lotteryNum != 0) {
			sum = sum + lotteryNum % 10;
			System.out.println("check"+sum);
			lotteryNum = lotteryNum / 10;
			System.out.println(lotteryNum);
		}
		return sum;
	}

	public static void main(String[] args)
	{
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the ipvalue");
		int n = s.nextInt();
		
		Map<Integer, Integer> allMap = new HashMap<>();
		
		for (int lotorryNum = 1; lotorryNum <= n; lotorryNum++) {
			int lottorySum = getlottery(lotorryNum);
			if (allMap.containsKey(lottorySum)) {
				
				allMap.put(lottorySum,(new Integer(allMap.get(lottorySum)).intValue() + 1));
			} else {
				allMap.put(lottorySum, new Integer(1));
			}
		}
		System.out.println(allMap);
		int res = 0;
		int maxValue = (Collections.max(allMap.values()));
		for (Entry<Integer, Integer> entry : allMap.entrySet()) {
			if (entry.getValue() == maxValue) {
				res++;
				System.out.println(entry.getKey());
			}
		}
		System.out.println("Final Result \t" + res);
	}

	
	}


