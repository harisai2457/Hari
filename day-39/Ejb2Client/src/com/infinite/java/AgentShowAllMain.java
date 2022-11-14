package com.infinite.java;

import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AgentShowAllMain {
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		   AgentCrudBeanRemote service = null;

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    service = (AgentCrudBeanRemote)
		    		new InitialContext().lookup("AgentCrudBean/remote");

		    List<Agent> agentList = service.showAgentBean();
		    for (Agent agent : agentList) {
				System.out.println(agent);
			}
	}
}