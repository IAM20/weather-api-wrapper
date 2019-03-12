package com.github.iam20.kma.core.model.grib;

import lombok.Data;

@Data
public class ForecastGribResponse {
	private ForecastGribHeader header;
	private ForecastGribBody body;

	public ForecastGribResponse() {
		header = new ForecastGribHeader();
		body = new ForecastGribBody();
	}
}
