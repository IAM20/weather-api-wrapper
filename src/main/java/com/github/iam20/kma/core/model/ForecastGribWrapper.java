package com.github.iam20.kma.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.github.iam20.kma.core.model.grib.ForecastGribResponse;

@Data
@NoArgsConstructor
public class ForecastGribWrapper {
	private ForecastGribResponse response;
}
