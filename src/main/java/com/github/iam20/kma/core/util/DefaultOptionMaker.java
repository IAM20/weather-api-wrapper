package com.github.iam20.kma.core.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DefaultOptionMaker {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
	private static final SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
	private static Integer defaultBaseDate;
	private static String hour;

	public static void initDefaultValues() {
		Date date = new Date();
		String minute = minuteFormat.format(date);
		hour = hourFormat.format(date);
		defaultBaseDate = Integer.parseInt(dateFormat.format(date));
		int hourInt = Integer.parseInt(hour);

		if (Integer.parseInt(minute) <= 30) {
			hourInt -= 1;
		}

		if (hourInt % 3 == 1) {
			hourInt -= 2;
		} else if (hourInt % 3 == 0) {
			hourInt -= 1;
		}

		if (hourInt < 0) {
			hourInt += 24;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, -1);
			Date yesterday = calendar.getTime();
			defaultBaseDate = Integer.parseInt(dateFormat.format(yesterday));
		}

		if (hourInt < 10) hour = "0" + hourInt + "00";
		else hour = hourInt + "00";
		log.info(hour);
	}

	public static String makeDefaultBaseDate() {
		return defaultBaseDate.toString();
	}

	public static String makeDefaultBaseTime() {
		return hour;
	}
}
