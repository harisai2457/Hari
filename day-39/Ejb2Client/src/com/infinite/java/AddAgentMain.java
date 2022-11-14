package com.infinite.java;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.validator.jtype.Generic;

public class AddAgentMain {

	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Agent agent = new Agent();
		System.out.println("Enter AgentId");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter Name  ");
		agent.setName(sc.next());
		System.out.println("Enter City  ");
		agent.setCity(sc.next());
		System.out.println("Enter Gender ");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Premium  ");
		agent.setPrimium(sc.nextDouble());
		  AgentCrudBeanRemote service = null;
		    service = (AgentCrudBeanRemote)
		    		new InitialContext().lookup("AgentCrudBean/remote");
		    System.out.println(service.addAgentBean(agent));
	}
}