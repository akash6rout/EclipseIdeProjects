package com.nt.DependencyInjectionTest.java;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.SeasonFinder.SeasonGenerator;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		
		//create the IOC container
		FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		//get target spring bean class obj from the ioc containe
		Object obj=ctx.getBean("smg");
		//string result=obj.generateSeason("month")//using super class
		SeasonGenerator generator=(SeasonGenerator)obj;
		//invoke the b.method
		String result=generator.generateSeason("march");
		System.out.println("Result::"+result);
		
		//close the connection
		ctx.close();

	}

}
