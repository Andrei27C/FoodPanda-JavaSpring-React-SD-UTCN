package ro.sd.firstapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin extends UserData {

    @OneToOne(mappedBy = "admin",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Restaurant restaurant;

    @Builder(builderMethodName = "AdminBuilder")
    public Admin(@NonNull String firstName, @NonNull String lastName, @NonNull String username, @NonNull String password) {
        super(firstName, lastName, username, password);
    }
}
