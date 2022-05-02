package dto;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Counts {
    @Expose(serialize = false, deserialize = true)
    int cases;
}
