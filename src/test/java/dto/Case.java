package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Case {
    String title;
    String status;
    String suite;
    String severity;
    String priority;
    String type;
    String layer;
    String milestone;
}
