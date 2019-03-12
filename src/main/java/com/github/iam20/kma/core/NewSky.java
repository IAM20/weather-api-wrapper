package com.github.iam20.kma.core;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import com.github.iam20.kma.core.api.ApiExecutor;
import com.github.iam20.kma.core.model.ForecastGribWrapper;
import com.github.iam20.kma.core.model.ForecastSpaceTimeWrapper;
import com.github.iam20.kma.core.util.DefaultOptionMaker;
import com.github.iam20.kma.core.util.GribUnwrapper;
import com.github.iam20.kma.core.util.SpaceDataUnwrapper;
import com.github.iam20.kma.core.util.TimeDataUnwrapper;

@Slf4j
@Data
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

	public static final Integer THUNDER_NO = 0;
	public static final Integer THUNDER_LOW = 1;
	public static final Integer THUNDER_MID = 2;
	public static final Integer THUNDER_HIGH = 3;

	private static final String SKY_URL = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/";
	private static final String DEFAULT_NX = "60";
	private static final String DEFAULT_NY = "127";
	private static final String DEFAULT_NUM_OF_ROWS = "1024";
	private static final String DEFAULT_PAGE_NUM = "1";

	public static final Integer OPERATION_ROW_SIZE = 14;


	private final String type;

	private String operation;
	private String serviceKey;
	private String baseDate;
	private String baseTime;
	private String nx;
	private String ny;
	private String numOfRows;
	private String pageNo;
	private String baseDateTime;
	private String fType;

	public NewSky() {
		DefaultOptionMaker.initDefaultValues();
		baseDate = DefaultOptionMaker.makeDefaultBaseDate();
		baseTime = DefaultOptionMaker.makeDefaultBaseTime();
		nx = DEFAULT_NX;
		ny = DEFAULT_NY;
		numOfRows = DEFAULT_NUM_OF_ROWS;
		pageNo = DEFAULT_PAGE_NUM;
		type = TYPE_JSON;
		baseDateTime = baseDate + baseTime;
		fType = F_TYPE_GRIB;
	}

	void setBaseDate(int baseDate) {
		this.baseDate = Integer.toString(baseDate);
	}

	void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	void setBaseTime(int baseTime) {
		this.baseTime = Integer.toString(baseTime);
	}

	void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}

	void setNx(int nx) {
		this.nx = Integer.toString(nx);
	}

	void setNx(String nx) {
		this.nx = nx;
	}

	void setNy(int ny) {
		this.ny = Integer.toString(ny);
	}

	void setNy(String ny) {
		this.ny = ny;
	}

	void setNumOfRows(int numOfRows) {
		this.numOfRows = Integer.toString(numOfRows);
	}

	void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}

	void setPageNo(int pageNo) {
		this.pageNo = Integer.toString(pageNo);
	}

	void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	private String makeUrl() {
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
