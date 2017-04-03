package com.ard.oosd.r;

import java.util.HashMap;
import java.util.Map.Entry;

public class generateTimeTable {
	public void details(int numberofclass,int numberofrooms,HashMap<String,String[]> subjectlist)
	{
		System.out.println(numberofclass+":"+numberofrooms);
		for(Entry<String, String[]> entry:subjectlist.entrySet())
		{
			String s[]=entry.getValue();
			for(int i=0;i<100;i++)
				if(s[i]!=null)
			System.out.println("\n"+entry.getKey()+":"+s[i]);
		}
	}
}
