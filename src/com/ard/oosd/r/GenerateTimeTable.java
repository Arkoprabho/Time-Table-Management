package com.ard.oosd.r;
//gives numberofrooms,numberofsection,teacher-subject realtion
import java.util.HashMap;
import java.util.Map.Entry;

public class GenerateTimeTable {
	public void details(int numberofclass,int numberofrooms,HashMap<String,String[]> subjectlist)
	{
		System.out.println(numberofclass+":"+numberofrooms);
		for(Entry<String, String[]> entry:subjectlist.entrySet())
		{
			String s[]=entry.getValue();
			System.out.println(entry.getKey());
			for(int i=0;i<100;i++)
				if(s[i]!=null)
			System.out.println("\n"+":"+s[i]);
		}
	}
}
