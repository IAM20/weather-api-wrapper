package cs.hanyang.stu.kma.core.model.grib;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribResponse {
	private ForecastGribHeader header;
	private ForecastGribBody body;
}
