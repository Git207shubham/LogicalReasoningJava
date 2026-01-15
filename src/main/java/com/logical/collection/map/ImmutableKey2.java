package com.logical.collection.map;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@Data
@AllArgsConstructor
class Student {
	private int sid;
	private String name;

	@Override
	public int hashCode() {
		return this.getSid();
	}
	// if hashcode return same then only equals gets called
	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		return (this.name == s.name && this.sid == s.sid);
	}

}

public class ImmutableKey2 {

	public static void main(String[] args) {
		Map<Student, Integer> map1 = new HashMap<Student, Integer>();
		Student s1 = new Student(11,"abcd");
		System.out.println(s1.hashCode());
		Student s2 = new Student(44,"xyzw");
		System.out.println(s2.hashCode());
		map1.put(s1, 1111);
		// System.out.println(m.put(s2, 56));
		map1.put(s2, 2222);
		System.out.println(map1.entrySet());

		System.out.println("before changing key : " + map1.get(s1));
		s1.setSid(13);
		System.out.println(map1.entrySet());
		System.out.println("after changing key : " + map1.get(s1));

		Student s3 = new Student(11,"abcd");
		// reached 11 bucket then , existing key was changed to 13 so not equal
		// so return null
		System.out.println(map1.entrySet());
		System.out.println("after changing key back to old: " + map1.get(s3));


		keyMutableExample();
	}

	public static void keyMutableExample() {

		Map map = new HashMap();

		StringBuilder sb1 = new StringBuilder("sb1_key");

		map.put(sb1, "value1");
		System.out.println(sb1+" : "+sb1.hashCode()+" : "+map.get(sb1));

		sb1.append("_new");
		System.out.println(sb1+" : "+sb1.hashCode()+" : "+map.get(sb1));

		// if practical scenario ..we dont use same reference
		// we create new object of stringbuilder with same content ,

		// different hashcode for same content as hashcode is not implemented so diff bucket
		StringBuilder sbOld = new StringBuilder("sb1_key");
		System.out.println("Fecth with old StringBuilder : "+sbOld.hashCode()+" : "+map.get(sbOld));

		// different hashcode for same content as hashcode is not implemented so diff bucket
		StringBuilder sbNew = new StringBuilder("sb1_key_new");
		System.out.println("Fecth with updated  StringBuilder : "+sbNew.hashCode()+" : "+map.get(sbNew));

		//

		String key1 = new String("string1_key");
		map.put(key1, "string_value");
		System.out.println("Fecth with existing String object reference: "+key1+" : "+key1.hashCode()+" : "+map.get(key1));

		key1 = key1.concat("_new");
		System.out.println("Fecth with updated String object reference : "+key1+" : "+key1.hashCode()+" : "+map.get(key1));

		String key2 = "string1_key";
		System.out.println("Fecth with original String : "+key2+" : "+key2.hashCode()+" : "+map.get(key2));

		String key3 = "string1_key_new";
		System.out.println("Fecth with original String : "+key3+" : "+key3.hashCode()+" : "+map.get(key3));


		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		Integer i = 12;
		Integer ii = 13;
		m.put(i, 122);
		m.put(ii, 133);

		System.out.println(ii.hashCode()+" : "+m.get(ii));
		ii = 14;
		// created new variable and ii now refers to new object so new hashcode
		System.out.println(ii.hashCode()+" : "+m.get(ii));
		// searches in different bucket

		Integer ii2=13;
		System.out.println(ii2.hashCode()+" : "+m.get(ii2));
		// searches in same bucket and calls equals to check hashcode
		// earlier hashcode of ii was 13 and hashcode of ii is 13
		// so matches and fetches value

	}

}
