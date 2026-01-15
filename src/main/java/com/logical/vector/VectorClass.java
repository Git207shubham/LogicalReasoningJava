package com.logical.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorClass {

    /*
    Internally uses an array (like ArrayList)
    All public methods are synchronized
    Thread-safe by default so slow and  inefficient) */

    public static void main1(String[] args)
    {
        Vector<String> cityVector=new Vector();
        /*// not used in modern code and add also works same and universally known
        Makes code look outdated
        Ties code to Vector-only APIs
        Breaks consistency with other collections*/
        cityVector.addElement("pune");
        cityVector.addElement("mumbai");
        cityVector.addElement("nagpur");
        cityVector.addElement("dhule");
        cityVector.addElement("beed");
        //List cityVector=new Vector();
        cityVector.add("nagpur");
        cityVector.add("delhi");


        Iterator itr=cityVector.iterator();
        while(itr.hasNext())
        {
            Object jj=itr.next();
            String h=(String)jj;
            System.out.println(h);
        }

		Enumeration en = cityVector.elements();
		System.out.println(en.nextElement());
		System.out.println(en.hasMoreElements());
    }

}
