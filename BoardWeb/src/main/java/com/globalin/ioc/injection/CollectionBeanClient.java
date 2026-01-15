package com.globalin.ioc.injection;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean"); 
		// List<String> addressList = bean.getAddressList();
		// Set<String> addressList = bean.getAddressList();
		// Map<String, String> addressList = bean.getAddressList();
		Properties addressList = bean.getAddressList();
		
		for (String key: addressList.stringPropertyNames()) {
			System.out.println(String.format("키: %s, 값: %s", key, addressList.get(key)));
		}
		
		factory.close();
	}
}
