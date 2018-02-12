//Property of Gregory MacEachern
//20011768

import java.util.Scanner;

public class Date {
	private String month;
	private int day;
	private int year; // a four digit number.
	private Scanner keyboard;

	// initial constructor
	public Date() {
		month = "January";
		day = 1;
		year = 1000;
	}

	// Splits the date based on the location of the /'s and sores into integers
	public Date(String str) {
		String[] parts = str.split("/");
		int month = Integer.parseInt(parts[0]);
		int day = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		setDate(month, day, year);
	}

	// constructor for all integers
	public Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year);
	}

	// constructor for when the month is given as a string
	public Date(String monthString, int day, int year) {
		setDate(monthString, day, year);
	}

	// constructor for when only given a year
	public Date(int year) {
		setDate(1, 1, year);
	}

	// copy constructor
	public Date(Date aDate) {
		if (aDate == null)// Not a real date.
		{
			System.out.println("Fatal Error.");
			System.exit(0);
		}

		month = aDate.month;
		day = aDate.day;
		year = aDate.year;
	}

	// mutator for setting the date given all integers.
	public void setDate(int monthInt, int day, int year) {
		if (dateOK(monthInt, day, year)) {
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	// mutator for setting the date given a string as the month
	public void setDate(String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) {
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	// mutator for setting the date given only the year
	public void setDate(int year) {
		setDate(1, 1, year);
	}

	// mutator for setting the year given only the year
	public void setYear(int year) {
		if ((year < 1000) || (year > 9999)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.year = year;
	}

	// mutator for setting the month given only the month
	public void setMonth(int monthNumber) {
		if ((monthNumber <= 0) || (monthNumber > 12)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			month = monthString(monthNumber);
	}

	// mutator for setting the day given only the day
	public void setDay(int day) {
		if ((day <= 0) || (day > 31)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.day = day;
	}

	// accessor for getting the month
	public int getMonth() {
		if (month.equals("January"))
			return 1;
		else if (month.equals("February"))
			return 2;
		else if (month.equalsIgnoreCase("March"))
			return 3;
		else if (month.equalsIgnoreCase("April"))
			return 4;
		else if (month.equalsIgnoreCase("May"))
			return 5;
		else if (month.equals("June"))
			return 6;
		else if (month.equalsIgnoreCase("July"))
			return 7;
		else if (month.equalsIgnoreCase("August"))
			return 8;
		else if (month.equalsIgnoreCase("September"))
			return 9;
		else if (month.equalsIgnoreCase("October"))
			return 10;
		else if (month.equals("November"))
			return 11;
		else if (month.equals("December"))
			return 12;
		else {
			System.out.println("Fatal Error");
			System.exit(0);
			return 0; // Needed to keep the compiler happy
		}
	}

	// accessor for getting the day
	public int getDay() {
		return day;
	}

	// accessor for getting the year
	public int getYear() {
		return year;
	}

	public String toString() {
		return (month + " " + day + ", " + year);
	}

	public boolean equals(Date otherDate) {
		if (otherDate == null)
			return false;
		else
			return ((month.equals(otherDate.month)) && (day == otherDate.day) && (year == otherDate.year));
	}

	// check to see if the entered date is before the entities birthday
	public boolean precedes(Date otherDate) {
		return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
				|| (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
	}

	// function to read the input
	public void readInput() {
		boolean tryAgain = true;
		keyboard = new Scanner(System.in);
		while (tryAgain) {
			System.out.println("Enter the month, the day, and the year in this format (mm/dd/yyyy).");
			System.out.println("Only use numbers and /'s.");
			String inputString = keyboard.next();
			// boolean to check if the entered string is not valid
			boolean proceede = true;

			// initializing the inputs
			int monthInput = 0;
			int dayInput = 0;
			int yearInput = 0;
			// When the user enters quit
			if (inputString.equals("quit")) {
				System.out.println("You Quit The Game");
				System.exit(0);
			}
			// if the input string doesn't contain a '/' it is not valid and sets the
			// boolean above to false, signifying an invalid date
			if (!inputString.contains("/")) {
				proceede = false;
			} else {
				String[] parts = inputString.split("/");
				monthInput = Integer.parseInt(parts[0]);
				dayInput = Integer.parseInt(parts[1]);
				yearInput = Integer.parseInt(parts[2]);
			}
			// the date must be okay and the boolean must be true to be a valid date
			if (dateOK(monthInput, dayInput, yearInput) && proceede == true) {
				setDate(monthInput, dayInput, yearInput);
				tryAgain = false;

			} else
				System.out.println("Illegal date. Reenter input. \n");
		}
	}

	// Checking to see if the date is okay given only integers
	private boolean dateOK(int monthInt, int dayInt, int yearInt) {
		return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
				&& (yearInt <= 9999));
	}

	// Checking to see if the date is okay given a string as the month
	private boolean dateOK(String monthString, int dayInt, int yearInt) {
		return (monthOK(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000) && (yearInt <= 9999));
	}

	// Checking to see if the month is okay given only the month
	private boolean monthOK(String month) {
		return (month.equals("January") || month.equals("February") || month.equals("March") || month.equals("April")
				|| month.equals("May") || month.equals("June") || month.equals("July") || month.equals("August")
				|| month.equals("September") || month.equals("October") || month.equals("November")
				|| month.equals("December"));
	}

	// Converting an integer month number to a string
	private String monthString(int monthNumber) {
		switch (monthNumber) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			System.out.println("Fatal Error");
			System.exit(0);
			return "Error"; // to keep the compiler happy
		}
	}
}
