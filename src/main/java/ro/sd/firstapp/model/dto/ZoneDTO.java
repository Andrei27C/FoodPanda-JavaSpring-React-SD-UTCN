package ro.sd.firstapp.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ZoneDTO {

    @NonNull
    public String name;
}
