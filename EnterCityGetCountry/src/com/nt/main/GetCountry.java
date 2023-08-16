package com.nt.main;

import java.util.Iterator;
import java.util.Scanner;

public class GetCountry {

	public static void main(String[] args) {
		String arr[]= {
				"INDIA","PAKISTAN","CHINA","AFGANISTAN","AMERICA"
		};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Capital Name:::");
		String ch=sc.nextLine();
	
		switch (ch) {
		case "delhi":
			System.out.println("INDIA");
			break;

		default:
			System.out.println("Not Found");
			break;
		}
	}

}
