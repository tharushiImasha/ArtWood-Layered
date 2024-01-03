package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.entity.Order;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<Order> {
    boolean saveOrder(String orderId, LocalDate date, String pay_meth, String cusId) throws SQLException;
}
