package com.github.iam20.kma.core.model.space;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceBody {
	private ForecastSpaceItemWrapper items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;
}
