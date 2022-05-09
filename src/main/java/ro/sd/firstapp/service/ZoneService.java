package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Zone;
import ro.sd.firstapp.repository.ZoneRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepo zoneRepo;

    public List<Zone> findAll() {
        return zoneRepo.findAll();
    }

    public Zone findByName(String name) {
        Optional<Zone> zone = zoneRepo.findByName(name);
        return zone.orElse(null);
    }
}
