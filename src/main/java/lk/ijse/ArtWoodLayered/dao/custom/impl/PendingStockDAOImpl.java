package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.PendingStockDAO;
import lk.ijse.ArtWoodLayered.entity.PendingStock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PendingStockDAOImpl implements PendingStockDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT pending_stock_id FROM pending_stock");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("PE");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "PE" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM pending_stock WHERE pending_stock_id = ?", id);
    }

    @Override
    public List<PendingStock> getAll() throws SQLException {
         ResultSet resultSet = SqlUtil.execute("SELECT * FROM pending_stock");

        List<PendingStock> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String pending_id = resultSet.getString(1);
            String emp_id = resultSet.getString(3);
            String wood_piece_id = resultSet.getString(4);
            String finished_id = resultSet.getString(5);

            var dto = new PendingStock(pending_id, emp_id, wood_piece_id, finished_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(PendingStock dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO pending_stock VALUES(?, ?, ?, ?, ?)", dto);
    }

    @Override
    public boolean update(PendingStock dto) throws SQLException {
        return SqlUtil.execute("UPDATE pending_stock SET emp_id = ?, wood_piece_id = ?, finished_stock_id = ? WHERE pending_stock_id = ?", dto);
    }

    @Override
    public PendingStock search(String id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM pending_stock WHERE pending_stock_id = ?", id);

        PendingStock dto = null;

        if(resultSet.next()) {
            String pending_id = resultSet.getString(1);
            String emp_id = resultSet.getString(3);
            String wood_piece_id = resultSet.getString(4);
            String finished_id = resultSet.getString(5);

            dto = new PendingStock(pending_id, emp_id, wood_piece_id, finished_id);
        }

        return dto;
    }

    @Override
    public int getPendingCount() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT SUM(pending_amount) FROM pending_stock");

        int amount = 0;

        if (resultSet.next()){
            amount = resultSet.getInt(1);
        }
        return amount;
    }
}
