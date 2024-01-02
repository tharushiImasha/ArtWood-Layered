package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.FinanceDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceDAOImpl implements FinanceDAO {
    @Override
    public boolean reduceFinance(String pay_method, double amount) throws SQLException {
        return SqlUtil.execute("UPDATE finance SET amount = amount - ? WHERE pay_method = ?", pay_method, amount);
    }

    @Override
    public boolean IncreaseFinance(String pay_method, double amount) throws SQLException {
        return SqlUtil.execute("UPDATE finance SET amount = amount + ? WHERE pay_method = ?", pay_method, amount);
    }

    @Override
    public double loadCash(String cash) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT amount FROM finance where pay_method = ?", cash);

        double amount = 0;

        if(resultSet.next()) {
            amount = Double.parseDouble(resultSet.getString(1));
        }

        return amount;
    }

    @Override
    public double loadCard(String card) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT amount FROM finance where pay_method = ?", card);

        double amount = 0;

        if(resultSet.next()) {
            amount = Double.parseDouble(resultSet.getString(1));
        }

        return amount;
    }

    @Override
    public boolean reduceFinanceOtherSalary(String pay_method, double amount) throws SQLException {
        return SqlUtil.execute("UPDATE finance SET amount = amount - ? WHERE pay_method = ?", pay_method, amount);
    }
}
