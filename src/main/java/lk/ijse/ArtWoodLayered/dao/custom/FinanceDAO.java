package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.SuperDAO;

import java.sql.SQLException;

public interface FinanceDAO extends SuperDAO {
    boolean reduceFinance(String pay_method, double amount) throws SQLException;

    boolean IncreaseFinance(String pay_method, double amount) throws SQLException ;

    double loadCash(String cash) throws SQLException;

    double loadCard(String card) throws SQLException;

    boolean reduceFinanceOtherSalary(String pay_method, double amount) throws SQLException;
}
