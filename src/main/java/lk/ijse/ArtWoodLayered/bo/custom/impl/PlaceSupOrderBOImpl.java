package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.PlaceSupOrderBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.FinanceDAO;
import lk.ijse.ArtWoodLayered.dao.custom.SupOrderDAO;
import lk.ijse.ArtWoodLayered.dao.custom.SupOrderDetailDAO;
import lk.ijse.ArtWoodLayered.db.DbConnection;
import lk.ijse.ArtWoodLayered.dto.SupOrderDto;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceSupOrderBOImpl implements PlaceSupOrderBO {

    SupOrderDAO supOrderDAO = (SupOrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SUP_ORDER);
    SupOrderDetailDAO supOrderDetailDAO = (SupOrderDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SUP_ORDER_DETAIL);
    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINANCE);

    @Override
    public boolean placeSupOrder(SupOrderDto pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = supOrderDAO.save(pDto.getSup_order_id(), pDto.getPrice(), pDto.getType(), pDto.getSup_id());
            if (isOrderSaved) {

                boolean isOrderDetailSaved = supOrderDetailDAO.saveSupOrderDetail(pDto.getSup_order_id(), pDto.getTmList());

                if(isOrderDetailSaved) {
                    boolean isFinanceUpdated = financeDAO.reduceFinance(pDto.getPay_meth(), pDto.getPrice());

                    if (isFinanceUpdated) {
                        System.out.println(isFinanceUpdated);
                        connection.commit();
                        result = true;
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
