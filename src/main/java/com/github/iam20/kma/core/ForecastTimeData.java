package com.github.iam20.kma.core;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastTimeData extends SpaceTimeData {
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
