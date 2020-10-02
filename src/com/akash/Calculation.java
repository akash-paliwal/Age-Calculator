package com.akash;
import java.util.Calendar;

public class Calculation {
	private int dobMonth, dobDay, dobYear;

	public Calculation( int dobDay, int dobMonth,int dobYear) {
		super();
		this.dobMonth = dobMonth;
		this.dobDay = dobDay;
		this.dobYear = dobYear;
	}

	public int getAge() {
		Calendar today = Calendar.getInstance();
		int curYear = today.get(Calendar.YEAR);

		int age = curYear - dobYear;

		int curMonth = today.get(Calendar.MONTH);

		if (dobMonth > curMonth) { 
			age--;
		} else if (dobMonth == curMonth) { 
			int curDay = today.get(Calendar.DAY_OF_MONTH);

			if (dobDay > curDay) { 
				age--;
			}
		}

		return age;
	}

}
