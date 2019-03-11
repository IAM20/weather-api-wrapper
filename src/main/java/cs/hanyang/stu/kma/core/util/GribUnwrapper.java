package cs.hanyang.stu.kma.core.util;

import static cs.hanyang.stu.kma.core.NewSky.*;

import cs.hanyang.stu.kma.core.ForecastGrib;
import cs.hanyang.stu.kma.core.model.ForecastGribWrapper;
import cs.hanyang.stu.kma.core.model.grib.ForecastGribBody;
import cs.hanyang.stu.kma.core.model.grib.ForecastGribHeader;
import cs.hanyang.stu.kma.core.model.grib.ForecastGribItem;

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
				case TEMPERATURE :
					data.setTemperature(item.getObsrValue());
					break;
				case RAIN_PER_HOUR :
					data.setRainPerHour(item.getObsrValue());
					break;
				case EAST_WEST_WIND :
					data.setEastWestWind(item.getObsrValue());
					break;
				case SOUTH_NORTH_WIND :
					data.setSouthNorthWind(item.getObsrValue());
					break;
				case HUMIDITY :
					data.setHumidity(item.getObsrValue());
					break;
				case RAIN_TYPE :
					data.setRainType(item.getObsrValue().intValue());
					break;
				case WIND_VECTOR :
					data.setWindVector(item.getObsrValue());
					break;
				case WIND_SPEED :
					data.setWindSpeed(item.getObsrValue());
					break;
			}
		}
		return data;
	}
}
