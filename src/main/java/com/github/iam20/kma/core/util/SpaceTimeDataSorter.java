package com.github.iam20.kma.core.util;

import com.github.iam20.kma.core.SpaceTimeData;

import java.util.Collections;
import java.util.List;

class SpaceTimeDataSorter {
	static List<? extends SpaceTimeData> sortSpaceTimeData(List<? extends SpaceTimeData> data) {
		Collections.sort(data, (left, right) -> {
			if (left.getForecastDate().equals(right.getForecastDate())) {
				return left.getForecastTime().compareTo(right.getForecastTime());
			} else {
				return left.getForecastDate().compareTo(right.getForecastDate());
			}
		});
		return data;
	}
}
