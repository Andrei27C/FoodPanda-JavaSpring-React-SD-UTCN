package ro.sd.firstapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zone", updatable = false, unique = true, nullable = false)
    private Integer idZone;

    @NonNull
    @Column(name = "name", unique = true, length = 100)
    private String name;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "deliveryZones")
    private List<Restaurant> restaurants;

}

