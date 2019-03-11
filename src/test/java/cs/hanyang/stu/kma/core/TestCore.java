package cs.hanyang.stu.kma.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

@Slf4j
public class TestCore {
	private NewSky sky;

	@Before
	public void before() {
		sky = new NewSkyBuilder()
				.setServiceKey("i2QEyuG9Dm77TY%2FimVDNn5Ftrt83E2AkuX9T40TB7uZ0aSmug723wkamJtWz2dpjS%2FDWi%2BatGI67oBWe47rG8A%3D%3D")
				.setNx(60)
				.setNy(127)
				.build();
	}

	@Test
	public void gribTest() {
		ForecastGrib grib = sky.forecastGrib();
		log.info(grib.toString());
	}

	@Test
	public void spaceTest() {
		List<ForecastSpaceData> spaceData = sky.forecastSpaceData();
		for (ForecastSpaceData data : spaceData) {
			log.info(data.toString());
		}
	}

	@Test
	public void timeTest() {
		List<ForecastTimeData> timeData = sky.forecastTimeData();
		for (ForecastTimeData data : timeData) {
			log.info(data.toString());
		}
	}
}
