package cs.hanyang.stu.kma.core;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGrib {
	private Double temperature;
	private Double rainPerHour;
	private Double eastWestWind;
	private Double southNorthWind;
	private Integer rainType;
	private Double humidity;
	private Double windVector;
	private Double windSpeed;
}
