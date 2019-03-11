package cs.hanyang.stu.kma.core.model.space;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ForecastSpaceItemWrapper {
	List<ForecastSpaceItem> item;
}
