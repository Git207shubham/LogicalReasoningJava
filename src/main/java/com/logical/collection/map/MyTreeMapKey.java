package com.logical.collection.map;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.TreeMap;

// we want iy to use as key and so it will be compared acc to hashcode or given by us
// compareTo will be called if hashcode return true otherwise not called
@Data
@AllArgsConstructor
public class MyTreeMapKey implements Comparable<MyTreeMapKey> {

    private int sid;
    private String name;

    // it sort as well so it need this compareTo method
    // HashMap dont sort so it needs equals and hashcode only
    @Override
    public int compareTo(MyTreeMapKey o) {
        int flag = o.sid - this.sid;
        System.out.println(o + " : " + flag);
        return flag;
    }

//	@Override
//	public int compare(Student o1, Student o2) {
//
//		return o1.getName().compareTo(o2.getName());
//	}

//	@Override
//	public int hashCode() {
//
//		return this.getSid();
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//
//		Student s = (Student) obj;
//
//		return (this.name == s.name && this.sid == s.sid);
//
//	}
}

@Data
@AllArgsConstructor
class MyHashMapKey {
    private int sid;
    private String name;

    @Override
    public int hashCode() {

        return this.getSid();
    }


    @Override
    public boolean equals(Object obj) {
		MyHashMapKey hmkey =(MyHashMapKey)obj;
		boolean flag = (this.name.equals(hmkey.name) && this.sid == hmkey.sid );
        return flag;

    }
}

class TestTreeMaKey {
    public static void main(String args[]) {
        TreeMap<MyTreeMapKey, String> map = new TreeMap<>();
        map.put(new MyTreeMapKey(10, "shubham"), "A");
        map.put(new MyTreeMapKey(10, "shubham"), "B");
        System.out.println(map);

		HashMap<MyHashMapKey, String> map2= new HashMap<>();
		map2.put(new MyHashMapKey(10, "shubham"), "A");
		map2.put(new MyHashMapKey(10, "piyush"), "F");
		map2.put(new MyHashMapKey(15, "sagar"), "F");
		map2.put(new MyHashMapKey(10, "shubham"), "B");
		System.out.println(map2);
    }
}

