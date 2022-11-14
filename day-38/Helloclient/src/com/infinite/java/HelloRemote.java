package com.infinite.java;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
String sayHello();
String greeting(String name);
}
