package com.github.iam20.kma.core.model.grib;

import lombok.Data;

@Data
public class ForecastGribHeader {
	private String resultCode;
	private String resultMsg;

	public ForecastGribHeader() {
		resultCode = "-1";
		resultMsg = "No item is returned";
	}
}
