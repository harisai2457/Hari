package com.infinite.java;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MainProg {

	public static void main(String[] args) throws NamingException {
		  HelloRemote service = null;
		    service = 
		    	(HelloRemote) 
		    	new InitialContext().lookup("Hello/Remote");

		    System.out.println(service.sayHello());
		    System.out.println(service.greeting("Prasanna"));
	}
}