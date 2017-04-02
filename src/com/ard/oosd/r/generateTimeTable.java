package com.ard.oosd.r;

import java.util.HashMap;
import java.util.Map.Entry;

public class generateTimeTable {
	public void details(int numberofclass,int numberofrooms,String teachername,HashMap<Integer,String> subjectlist)
	{
		System.out.println(numberofclass+":"+numberofrooms+":"+teachername);
		for(Entry<Integer, String> entry:subjectlist.entrySet())
		{
			System.out.println("\n"+entry.getKey()+":"+entry.getValue());
		}
	}
}
