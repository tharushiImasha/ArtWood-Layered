package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.FinanceBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.FinanceDAO;

import java.sql.SQLException;

public class FinanceBOImpl implements FinanceBO {

    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINANCE);

    @Override
    public boolean reduceFinance(String pay_method, double amount) throws SQLException {
        return financeDAO.reduceFinance(pay_method, amount);
    }

    @Override
    public boolean IncreaseFinance(String pay_method, double amount) throws SQLException {
        return financeDAO.IncreaseFinance(pay_method, amount);
    }

    @Override
    public double loadCash(String cash) throws SQLException {
        return financeDAO.loadCash(cash);
    }

    @Override
    public double loadCard(String card) throws SQLException {
        return financeDAO.loadCard(card);
    }

    @Override
    public boolean reduceFinanceOtherSalary(String pay_method, double amount) throws SQLException {
        return financeDAO.reduceFinanceOtherSalary(pay_method, amount);
    }
}
