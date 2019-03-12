package com.github.iam20.kma.core.model.space;

import lombok.Data;

@Data
public class ForecastSpaceItem {
	private String baseDate;
	private String baseTime;
	private String category;
	private Integer fcstDate;
	private String fcstTime;
	private Double fcstValue;
	private Integer nx;
	private Integer ny;

	public ForecastSpaceItem() {
		baseDate = "0000";
		baseTime = "0000";
		category = "X";
		fcstDate = 0;
		fcstTime ="-1";
		fcstValue = 0.0;
		nx = 0;
		ny = 0;
	}
}
