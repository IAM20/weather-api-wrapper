package cs.hanyang.stu.kma.core.model.version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastVersionHeader {
	private String resultCode;
	private String resultMsg;
}
