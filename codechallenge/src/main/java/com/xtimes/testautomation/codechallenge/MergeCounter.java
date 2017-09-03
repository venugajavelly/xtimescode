package com.xtimes.testautomation.codechallenge;

import java.util.LinkedHashMap;
import java.util.Map;

public class MergeCounter 
{
	
	private Map<Integer,Integer> charCountMap=new  LinkedHashMap<>();

	public Map<Integer,Integer> mergeCounter(int[] a,int[] b)
	{
	
		int aLength=a.length;
		int bLength=b.length;
		if((aLength>=10001)||(bLength>=10001))
		{
			System.out.println("exceeded max given input length");
			return charCountMap;
		}
		for(int i=0;(i<aLength)||(i<bLength);i++)
		{
			if(i<aLength)
			charCount(a[i]);
			if(i<bLength)
			charCount(b[i]);
			
		}
		return charCountMap;
	}

	public void charCount(int a)
	{
		if((a>=1)&&(a<=10000))
		{
	
			if(charCountMap.containsKey(a))
			{

				charCountMap.put(a, charCountMap.get(a)+1);
			}
			else
			{

				charCountMap.put(a, 1);
			}
		}
	}

}


	
