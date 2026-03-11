package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class ClientDemo
{

public static void main(String[] args)
{

Configuration cfg = new Configuration();
cfg.configure();

SessionFactory sf = cfg.buildSessionFactory();
Session s = sf.openSession();

Transaction t = s.beginTransaction();

Scanner sc = new Scanner(System.in);

Hospital h = new Hospital();

System.out.println("Enter Name");
h.setName(sc.nextLine());

System.out.println("Enter Description");
h.setDescription(sc.nextLine());

System.out.println("Enter Date");
h.setDate(sc.nextLine());

System.out.println("Enter Status");
h.setStatus(sc.nextLine());

s.save(h);

t.commit();

System.out.println("Record Inserted");

System.out.println("Enter ID to view");
int id = sc.nextInt();

Hospital h1 = s.get(Hospital.class,id);

System.out.println(h1.getId()+" "+h1.getName()+" "+h1.getDescription()+" "+h1.getDate()+" "+h1.getStatus());

s.close();
sf.close();

}

}