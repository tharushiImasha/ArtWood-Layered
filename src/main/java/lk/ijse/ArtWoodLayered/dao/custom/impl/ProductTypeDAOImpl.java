package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.ProductTypeDAO;
import lk.ijse.ArtWoodLayered.entity.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDAOImpl implements ProductTypeDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM product_type WHERE product_id = ?", id);
    }

    @Override
    public List<ProductType> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM product_type");

        List<ProductType> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            ProductType entity = new ProductType(
                    resultSet.getString("product_id"),
                    resultSet.getString("product_name"),
                    resultSet.getString("quality"),
                    resultSet.getString("wood_type"),
                    resultSet.getDouble("price")
            );
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public boolean save(ProductType entity) throws SQLException {
        return SqlUtil.execute("INSERT INTO product_type VALUES(?, ?, ?, ?, ?)", entity.getProduct_id(), entity.getProduct_name(), entity.getQuality(), entity.getWood_type(), entity.getPrice());
    }

    @Override
    public boolean update(ProductType entity) throws SQLException {
        return SqlUtil.execute("UPDATE product_type SET product_name = ?, quality = ?, wood_type = ?, price = ? WHERE product_id = ?", entity.getProduct_name(), entity.getQuality(), entity.getWood_type(), entity.getPrice(), entity.getProduct_id());
    }

    @Override
    public ProductType search(String tel) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM product_type WHERE product_id = ?", tel);

        ProductType dto = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String quality = resultSet.getString(3);
            String wood_type = resultSet.getString(4);
            double price = resultSet.getDouble(5);

            dto = new ProductType(cus_id, cus_name, quality, wood_type, price);
        }

        return dto;
    }

    public String getQuality(String productId) throws SQLException {
       ResultSet resultSet = SqlUtil.execute("select quality FROM product_type WHERE product_id = ?", productId);

        String quality = "";

        while (resultSet.next()){
            quality = resultSet.getString(1);
        }
        return quality;
    }

    public String getType(String productId) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("select wood_type FROM product_type WHERE product_id = ?", productId);

        String wood = "";

        while (resultSet.next()){
            wood = resultSet.getString(1);
        }
        return wood;
    }

    public double getPrice(String productId) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("select price FROM product_type WHERE product_id = ?", productId);

        double price = 0;

        while (resultSet.next()){
            price = Double.parseDouble(resultSet.getString(1));
        }
        return price;
    }

    public String getName(String productId) throws SQLException {
        String product_name = "";

       ResultSet resultSet = SqlUtil.execute("select product_name FROM product_type WHERE product_id = ?", productId);

        while (resultSet.next()){
            product_name = resultSet.getString(1);
        }
        return product_name;
    }
}
