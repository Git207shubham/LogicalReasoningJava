package com.core.multithreading.multithreading.singleton1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

// Java based hibernate configuration
// Singleton design pattern for SessionFactory

public class HibernateUtil implements Runnable {
	private static SessionFactory sf = null;
	private static StandardServiceRegistry registry;

	public static   SessionFactory getSessionfactory() {
		
		if(sf==null)
		{	
		
		synchronized(HibernateUtil.class)
		{
		System.out.println("enter--thread name : " + Thread.currentThread().getName());
		if (sf == null) {
			try {
				Map<String, Object> map = new HashMap<>();
				// Connection properties
				map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				map.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatecache1");
				map.put(Environment.USER, "root");
				map.put(Environment.PASS, "root");

				// hibernate properties
				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				map.put(Environment.HBM2DDL_AUTO, "update");

				map.put(Environment.SHOW_SQL, true);

				registry = new StandardServiceRegistryBuilder().applySettings(map).build();
				MetadataSources mds = new MetadataSources(registry);


				Metadata md = mds.getMetadataBuilder().build();

				sf = md.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		}
//		System.out.println(sf);
//
		System.out.println("exit" + Thread.currentThread().getName()+"  "+sf);
		return sf;
	}

	@Override
	public void run() {

		getSessionfactory();
		System.out.println("session factory : "+sf+"  "+Thread.currentThread().getName());

	}

}

class Test1 {
	public static void main(String[] args) throws Exception{

		// mulTIthreading sinlgeton DP

		HibernateUtil hu = new HibernateUtil();

		Thread thread1= new Thread(hu);
		Thread thread2= new Thread(hu);

		thread1.start();
		thread2.start();




		// Thread.sleep(20000);
		SessionFactory sf = HibernateUtil.getSessionfactory();
		System.out.println("session factory one : " + sf);

		// to check singleton design pattern
//		SessionFactory sf2 = HibernateUtil.getSessionfactory();
//		System.out.println("session factory two : " + sf2);
//
//
//		Session session1 = sf.openSession();
//
//		Student stu = session1.load(Student.class,1);
//		System.out.println("student 1 : " + stu);
//
//		// no query will be fired becoz this resource is present in session1 cache
//		Student stu1 = session1.get(Student.class,1);
//		System.out.println("student 1 : " + stu1);
//
//		Student stu2 = session1.get(Student.class,1);
//		System.out.println("student 1 : " + stu2);
//
//		Session session2 = HibernateUtil.getSessionfactory().openSession();
//
//		//// new query will be fired for this new session
//		Student stu3 = session2.get(Student.class, 1);

		// no query will be fired becoz this resource is present in session_2 cache
//		Student stu4 = session2.get(Student.class, 1);
	}
}
