package com.infinite.java;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AgentCrudBeanRemote {
	List<Agent> showAgentBean() throws ClassNotFoundException, SQLException;
	Agent searchAgentBean(int AgentId) throws ClassNotFoundException, SQLException;
	String addAgentBean(Agent agent) throws ClassNotFoundException, SQLException;;
	String deleteAgentBean(int AgentId) throws ClassNotFoundException, SQLException;;
	String updateAgentBean(Agent Agent) throws ClassNotFoundException, SQLException;;

}



