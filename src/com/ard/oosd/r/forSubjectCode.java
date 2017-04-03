package com.ard.oosd.r;

import java.util.HashMap;
import java.util.Map.Entry;

public class forSubjectCode {
	public void details(HashMap<Integer, String> subjectskey)
	{
		for(Entry<Integer, String> entry:subjectskey.entrySet())
		{
			System.out.println(entry.getValue()+" "+entry.getKey());
		}
	}

}
