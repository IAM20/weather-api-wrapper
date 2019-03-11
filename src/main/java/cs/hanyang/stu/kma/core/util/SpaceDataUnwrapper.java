package cs.hanyang.stu.kma.core.util;

import java.util.*;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import static cs.hanyang.stu.kma.core.NewSky.*;

import cs.hanyang.stu.kma.core.ForecastSpaceData;
import cs.hanyang.stu.kma.core.model.ForecastSpaceTimeWrapper;
import cs.hanyang.stu.kma.core.model.space.ForecastSpaceBody;
import cs.hanyang.stu.kma.core.model.space.ForecastSpaceHeader;
import cs.hanyang.stu.kma.core.model.space.ForecastSpaceItem;

public class SpaceDataUnwrapper {
	private static List<ForecastSpaceData> sortSpaceData(List<ForecastSpaceData> data) {
		Collections.sort(data, (left, right) -> {
			if (left.getForecastDate().equals(right.getForecastDate())) {
				return left.getForecastTime().compareTo(right.getForecastTime());
			} else {
				return left.getForecastDate().compareTo(right.getForecastDate());
			}
		});
		return data;
	}

	public static List<ForecastSpaceData> unwrap(ForecastSpaceTimeWrapper spaceData) {
		Map<Pair<Integer, String>, ForecastSpaceData> dataMap = new HashMap<>();
		ForecastSpaceHeader header = spaceData.getResponse().getHeader();
		if (!header.getResultCode().equals("0000")) {
			return new ArrayList<>();
		}

		ForecastSpaceBody body = spaceData.getResponse().getBody();
		MutablePair<Integer, String> key = new MutablePair<>();
		ForecastSpaceData value;
		List<ForecastSpaceItem> items = body.getItems().getItem();
		for(ForecastSpaceItem item : items) {
			key.setLeft(item.getFcstDate());
			key.setRight(item.getFcstTime());
			value = dataMap.get(key);
			if(value == null) {
				value = new ForecastSpaceData();
				value.setForecastDate(item.getFcstDate());
				value.setForecastTime(item.getFcstTime());
			}
			Double fcstValue = item.getFcstValue();
			switch (item.getCategory()) {
				case PERCENT_OF_RAIN:
					value.setPercentOfRain(fcstValue);
					break;
				case RAIN_TYPE:
					value.setRainType(fcstValue.intValue());
					break;
				case RAIN_PER_SIX_HOUR:
					value.setRainPerSixHour(fcstValue);
					break;
				case HUMIDITY:
					value.setHumidity(fcstValue);
					break;
				case SNOW_PER_SIX_HOUR:
					value.setSnowPerSixHour(fcstValue);
					break;
				case SKY:
					value.setSky(fcstValue.intValue());
					break;
				case TEMPERATURE_OF_THREE_HOUR:
					value.setTemperatureOfThreeHour(fcstValue);
					break;
				case MIN_TEMPERATURE:
					value.setMinTemperature(fcstValue);
					break;
				case MAX_TEMPERATURE:
					value.setMaxTemperature(fcstValue);
					break;
				case EAST_WEST_WIND:
					value.setEastWestWind(fcstValue);
					break;
				case SOUTH_NORTH_WIND:
					value.setSouthNorthWind(fcstValue);
					break;
				case WAVE_HEIGHT:
					value.setWaveHeight(fcstValue);
					break;
				case WIND_VECTOR:
					value.setWindVector(fcstValue);
					break;
				case WIND_SPEED:
					value.setWindSpeed(fcstValue);
					break;
			}
			dataMap.put(key, value);
		}
		return sortSpaceData(new ArrayList<>(dataMap.values()));
	}
}
