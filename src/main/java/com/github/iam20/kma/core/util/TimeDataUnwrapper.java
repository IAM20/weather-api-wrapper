package com.github.iam20.kma.core.util;

import com.github.iam20.kma.core.ForecastTimeData;
import com.github.iam20.kma.core.NewSky;
import com.github.iam20.kma.core.model.ForecastSpaceTimeWrapper;
import com.github.iam20.kma.core.model.space.ForecastSpaceBody;
import com.github.iam20.kma.core.model.space.ForecastSpaceHeader;
import com.github.iam20.kma.core.model.space.ForecastSpaceItem;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class TimeDataUnwrapper {
	private static List<ForecastTimeData> sortTimeData(List<ForecastTimeData> data) {
		Collections.sort(data, (left,  right) -> {
			if (left.getForecastDate().equals(right.getForecastDate())) {
				return left.getForecastTime().compareTo(right.getForecastTime());
			} else {
				return left.getForecastDate().compareTo(right.getForecastDate());
			}
		});
		return data;
	}

	public static List<ForecastTimeData> unwrap(ForecastSpaceTimeWrapper timeData) {
		Map<Pair<Integer, String>, ForecastTimeData> dataMap = new HashMap<>();
		ForecastSpaceBody body = timeData.getResponse().getBody();

		ForecastSpaceHeader header = timeData.getResponse().getHeader();
		if (!header.getResultCode().equals("0000")) {
			return new ArrayList<>();
		}
		List<ForecastSpaceItem> items = body.getItems().getItem();
		MutablePair<Integer, String> key = new MutablePair<>();
		ForecastTimeData value;
		for (ForecastSpaceItem item : items) {
			key.setLeft(item.getFcstDate());
			key.setRight(item.getFcstTime());
			value = dataMap.get(key);
			if (value == null) {
				value = new ForecastTimeData();
				value.setForecastDate(item.getFcstDate());
				value.setForecastTime(item.getFcstTime());
			}

			Double fcstValue = item.getFcstValue();
			switch (item.getCategory()) {
				case NewSky.TEMPERATURE :
					value.setTemperature(fcstValue);
					break;
				case NewSky.RAIN_PER_HOUR :
					value.setRainPerHour(fcstValue);
					break;
				case NewSky.EAST_WEST_WIND :
					value.setEastWestWind(fcstValue);
					break;
				case NewSky.SOUTH_NORTH_WIND :
					value.setSouthNorthWind(fcstValue);
					break;
				case NewSky.HUMIDITY :
					value.setHumidity(fcstValue);
					break;
				case NewSky.RAIN_TYPE :
					value.setRainType(fcstValue.intValue());
					break;
				case NewSky.WIND_VECTOR :
					value.setWindVector(fcstValue);
					break;
				case NewSky.WIND_SPEED :
					value.setWindSpeed(fcstValue);
					break;
				case NewSky.SKY:
					value.setSky(fcstValue.intValue());
					break;
				case NewSky.THUNDER:
					value.setThunder(fcstValue.intValue());
					break;
			}
			dataMap.put(key, value);
		}
		return sortTimeData(new ArrayList<>(dataMap.values()));
	}
}
