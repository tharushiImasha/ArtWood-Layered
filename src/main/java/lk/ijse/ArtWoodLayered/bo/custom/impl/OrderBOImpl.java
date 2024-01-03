package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.OrderBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.OrderDAO;

import java.sql.SQLException;
import java.time.LocalDate;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.ORDER);

    @Override
    public boolean saveOrder(String orderId, LocalDate date, String pay_meth, String cusId) throws SQLException {
        return orderDAO.saveOrder(orderId, date,pay_meth, cusId);
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNextId();
    }
}
