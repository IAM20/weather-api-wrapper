package cs.hanyang.stu.kma.core.model.grib;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribHeader {
	private String resultCode;
	private String resultMsg;
}
