package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;

import java.sql.SQLException;

public interface SupOrderBO extends SuperBO {
    boolean saveOrder(String supOrderId, double price, String type, String supId) throws SQLException;

    String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
