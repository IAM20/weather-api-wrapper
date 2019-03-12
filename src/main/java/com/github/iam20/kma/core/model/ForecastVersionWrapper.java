package com.github.iam20.kma.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.github.iam20.kma.core.model.version.ForecastVersionResponse;

@Data
@NoArgsConstructor
public class ForecastVersionWrapper {
	private ForecastVersionResponse forecastVersionApiResponse;
}
