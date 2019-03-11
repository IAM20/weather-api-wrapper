package cs.hanyang.stu.kma.core;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastTimeData {
	private Integer forecastDate;
	private String forecastTime;
	private Double temperature;
	private Double rainPerHour;
	private Integer sky;
	private Double eastWestWind;
	private Double southNorthWind;
	private Double humidity;
	private Integer rainType;
	private Integer thunder;
	private Double windVector;
	private Double windSpeed;
}
