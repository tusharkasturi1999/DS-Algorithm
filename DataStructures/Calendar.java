package DataStructures;

public class Calendar {

	/**
	 * @param month=month between 0 to 11
	 * @param year        is the year of which calendar is to be displayed
	 */
	public static void calendar(int month, int year) {

		int month1, x, day = 1, day1, year1;

		int[][] totalDays = new int[5][7]; // 5 rows to show weeks,7 columns specify days in week

		// Following mathematics operation is to generate the day of week using
		// Gregorian calendar.
		year1 = year - (14 - month) / 12;
		x = year1 + (year1 / 4) - (year1 / 100) + (year1 / 400);
		month1 = month + 12 * ((14 - month) / 12) - 2;
		day1 = (day + x + (31 * month1) / 12) % 7;

		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] dayName = { "S", "M", "T", "W", "T", "F", "S" };
		int monthDay = 0;

		// check if year is leap or not
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthDays[1] = 29;
		}

		for (int i = 0; i < monthDays.length; i++) {
			if (i == month - 1) {
				monthDay = monthDays[i];
			}
		}

		int z = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 0 && j < day1) {
					totalDays[i][j] = -1;
				} else if (z <= monthDay) {
					totalDays[i][j] = z;
					z++;
				} else {
					totalDays[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			if (month == i + 1) {
				System.out.print(monthName[i] + " " + year);
			}
		}
		System.out.println();

		for (int i = 0; i < 7; i++) {
			System.out.print(dayName[i] + "  ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if (totalDays[i][j] != -1) {
					if (totalDays[i][j] < 10)
						System.out.print(totalDays[i][j] + "  ");
					else
						System.out.print(totalDays[i][j] + " ");
				} else
					System.out.print("   ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		Calendar.calendar(month, year);
	}

}