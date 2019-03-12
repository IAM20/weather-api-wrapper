package com.github.iam20.kma.core.model.space;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ForecastSpaceItemWrapper {
	List<ForecastSpaceItem> item;

	public ForecastSpaceItemWrapper() {
		item = new ArrayList<>();
		item.add(new ForecastSpaceItem());
	}
}
