package com.github.iam20.kma.core.model;

import com.github.iam20.kma.core.model.grib.ForecastGribResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribWrapper {
	private ForecastGribResponse response;
}
