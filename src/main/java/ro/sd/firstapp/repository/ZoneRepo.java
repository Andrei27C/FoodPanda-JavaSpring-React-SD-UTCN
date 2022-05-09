package ro.sd.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.firstapp.model.Zone;

import java.util.Optional;

@Repository
public interface ZoneRepo extends JpaRepository<Zone, Integer> {
    Optional<Zone> findByName(String name);
}
