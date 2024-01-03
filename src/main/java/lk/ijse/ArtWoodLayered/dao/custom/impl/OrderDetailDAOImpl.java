package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.OrderDetailDAO;
import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean saveOrderDetail(String orderId, List<OrderTm> tmList) throws SQLException {
        for (OrderTm cartTm : tmList) {
            if(!saveOrderDetail(orderId, cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveOrderDetail(String orderId, OrderTm cartTm) throws SQLException {
        return SqlUtil.execute("INSERT INTO order_details VALUES(?, ?, ?, ?)", orderId, cartTm.getCode(), cartTm.getQty(), cartTm.getUnitPrice());
    }
}
