package com.github.iam20.kma.core.model.space;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceResponse {
	private ForecastSpaceHeader header;
	private ForecastSpaceBody body;
}
