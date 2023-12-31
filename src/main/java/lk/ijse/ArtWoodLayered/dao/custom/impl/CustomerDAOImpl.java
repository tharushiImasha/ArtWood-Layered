package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.CustomerDAO;
import lk.ijse.ArtWoodLayered.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public String generateNextId() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT cus_id FROM customer");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("C");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "C" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM customer WHERE cus_id = ?", id);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM customer");

        List<Customer> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            Customer entity = new Customer(
                    resultSet.getString("cus_id"),
                    resultSet.getString("cus_name"),
                    resultSet.getString("cus_address"),
                    resultSet.getInt("tel")
            );
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public boolean save(Customer dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO customer VALUES(?, ?, ?, ?)", dto);
    }

    @Override
    public boolean update(Customer dto) throws SQLException {
        return SqlUtil.execute("UPDATE customer SET name = ?, address = ?, tel = ? WHERE cus_id = ?", dto);
    }

    @Override
    public Customer search(String tel) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM customer WHERE tel = ?", tel);

        Customer dto = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            int cus_tel = Integer.parseInt(resultSet.getString(4));

            dto = new Customer(cus_id, cus_name, cus_address, cus_tel);
        }

        return dto;
    }
}
