package com.nt.sbeans.SeasonFinder;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("smg")
public class SeasonGenerator {

		private LocalDate date;

		public SeasonGenerator() {
			System.out.println("SeasonGenerator:0-param constructor");
		}

		// Setter method for setter injection
		@Autowired
		public void setDate(LocalDate date) {
			this.date = date;
		}
		

		// b.method
		public String generateSeason(String month) {

			//System.out.println("SeasonGenerator.generateSeason()");

			// get current month of the year
			int month1 = date.getMonthValue();

			// generate the season
			if (month1 >= 3 && month1 <= 6) 
				return "this is winter season";
			 else if (month1 >= 7 && month1 <= 10) 
				return "this is rainy season";
			 else 
				return "this is summer season";
			

		}
	}
