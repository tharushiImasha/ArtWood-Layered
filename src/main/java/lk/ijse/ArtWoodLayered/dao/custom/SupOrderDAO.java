package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.entity.SupOrder;

import java.sql.SQLException;

public interface SupOrderDAO extends CrudDAO<SupOrder> {
    boolean save(String supOrderId, double price, String type, String supId) throws SQLException;
}
