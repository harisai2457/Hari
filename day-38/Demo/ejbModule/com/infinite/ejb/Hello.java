package com.infinite.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Hello
 */
@Stateless
@Remote(HelloRemote.class)
public class Hello implements HelloRemote {

    /**
     * Default constructor. 
     */
    public Hello() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String greeting(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
