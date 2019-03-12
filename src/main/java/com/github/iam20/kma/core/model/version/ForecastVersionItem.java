package com.github.iam20.kma.core.model.version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastVersionItem {
	private Integer baseDateTime;
	private String fileType;
	private Integer version;
}
