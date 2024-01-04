package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.SupplierDAO;
import lk.ijse.ArtWoodLayered.dto.SupplierDto;
import lk.ijse.ArtWoodLayered.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM supplier WHERE sup_id = ?", id);
    }

    @Override
    public List<Supplier> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute( "SELECT * FROM supplier");

        List<Supplier> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            Supplier entity = new Supplier(
                    resultSet.getString("sup_id"),
                    resultSet.getString("sup_name"),
                    resultSet.getString("address"),
                    resultSet.getString("email")
            );
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public boolean save(Supplier entity) throws SQLException {
        return SqlUtil.execute("INSERT INTO supplier VALUES(?, ?, ?, ?)", entity.getId(), entity.getName(), entity.getAddress(), entity.getEmail());
    }

    @Override
    public boolean update(Supplier entity) throws SQLException {
        return SqlUtil.execute("UPDATE supplier SET sup_name = ?, address = ?, email = ? WHERE sup_id = ?", entity.getName(), entity.getAddress(), entity.getEmail(), entity.getId());
    }

    @Override
    public Supplier search(String id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM supplier WHERE sup_id = ?", id);

        Supplier dto = null;

        if(resultSet.next()) {
            String sup_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String email = resultSet.getString(4);

            dto = new Supplier(sup_id, name, address, email);
        }

        return dto;
    }
}
