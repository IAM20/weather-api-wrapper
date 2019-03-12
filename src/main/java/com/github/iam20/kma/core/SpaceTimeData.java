package com.github.iam20.kma.core;

public abstract class SpaceTimeData {
	private Integer forecastDate;
	private String forecastTime;

	public Integer getForecastDate() {
		return forecastDate;
	}

	public String getForecastTime() {
		return forecastTime;
	}

	public void setForecastDate(Integer forecastDate) {
		this.forecastDate = forecastDate;
	}

	public void setForecastTime(String forecastTime) {
		this.forecastTime = forecastTime;
	}
}
