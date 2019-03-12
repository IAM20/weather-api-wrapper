package com.github.iam20.kma.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.github.iam20.kma.core.model.space.ForecastSpaceResponse;

@Data
@NoArgsConstructor
public class ForecastSpaceTimeWrapper {
	ForecastSpaceResponse response;
}
