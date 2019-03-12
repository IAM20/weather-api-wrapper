package com.github.iam20.kma.core.model.grib;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ForecastGribItemWrapper {
	List<ForecastGribItem> item;
}
