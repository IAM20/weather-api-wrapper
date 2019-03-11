package cs.hanyang.stu.kma.core.model;

import cs.hanyang.stu.kma.core.model.version.ForecastVersionResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastVersionWrapper {
	private ForecastVersionResponse forecastVersionApiResponse;
}
