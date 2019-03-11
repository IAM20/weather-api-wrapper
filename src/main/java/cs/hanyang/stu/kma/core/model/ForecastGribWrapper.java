package cs.hanyang.stu.kma.core.model;

import cs.hanyang.stu.kma.core.model.grib.ForecastGribResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribWrapper {
	private ForecastGribResponse response;
}
