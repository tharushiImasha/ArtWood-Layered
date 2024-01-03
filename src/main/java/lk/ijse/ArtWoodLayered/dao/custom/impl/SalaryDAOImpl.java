package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.SalaryDAO;
import lk.ijse.ArtWoodLayered.entity.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT salary_id FROM salary");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("SE");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "SE" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<Salary> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM salary");

        List<Salary> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            double amount = Double.parseDouble(resultSet.getString(2));
            String emp_id = resultSet.getString(3);

            var dto = new Salary(id, amount, emp_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(Salary dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO salary VALUES(?, ?, ?)", dto);
    }

    @Override
    public boolean update(Salary dto) throws SQLException {
        return false;
    }

    @Override
    public Salary search(String tel) throws SQLException {
        return null;
    }

    @Override
    public boolean saveSalary(String empId) throws SQLException, ClassNotFoundException {
        double amount = 2000;
        return SqlUtil.execute("INSERT INTO salary VALUES(?, ?, ?)", generateNextId(),amount, empId);

    }
}
