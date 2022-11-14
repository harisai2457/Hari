package com.infinite.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
String sayHello();
String greeting(String name);
}
