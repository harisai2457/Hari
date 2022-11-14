package com.infinite.ejb2;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Employ
 */
@Stateless
@Remote(EmployRemote.class)
public class Employ implements EmployRemote {

    /**
     * Default constructor. 
     */
    public Employ() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayEmploy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String greeting(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
