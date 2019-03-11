package cs.hanyang.stu.kma.core.model.space;

import cs.hanyang.stu.kma.core.model.grib.ForecastGribBody;
import cs.hanyang.stu.kma.core.model.grib.ForecastGribHeader;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceResponse {
	private ForecastSpaceHeader header;
	private ForecastSpaceBody body;
}
