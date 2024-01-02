package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.WoodPiecesStockDAO;
import lk.ijse.ArtWoodLayered.dto.WoodPiecesDto;
import lk.ijse.ArtWoodLayered.entity.WoodPieces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WoodPiecesStockDAOImpl implements WoodPiecesStockDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT wood_piece_id FROM wood_pieces_stock");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("W");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "W" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM wood_pieces_stock WHERE wood_piece_id = ?", id);
    }

    @Override
    public List<WoodPieces> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM wood_pieces_stock");

        List<WoodPieces> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String quality = resultSet.getString(2);
            int amount = Integer.parseInt(resultSet.getString(3));
            String type = resultSet.getString(4);
            String log_id = resultSet.getString(5);

            var dto = new WoodPieces(id, quality, amount, type, log_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(WoodPieces dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO wood_pieces_stock VALUES(?, ?, ?, ?, ?)", dto);
    }

    @Override
    public boolean update(WoodPieces dto) throws SQLException {
        return SqlUtil.execute("select wood_type from log_stock where logs_id = ?", dto);
    }

    @Override
    public WoodPieces search(String id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM wood_pieces_stock WHERE wood_piece_id = ?", id);

        WoodPieces dto = null;

        if(resultSet.next()) {
            String wood_piece_id = resultSet.getString(1);
            String quality = resultSet.getString(2);
            int amount = Integer.parseInt(resultSet.getString(3));
            String type = resultSet.getString(4);
            String log_id = resultSet.getString(5);

            dto = new WoodPieces(wood_piece_id, quality, amount, type, log_id);
        }

        return dto;
    }

    @Override
    public int getWoodCountByType(String type) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT SUM(wood_amount) FROM wood_pieces_stock where wood_type = ?", type);

        int amount = 0;

        if (resultSet.next()){
            amount = resultSet.getInt(1);
        }
        return amount;
    }

    @Override
    public int getWoodCount() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT SUM(wood_amount) FROM wood_pieces_stock");

        int amount = 0;

        if (resultSet.next()){
            amount = resultSet.getInt(1);
        }
        return amount;
    }

    @Override
    public boolean reduceWood(String woodId) throws SQLException {
        return SqlUtil.execute("UPDATE wood_pieces_stock SET wood_amount = wood_amount - 1 WHERE wood_piece_id = ?", woodId);
    }

    @Override
    public List<WoodPiecesDto> getAllWoodForCombo() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM wood_pieces_stock WHERE wood_amount > 0");

        List<WoodPiecesDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String quality = resultSet.getString(2);
            int amount = Integer.parseInt(resultSet.getString(3));
            String type = resultSet.getString(4);
            String log_id = resultSet.getString(5);

            var dto = new WoodPiecesDto(id, quality, amount, type, log_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(WoodPieces dto, String wood_type) throws SQLException {
        return SqlUtil.execute("INSERT INTO wood_pieces_stock VALUES(?, ?, ?, ?, ?)", dto.getWood_piece_id(), dto.getQuality(), dto.getAmount(), wood_type, dto.getLogs_id());
    }
}
