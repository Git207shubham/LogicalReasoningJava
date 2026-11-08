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

    // named main1, so the IDE will NOT run it - rename to main to run this example
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


        // raw Iterator (no <String>) returns Object, so a cast is needed
        // Iterator<String> itr would avoid the cast
        Iterator itr=cityVector.iterator();
        while(itr.hasNext())
        {
            Object jj=itr.next();
            String h=(String)jj;
            System.out.println(h);
        }

		// Enumeration = legacy (pre-Iterator) cursor, only for Vector/Hashtable; read-only, no remove()
		Enumeration en = cityVector.elements();
		System.out.println(en.nextElement());
		System.out.println(en.hasMoreElements());
    }

}
