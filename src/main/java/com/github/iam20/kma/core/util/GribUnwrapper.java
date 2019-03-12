package com.github.iam20.kma.core.util;

import com.github.iam20.kma.core.NewSky;
import com.github.iam20.kma.core.ForecastGrib;
import com.github.iam20.kma.core.model.ForecastGribWrapper;
import com.github.iam20.kma.core.model.grib.ForecastGribBody;
import com.github.iam20.kma.core.model.grib.ForecastGribHeader;
import com.github.iam20.kma.core.model.grib.ForecastGribItem;

import java.util.List;

public class GribUnwrapper {
	public static ForecastGrib unwrap(ForecastGribWrapper gribData) {
		ForecastGrib data = new ForecastGrib();
		ForecastGribHeader header = gribData.getResponse().getHeader();
		if (!header.getResultCode().equals("0000")) {
			return data;
		}
		ForecastGribBody body = gribData.getResponse().getBody();
		List<ForecastGribItem> items = body.getItems().getItem();
		for (ForecastGribItem item : items) {
			switch (item.getCategory()) {
				case NewSky.TEMPERATURE :
					data.setTemperature(item.getObsrValue());
					break;
				case NewSky.RAIN_PER_HOUR :
					data.setRainPerHour(item.getObsrValue());
					break;
				case NewSky.EAST_WEST_WIND :
					data.setEastWestWind(item.getObsrValue());
					break;
				case NewSky.SOUTH_NORTH_WIND :
					data.setSouthNorthWind(item.getObsrValue());
					break;
				case NewSky.HUMIDITY :
					data.setHumidity(item.getObsrValue());
					break;
				case NewSky.RAIN_TYPE :
					data.setRainType(item.getObsrValue().intValue());
					break;
				case NewSky.WIND_VECTOR :
					data.setWindVector(item.getObsrValue());
					break;
				case NewSky.WIND_SPEED :
					data.setWindSpeed(item.getObsrValue());
					break;
			}
		}
		return data;
	}
}
