package com.github.iam20.kma.core.model;

import lombok.Data;

import com.github.iam20.kma.core.model.grib.ForecastGribResponse;

@Data
public class ForecastGribWrapper {
	private ForecastGribResponse response;

	public ForecastGribWrapper() {
		response = new ForecastGribResponse();
	}
}
