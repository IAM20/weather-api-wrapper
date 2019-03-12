package com.github.iam20.kma.core.model;

import com.github.iam20.kma.core.model.space.ForecastSpaceResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceTimeWrapper {
	ForecastSpaceResponse response;
}
