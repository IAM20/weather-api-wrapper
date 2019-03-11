package cs.hanyang.stu.kma.core.model.space;

import cs.hanyang.stu.kma.core.model.grib.ForecastGribItemWrapper;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceBody {
	private ForecastSpaceItemWrapper items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;
}
