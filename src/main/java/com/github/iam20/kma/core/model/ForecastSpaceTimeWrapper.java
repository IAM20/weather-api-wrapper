package com.github.iam20.kma.core.model;

import lombok.Data;

import com.github.iam20.kma.core.model.space.ForecastSpaceResponse;

@Data
public class ForecastSpaceTimeWrapper {
	ForecastSpaceResponse response;

	public ForecastSpaceTimeWrapper() {
		response = new ForecastSpaceResponse();
	}
}
