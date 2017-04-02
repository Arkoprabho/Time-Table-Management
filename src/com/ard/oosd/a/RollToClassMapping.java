package com.ard.oosd.a;

public class RollToClassMapping {
	public String branch(int br)
	{
		String st = null;
		if(br==5)
		{
			st="CSE";
		}
		else if(br==6)
		{
			st="IT";
		}
		return st;
	}
	public int year(int n)
	{
		int yr=0;
		if(n==13)
		{
			yr=4;
		}
		else if(n==14)
		{
			yr=3;
		}
		else if(n==15)
		{
			yr=2;
		}
		else if(n==16)
		{
			yr=1;
		}
		return yr;
	}
	public String map(int rollnum)
	{
		int yr,n=rollnum;
		String br=null;
		n=n/1000;
		br=branch(n%100);
		System.out.println(br);
		n=n/100;
		yr=year(n);
		System.out.println(yr);
		String className = null;
		if(rollnum>=1405000 && rollnum<=1405070)
		{
			className="CS1";
		}
		else if(rollnum>=1405071 && rollnum<=1405137)
		{
			className="CS2";
		}
		else if(rollnum>=1405137 && rollnum<=1405203)
		{
			className="CS3";
		}
		else if(rollnum>=1405204 && rollnum<=1405270)
		{
			className="CS4";
		}
		else if(rollnum>=1405271 && rollnum<=1405340)
		{
			className="CS5";
		}
		else if(rollnum>=1405341 && rollnum<=1405410)
		{
			className="CS6";
		}
		else if(rollnum>=1405411 && rollnum<=1405480)
		{
			className="CS7";
		}
		else if(rollnum>=1405481 && rollnum<=140550)
		{
			className="CS8";
		}
		return className;
	}
	
}
