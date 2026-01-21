package com.globalin.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.globalin.view.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<>();
		mappings.put("/login.do", new LoginController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
