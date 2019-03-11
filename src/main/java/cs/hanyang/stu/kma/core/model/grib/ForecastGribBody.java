package cs.hanyang.stu.kma.core.model.grib;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribBody {
	private ForecastGribItemWrapper items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;
}
