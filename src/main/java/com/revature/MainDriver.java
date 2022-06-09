package com.revature;

import com.revature.controller.RequestMapping;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(7465);
		
		RequestMapping.configureRoutes(app);
	}
}
