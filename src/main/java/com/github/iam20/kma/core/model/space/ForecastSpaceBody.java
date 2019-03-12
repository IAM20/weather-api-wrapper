package com.github.iam20.kma.core.model.space;

import lombok.Data;

@Data
public class ForecastSpaceBody {
	private ForecastSpaceItemWrapper items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;

	public ForecastSpaceBody() {
		items = new ForecastSpaceItemWrapper();
		numOfRows = 0;
		pageNo = 0;
		totalCount = 0;
	}
}
