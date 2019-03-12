package com.github.iam20.kma.core.model.grib;

import lombok.Data;

@Data
public class ForecastGribItem {
    private Integer baseDate;
    private String baseTime;
    private String category;
    private Integer nx;
    private Integer ny;
    private Double obsrValue;

    public ForecastGribItem() {
        baseDate = 0;
        baseTime = "0000";
        category = "null";
        nx = 0;
        ny = 0;
        obsrValue = 0.0;
    }
}
