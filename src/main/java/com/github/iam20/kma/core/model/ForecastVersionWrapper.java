package com.github.iam20.kma.core.model;

import com.github.iam20.kma.core.model.version.ForecastVersionResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastVersionWrapper {
	private ForecastVersionResponse forecastVersionApiResponse;
}
