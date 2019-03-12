package com.github.iam20.kma.core.model.grib;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ForecastGribItemWrapper {
	List<ForecastGribItem> item;

	public ForecastGribItemWrapper() {
		item = new ArrayList<>();
		item.add(new ForecastGribItem());
	}
}
