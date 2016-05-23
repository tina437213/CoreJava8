package edu.dtorres.corejava8.cp2;

import java.time.LocalDate;

/**
 * 
 * Change the calendar printing program so it starts the week on a Sunday. Also
 * make it print a newline at the end (but only one).
 * 
 * @author diego
 *
 */
public class Ex01 {
	public static void main(String... args){
		LocalDate date = LocalDate.of(2016, 05, 1);
		System.out.println("********** MAY 2016 *********");
		System.out.println("  Sun Mon Tue Wed Thu Fri Sat");
		
		int dow = date.getDayOfWeek().getValue();
		if(dow != 7){
			for(int i = 1; i<dow;i++){
				System.out.print("    ");
			}
		}
		while(date.getMonthValue() == 5){
			System.out.printf("%4d", date.getDayOfMonth());
			if(date.getDayOfWeek().getValue() == 6)
				System.out.println();
			date = date.plusDays(1);
		}
		
		dow = date.getDayOfWeek().getValue();
		if(dow != 6){
			System.out.println();
		}
		System.out.println("*****************************");
		
	}
	
}
