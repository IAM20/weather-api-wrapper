package com.github.iam20.kma.core.model.grib;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribResponse {
	private ForecastGribHeader header;
	private ForecastGribBody body;
}
