package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.SupOrderDAO;
import lk.ijse.ArtWoodLayered.entity.SupOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupOrderDAOImpl implements SupOrderDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT sup_order_id FROM sup_orders");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("S");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "S" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<SupOrder> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(SupOrder dto) throws SQLException {
        return false;
    }

    public boolean save(String supOrderId, double price, String type, String supId) throws SQLException {
        return SqlUtil.execute("INSERT INTO sup_orders VALUES(?, ?, ?, ?)", supOrderId, price, type, supId);
    }

    @Override
    public boolean update(SupOrder dto) throws SQLException {
        return false;
    }

    @Override
    public SupOrder search(String tel) throws SQLException {
        return null;
    }
}
