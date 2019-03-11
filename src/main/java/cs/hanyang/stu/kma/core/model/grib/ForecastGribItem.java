package cs.hanyang.stu.kma.core.model.grib;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastGribItem {
    private Integer baseDate;
    private String baseTime;
    private String category;
    private Integer nx;
    private Integer ny;
    private Double obsrValue;
}
