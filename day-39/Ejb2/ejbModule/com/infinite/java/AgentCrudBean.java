package com.infinite.java;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;



/**
 * Session Bean implementation class Agent
 */
@Stateless
@Remote(AgentCrudBeanRemote.class)
public class AgentCrudBean implements AgentCrudBeanRemote {

    /**
     * Default constructor. 
     */
    public AgentCrudBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Agent> showAgentBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent searchAgentBean(int AgentId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addAgentBean(Agent agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAgentBean(int AgentId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAgentBean(Agent Agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
