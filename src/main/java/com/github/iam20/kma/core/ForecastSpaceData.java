package com.github.iam20.kma.core;

// 14 data.

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceData extends SpaceTimeData {
	private Double percentOfRain;
	private Integer rainType;
	private Double rainPerSixHour;
	private Double humidity;
	private Double snowPerSixHour;
	private Integer sky;
	private Double temperatureOfThreeHour;
	private Double minTemperature;
	private Double maxTemperature;
	private Double eastWestWind;
	private Double southNorthWind;
	private Double waveHeight;
	private Double windVector;
	private Double windSpeed;
}
