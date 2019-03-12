package com.github.iam20.kma.core.model.space;

import lombok.Data;

@Data
public class ForecastSpaceResponse {
	private ForecastSpaceHeader header;
	private ForecastSpaceBody body;

	public ForecastSpaceResponse() {
		header = new ForecastSpaceHeader();
		body = new ForecastSpaceBody();
	}
}
