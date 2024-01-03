package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.SuperDAO;
import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends SuperDAO {
    boolean saveOrderDetail(String orderId, List<OrderTm> tmList) throws SQLException;

    boolean saveOrderDetail(String orderId, OrderTm cartTm) throws SQLException;
}
