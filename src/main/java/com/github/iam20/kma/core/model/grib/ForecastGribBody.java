package com.github.iam20.kma.core.model.grib;

import lombok.Data;

@Data
public class ForecastGribBody {
	private ForecastGribItemWrapper items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;

	public ForecastGribBody() {
		items = new ForecastGribItemWrapper();
		numOfRows = 0;
		pageNo = 0;
		totalCount = 0;
	}
}
