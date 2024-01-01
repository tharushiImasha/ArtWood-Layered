package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.SupOrderDto;

import java.sql.SQLException;

public interface PlaceSupOrderBO extends SuperBO {
    boolean placeSupOrder(SupOrderDto pDto) throws SQLException;
}
