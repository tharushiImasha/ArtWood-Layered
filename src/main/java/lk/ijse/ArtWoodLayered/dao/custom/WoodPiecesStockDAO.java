package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.dto.WoodPiecesDto;
import lk.ijse.ArtWoodLayered.entity.WoodPieces;

import java.sql.SQLException;
import java.util.List;

public interface WoodPiecesStockDAO extends CrudDAO<WoodPieces> {
    int getWoodCountByType(String type) throws SQLException;
    int getWoodCount() throws SQLException;
    boolean reduceWood(String woodId) throws SQLException;
    List<WoodPiecesDto> getAllWoodForCombo() throws SQLException;
    boolean save(WoodPieces dto, String wood_type) throws SQLException;

}
