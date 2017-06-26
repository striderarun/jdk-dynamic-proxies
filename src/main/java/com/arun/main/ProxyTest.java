package com.arun.main;

import java.lang.reflect.Proxy;

import com.arun.proxy.LogExecutionTimeProxy;
import com.arun.service.MessageService;
import com.arun.service.impl.MessageServiceImpl;

public class ProxyTest {

	public static void main(String[] args) {
		MessageService messageService = new MessageServiceImpl();
		// Create the proxy
		MessageService proxy = (MessageService) Proxy.newProxyInstance(MessageService.class.getClassLoader(), 
	        		messageService.getClass().getInterfaces(), new LogExecutionTimeProxy(messageService));

	    // Invoke the target instance method through the proxy
	    String result = proxy.getMessage();
	    System.out.println("Result: " + result);
	}

}
