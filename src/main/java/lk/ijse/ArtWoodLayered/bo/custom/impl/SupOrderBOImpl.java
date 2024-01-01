package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.SupOrderBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.SupOrderDAO;

import java.sql.SQLException;

public class SupOrderBOImpl implements SupOrderBO {

    SupOrderDAO supOrderDAO = (SupOrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SUP_ORDER);

    @Override
    public boolean saveOrder(String supOrderId, double price, String type, String supId) throws SQLException {
        return supOrderDAO.save(supOrderId, price, type, supId);
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return supOrderDAO.generateNextId();
    }
}
