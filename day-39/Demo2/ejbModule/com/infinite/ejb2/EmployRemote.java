package com.infinite.ejb2;

import javax.ejb.Remote;

@Remote
public interface EmployRemote {
	String sayEmploy();
	String greeting(String name);

}
