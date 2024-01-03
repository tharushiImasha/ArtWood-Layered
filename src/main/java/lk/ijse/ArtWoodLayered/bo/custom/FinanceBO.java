package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;

import java.sql.SQLException;

public interface FinanceBO extends SuperBO {
    boolean reduceFinance(String pay_method, double amount) throws SQLException;

    boolean IncreaseFinance(String pay_method, double amount) throws SQLException;

    double loadCash(String cash) throws SQLException;

    double loadCard(String card) throws SQLException;

    boolean reduceFinanceOtherSalary(String pay_method, double amount) throws SQLException;
}
