package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.OrderDAO;
import lk.ijse.ArtWoodLayered.entity.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT order_id FROM orders");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("O");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "O" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Order dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Order dto) throws SQLException {
        return false;
    }

    @Override
    public Order search(String tel) throws SQLException {
        return null;
    }

    @Override
    public boolean saveOrder(String orderId, LocalDate date, String pay_meth, String cusId) throws SQLException {
        return  SqlUtil.execute("INSERT INTO orders VALUES(?, ?, ?)", orderId, date, cusId);
    }
}
