package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Zone;
import ro.sd.firstapp.repository.ZoneRepo;

import java.util.List;
import java.util.Optional;

/**
 * Service used to handle the Zone model
 */
@Service
public class ZoneService {
    @Autowired
    private ZoneRepo zoneRepo;

    /**
     * Retrieves all the zones.
     * @return A list containing all delivery zones.
     */
    public List<Zone> findAll() {
        return zoneRepo.findAll();
    }

    /**
     * Retrieves a zone from the database by its name.
     * @param name of the zone.
     * @return The retrieved zone.
     */
    public Zone findByName(String name) {
        Optional<Zone> zone = zoneRepo.findByName(name);
        return zone.orElse(null);
    }
}
