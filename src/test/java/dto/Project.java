package dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @SerializedName("title")
    @Expose
    String name;
    @SerializedName("code")
    @Expose
    String code;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("access")
    @Expose
    String access;
    @SerializedName("group")
    @Expose
    String group;
    @Expose(serialize = false, deserialize = true)
    Counts counts;
}
