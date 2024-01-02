package lk.ijse.ArtWoodLayered.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.ArtWoodLayered.bo.custom.WoodPiecesStockBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.LogStockDAO;
import lk.ijse.ArtWoodLayered.dao.custom.WoodPiecesStockDAO;
import lk.ijse.ArtWoodLayered.db.DbConnection;
import lk.ijse.ArtWoodLayered.dto.WoodPiecesDto;
import lk.ijse.ArtWoodLayered.entity.Logs;
import lk.ijse.ArtWoodLayered.entity.WoodPieces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WoodPiecesStockBOImpl implements WoodPiecesStockBO {

    WoodPiecesStockDAO woodPiecesStockDAO = (WoodPiecesStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.WOOD_PIECES);
    LogStockDAO logStockDAO = (LogStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.LOGS);

    @Override
    public String generateNextWoodId() throws SQLException, ClassNotFoundException {
        return woodPiecesStockDAO.generateNextId();
    }

    @Override
    public List<WoodPiecesDto> getAllWood() throws SQLException {
         List<WoodPieces> woodPieces = woodPiecesStockDAO.getAll();
         List<WoodPiecesDto> woodPiecesDtos = new ArrayList<>();

        for (WoodPieces woodPieces1: woodPieces) {
            woodPiecesDtos.add(new WoodPiecesDto(woodPieces1.getWood_piece_id(),woodPieces1.getQuality(), woodPieces1.getAmount(), woodPieces1.getWood_type(), woodPieces1.getLogs_id()));
        }
        return woodPiecesDtos;
    }

    @Override
    public List<WoodPiecesDto> getAllWoodForCombo() throws SQLException {
        return woodPiecesStockDAO.getAllWoodForCombo();
    }

    @Override
    public boolean deleteWood(String id) throws SQLException {
        return woodPiecesStockDAO.delete(id);
    }

    @Override
    public boolean reduceWood(String woodId) throws SQLException {
        return woodPiecesStockDAO.reduceWood(woodId);
    }

    @Override
    public int getWoodCount() throws SQLException {
        return woodPiecesStockDAO.getWoodCount();
    }

    @Override
    public int getWoodCountByType(String type) throws SQLException {
        return woodPiecesStockDAO.getWoodCountByType(type);
    }

    @Override
    public boolean saveWood(WoodPiecesDto dto) throws SQLException {
        Connection connection = null;
        connection = DbConnection.getInstance().getConnection();

        Logs logs = logStockDAO.search(dto.getLogs_id());

        String wood_type = logs.getWood_type();
        int amount = logs.getLog_amount();

        connection.setAutoCommit(false);

        boolean isSaved1 = false;

        if (amount != 0){
            boolean isSaved = woodPiecesStockDAO.save(new WoodPieces(dto.getWood_piece_id(), dto.getQuality(), dto.getAmount(), dto.getWood_type(), dto.getLogs_id()), wood_type);
            isSaved1 = false;

            if (isSaved){
                isSaved1 = logStockDAO.reduce(dto.getLogs_id());

                if (isSaved1){
                    connection.commit();
                }

            }
            connection.rollback();
            connection.setAutoCommit(true);
        }else {
            new Alert(Alert.AlertType.INFORMATION, "Not Enough Log").show();
        }

        return isSaved1;
    }

    @Override
    public boolean updateWood(WoodPiecesDto dto) throws SQLException {
        return woodPiecesStockDAO.update(new WoodPieces(dto.getWood_piece_id(), dto.getQuality(), dto.getAmount(), dto.getWood_type(), dto.getLogs_id()));
    }

    @Override
    public WoodPiecesDto searchWood(String id) throws SQLException {
        WoodPieces woodPieces = woodPiecesStockDAO.search(id);
        WoodPiecesDto woodPiecesDto = new WoodPiecesDto(woodPieces.getWood_piece_id(), woodPieces.getQuality(), woodPieces.getAmount(), woodPieces.getWood_type(), woodPieces.getLogs_id());

        return woodPiecesDto;
    }
}
