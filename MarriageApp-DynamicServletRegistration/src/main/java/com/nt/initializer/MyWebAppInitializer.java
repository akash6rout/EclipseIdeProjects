package com.nt.initializer;

import java.util.Set;

import com.nt.servlet.MarriageServlet;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MyWebAppInitializer implements ServletContainerInitializer {
	
	static {
		System.out.println("MyWebAppInitializer.static block");
	}
	
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer::0-param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		MarriageServlet servlet=null;
		ServletRegistration.Dynamic dyna=null;
		System.out.println("MyWebAppInitializer.onStartup(-,-)");
		//create our servlet class object
		servlet=new MarriageServlet();
		//register Servlet comp
		dyna=sc.addServlet("ms", servlet);
		//map with url partern
		dyna.addMapping("/marriageurl");
		//enable load on servlet
		dyna.setLoadOnStartup(1);
		
		

	}

}
