package com.infinite.java;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.infinite.java.Agent;
import com.infinite.java.AgentCrudBeanRemote;

public class AgentSearchMain {
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No  ");
		empno = sc.nextInt();
		   AgentCrudBeanRemote service = null;
		    service = (AgentCrudBeanRemote)
		    		new InitialContext().lookup("AgentCrudBean/remote");
		Agent agent= service.searchAgentBean(empno);
		if (agent!=null) {
			System.out.println(agent);
		}

	}
}