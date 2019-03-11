package cs.hanyang.stu.kma.core.model.space;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastSpaceItem {
	private String baseDate;
	private String baseTime;
	private String category;
	private Integer fcstDate;
	private String fcstTime;
	private Double fcstValue;
	private Integer nx;
	private Integer ny;
}
