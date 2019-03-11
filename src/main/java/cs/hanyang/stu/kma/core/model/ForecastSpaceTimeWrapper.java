package cs.hanyang.stu.kma.core.model;

import cs.hanyang.stu.kma.core.model.space.ForecastSpaceResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceTimeWrapper {
	ForecastSpaceResponse response;
}
