package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.WoodPiecesDto;

import java.sql.SQLException;
import java.util.List;

public interface WoodPiecesStockBO extends SuperBO {
    String generateNextWoodId() throws SQLException, ClassNotFoundException;

    List<WoodPiecesDto> getAllWood() throws SQLException;

    List<WoodPiecesDto> getAllWoodForCombo() throws SQLException;

    boolean deleteWood(String id) throws SQLException;

    boolean reduceWood(String woodId) throws SQLException;

    int getWoodCount() throws SQLException;

    int getWoodCountByType(String type) throws SQLException;

    boolean saveWood(WoodPiecesDto dto) throws SQLException;

    boolean updateWood(WoodPiecesDto dto) throws SQLException;

    WoodPiecesDto searchWood(String id) throws SQLException;
}
