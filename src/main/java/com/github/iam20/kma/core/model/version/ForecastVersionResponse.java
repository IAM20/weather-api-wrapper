package com.github.iam20.kma.core.model.version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastVersionResponse {
	ForecastVersionHeader header;
	ForecastVersionBody body;
}
