package cs.hanyang.stu.kma.core;

import cs.hanyang.stu.kma.core.api.ApiExecutor;
import cs.hanyang.stu.kma.core.model.ForecastGribWrapper;
import cs.hanyang.stu.kma.core.model.ForecastSpaceTimeWrapper;
import cs.hanyang.stu.kma.core.util.GribUnwrapper;
import cs.hanyang.stu.kma.core.util.SpaceDataUnwrapper;
import cs.hanyang.stu.kma.core.util.TimeDataUnwrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewSky {
	public static final String TYPE_JSON = "json";
	public static final String TYPE_XML = "xml";

	public static final String OPERATION_GRIB = "ForecastGrib";
	public static final String OPERATION_SPACE_DATA = "ForecastSpaceData";
	public static final String OPERATION_TIME_DATA = "ForecastTimeData";
	public static final String OPERATION_VERSION_CHECK = "ForecastVersionCheck";

	public static final String F_TYPE_GRIB = "ODAM";
	public static final String F_TYPE_SPACE = "SHRT";
	public static final String F_TYPE_TIME = "VSRT";

	public static final String PERCENT_OF_RAIN = "POP";
	public static final String RAIN_PER_SIX_HOUR = "R06";
	public static final String SNOW_PER_SIX_HOUR = "S06";
	public static final String TEMPERATURE_OF_THREE_HOUR = "T3H";
	public static final String MIN_TEMPERATURE = "TMN";
	public static final String MAX_TEMPERATURE = "TMX";
	public static final String WAVE_HEIGHT = "WAV";

	/* Below is for grib and time data.*/
	public static final String TEMPERATURE = "T1H";
	public static final String RAIN_PER_HOUR = "RN1";
	public static final String EAST_WEST_WIND = "UUU";
	public static final String SOUTH_NORTH_WIND = "VVV";
	public static final String HUMIDITY = "REH";
	public static final String RAIN_TYPE = "PTY";
	public static final String WIND_VECTOR = "VEC";
	public static final String WIND_SPEED = "WSD";
	public static final String SKY = "SKY";
	public static final String THUNDER = "LGT";

	public static final Integer NO_RAIN = 1;
	public static final Integer RAIN = 2;
	public static final Integer RAIN_SNOW = 3;
	public static final Integer SNOW = 4;

	private static final String SKY_URL = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/";

	public static final Integer OPERATION_ROW_SIZE = 14;

	private String operation = OPERATION_SPACE_DATA;
	private String serviceKey;
	private String baseDate;
	private String baseTime;
	private String nx;
	private String ny;
	private String numOfRows;
	private String pageNo;
	private String type = TYPE_JSON;
	private String baseDateTime;
	private String fType;

	public void setBaseDate(int baseDate) {
		this.baseDate = Integer.toString(baseDate);
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public void setBaseTime(int baseTime) {
		this.baseTime = Integer.toString(baseTime);
	}

	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}

	public void setNx(int nx) {
		this.nx = Integer.toString(nx);
	}

	public void setNx(String nx) {
		this.nx = nx;
	}

	public void setNy(int ny) {
		this.ny = Integer.toString(ny);
	}

	public void setNy(String ny) {
		this.ny = ny;
	}

	public void setNumOfRows(int numOfRows) {
		this.numOfRows = Integer.toString(numOfRows);
	}

	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = Integer.toString(pageNo);
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setType(String type) {
		if (type.equals(TYPE_JSON)) {
			this.type = TYPE_JSON;
		} else if (type.equals(TYPE_XML)) {
			this.type = TYPE_XML;
		} else {
			this.type = TYPE_JSON;
		}
	}

	public String makeUrl() {
		return SKY_URL + operation + "?serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime
				+ "&nx=" + nx + "&ny=" + ny + "&numOfRows=" + numOfRows + "&pageNo=" + pageNo + "&_type=" + type;
	}

	public ForecastGrib forecastGrib() {
		operation = OPERATION_GRIB;
		ForecastGribWrapper data = ApiExecutor.executeApi(makeUrl(), ForecastGribWrapper.class);
		return GribUnwrapper.unwrap(data);
	}

	public List<ForecastSpaceData> forecastSpaceData() {
		operation = OPERATION_SPACE_DATA;
		ForecastSpaceTimeWrapper data = ApiExecutor.executeApi(makeUrl(), ForecastSpaceTimeWrapper.class);
		return SpaceDataUnwrapper.unwrap(data);
	}

	public List<ForecastTimeData> forecastTimeData() {
		operation = OPERATION_TIME_DATA;
		ForecastSpaceTimeWrapper data = ApiExecutor.executeApi(makeUrl(), ForecastSpaceTimeWrapper.class);
		return TimeDataUnwrapper.unwrap(data);
	}
}
