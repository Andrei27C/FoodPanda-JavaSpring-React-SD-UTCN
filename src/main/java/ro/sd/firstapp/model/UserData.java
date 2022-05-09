package ro.sd.firstapp.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_user", updatable = false, unique = true, nullable = false)
    private Integer idUser;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name ="username", nullable = false, unique = true)
    public String username;

    @NonNull
    @Column(nullable = false)
    public String password;

}
