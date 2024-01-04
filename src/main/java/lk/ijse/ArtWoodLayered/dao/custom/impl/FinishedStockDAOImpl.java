package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.FinishedStockDAO;
import lk.ijse.ArtWoodLayered.dto.FinishedStockDto;
import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;
import lk.ijse.ArtWoodLayered.entity.FinishedStock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinishedStockDAOImpl implements FinishedStockDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT finished_stock_id FROM finished_stock");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("F");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "F" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM finished_stock WHERE finished_stock_id = ?", id);
    }

    @Override
    public List<FinishedStock> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM finished_stock");

        List<FinishedStock> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String finished_id = resultSet.getString(1);
            int amount = Integer.parseInt(resultSet.getString(2));
            String product_id = resultSet.getString(3);

            var dto = new FinishedStock(finished_id, amount, product_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(FinishedStock entity) throws SQLException {
        return SqlUtil.execute("INSERT INTO finished_stock VALUES(?, ?, ?)", entity.getFinished_id(), entity.getAmount(), entity.getProduct_id());
    }

    @Override
    public boolean update(FinishedStock entity) throws SQLException {
        return SqlUtil.execute("UPDATE finished_stock SET finished_amount = ? WHERE finished_stock_id = ?", entity.getAmount(), entity.getFinished_id());
    }

    @Override
    public FinishedStock search(String id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM finished_stock WHERE finished_stock_id = ?", id);

        FinishedStock dto = null;

        if(resultSet.next()) {
            String finished_id = resultSet.getString(1);
            int amount = Integer.parseInt(resultSet.getString(2));
            String product_id = resultSet.getString(3);

            dto = new FinishedStock(finished_id, amount, product_id);
        }

        return dto;
    }

    @Override
    public int getProductCountByType(String type) throws SQLException {
       ResultSet resultSet = SqlUtil.execute("select sum(f.finished_amount) from product_type p join finished_stock f on p.product_id = f.product_id where p.product_name = ?", type);

        int amount = 0;

        if (resultSet.next()){
            amount = resultSet.getInt(1);
        }
        return amount;
    }

    @Override
    public List<FinishedStockDto> getAllFinishedStockForCombo() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM finished_stock WHERE finished_amount > 0");

        List<FinishedStockDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String finished_id = resultSet.getString(1);
            int amount = Integer.parseInt(resultSet.getString(2));
            String product_id = resultSet.getString(3);

            var dto = new FinishedStockDto(finished_id, amount, product_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean updateFinishedFromP(String finished_id) throws SQLException {
        return SqlUtil.execute("UPDATE finished_stock SET finished_amount = finished_amount + 1 WHERE finished_stock_id = ?", finished_id);
    }

    @Override
    public int getFinishedCount() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT SUM(finished_amount) FROM finished_stock");

        int amount = 0;

        if (resultSet.next()){
            amount = resultSet.getInt(1);
        }
        return amount;
    }

    @Override
    public boolean updateItem(List<OrderTm> tmList) throws SQLException {
        for (OrderTm cartTm : tmList) {
            if(!updateQty(cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateQty(OrderTm cartTm) throws SQLException {
       return SqlUtil.execute("UPDATE finished_stock SET finished_amount = finished_amount - ? WHERE finished_stock_id = ?", cartTm.getQty(), cartTm.getCode());
    }
}
