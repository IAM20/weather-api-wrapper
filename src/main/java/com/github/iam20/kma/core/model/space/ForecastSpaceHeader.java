package com.github.iam20.kma.core.model.space;

import lombok.Data;

@Data
public class ForecastSpaceHeader {
	private String resultCode;
	private String resultMsg;

	public ForecastSpaceHeader() {
		resultCode = "-1";
		resultMsg = "No item has been returned";
	}
}
