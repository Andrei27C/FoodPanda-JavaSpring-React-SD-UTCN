package ro.sd.firstapp.model.mapper;

import ro.sd.firstapp.model.Zone;
import ro.sd.firstapp.model.dto.ZoneDTO;

public class ZoneMapper implements Mapper<Zone, ZoneDTO> {
    private static ZoneMapper zoneMapper = null;

    private ZoneMapper() {

    }

    public static ZoneMapper getInstance() {
        if (zoneMapper == null) {
            zoneMapper = new ZoneMapper();
        }
        return zoneMapper;
    }

    @Override
    public Zone convertFromDTO(ZoneDTO zoneDTO) {
        return null;
    }

    @Override
    public ZoneDTO convertToDTO(Zone zone) {
        return ZoneDTO.builder()
                .name(zone.getName())
                .build();
    }
}
