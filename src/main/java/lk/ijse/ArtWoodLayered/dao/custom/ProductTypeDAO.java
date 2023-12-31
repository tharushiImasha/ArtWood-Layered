package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.entity.ProductType;

import java.sql.SQLException;

public interface ProductTypeDAO extends CrudDAO<ProductType> {
    String getQuality(String productId) throws SQLException;

    String getType(String productId) throws SQLException;

    double getPrice(String productId) throws SQLException;

    String getName(String productId) throws SQLException;
}
