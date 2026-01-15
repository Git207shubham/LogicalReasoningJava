package com.core.collection.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class College 
{

	public Map<Integer,List<Student>> m1()
{
		Student s=new Student();
		s.setRoll(12);
		s.setName("sdf");
		Student s1=new Student();
		s1.setRoll(13);
		s1.setName("dfasf");
		Student s2=new Student();
		s2.setRoll(543);
		s2.setName("hgfs");
		Student s3=new Student();
		s3.setRoll(543);
		s3.setName("hfgf");
		
		List<Student> l=new ArrayList<>();
		l.add(s);
		l.add(s1);
		List<Student> l2=new ArrayList<>();
		l2.add(s2);
		l2.add(s3);
		
		Map<Integer,List<Student>> m=new LinkedHashMap<>();
		m.put(1,l);
		m.put(2,l2);
		
		return m;
}
	public static void main(String[] args) 
	{
	
		College c=new College();
		Map<Integer,List<Student>> mapp=c.m1();
		
		Set<Integer> s=mapp.keySet();
		System.out.println(s);
		
		Iterator<Integer> itr1=s.iterator();
		while(itr1.hasNext())
		{
			int x=itr1.next();
			
			List<Student> l=mapp.get(x);
			
			Iterator<Student> itr2=l.iterator();
			
			while(itr2.hasNext())
			{
				Student stu=itr2.next();
				System.out.println(stu.getRoll());
				System.out.println(stu.getName());
			}
		}
	}
}
