package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.PlaceOrderBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.*;
import lk.ijse.ArtWoodLayered.db.DbConnection;
import lk.ijse.ArtWoodLayered.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.ORDER);
    FinishedStockDAO finishedStockDAO = (FinishedStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINISHED_STOCK);
    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINANCE);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.ORDER_DETAIL);

    @Override
    public boolean placeOrder(OrderDto pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderDAO.saveOrder(pDto.getOrderId(), pDto.getDate(), pDto.getPay_meth(), pDto.getTel());

            if (isOrderSaved) {
                boolean isUpdated = finishedStockDAO.updateItem(pDto.getTmList());

                if(isUpdated) {
                    boolean isOrderDetailSaved = orderDetailDAO.saveOrderDetail(pDto.getOrderId(), pDto.getTmList());
                    if(isOrderDetailSaved) {
                        boolean isFinanceUpdated = financeDAO.IncreaseFinance(pDto.getPay_meth(), pDto.getTotal());
                        if (isFinanceUpdated) {
                            connection.commit();
                            result = true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

        return result;
    }
}
