package cs.hanyang.stu.kma.core;

import cs.hanyang.stu.kma.core.api.ApiExecutor;
import cs.hanyang.stu.kma.core.model.ForecastGribWrapper;
import cs.hanyang.stu.kma.core.model.ForecastSpaceTimeWrapper;
import cs.hanyang.stu.kma.core.util.GribUnwrapper;
import cs.hanyang.stu.kma.core.util.SpaceDataUnwrapper;
import cs.hanyang.stu.kma.core.util.TimeDataUnwrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.List;

@Slf4j
public class TestCore {
	private NewSky newSky;

	@Before
	public void before() {
		newSky = new NewSkyBuilder()
				.setServiceKey("i2QEyuG9Dm77TY%2FimVDNn5Ftrt83E2AkuX9T40TB7uZ0aSmug723wkamJtWz2dpjS%2FDWi%2BatGI67oBWe47rG8A%3D%3D")
				.setBaseDate("20190311")
				.setBaseTime("0500")
				.setNx(60)
				.setNy(127)
				.setNumOfRows(1024)
				.setPageNo(1)
				.setType(NewSky.TYPE_JSON)
				.build();
	}

	@Test
	public void test() throws URISyntaxException {
		ForecastGrib grib = newSky.forecastGrib();
		log.info(grib.toString());
		List<ForecastSpaceData> spaceData = newSky.forecastSpaceData();
		for (ForecastSpaceData data : spaceData) {
			log.info(data.toString());
		}
		List<ForecastTimeData> timeData = newSky.forecastTimeData();
		for (ForecastTimeData data : timeData) {
			log.info(data.toString());
		}
	}
}
