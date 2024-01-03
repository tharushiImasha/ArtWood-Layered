package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderBO extends SuperBO {
    boolean saveOrder(String orderId, LocalDate date, String pay_meth, String cusId) throws SQLException;

    String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
