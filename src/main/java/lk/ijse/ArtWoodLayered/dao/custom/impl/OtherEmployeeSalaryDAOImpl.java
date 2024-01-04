package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.OtherEmployeeSalaryDAO;
import lk.ijse.ArtWoodLayered.entity.OtherSalary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtherEmployeeSalaryDAOImpl implements OtherEmployeeSalaryDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.execute("SELECT other_salary_id FROM otherSalary");

        int max = 0;
        while (resultSet.next()){
            String x = resultSet.getString(1);
            String[] y = x.split("OSE");
            int id = Integer.parseInt(y[1]);

            if (max < id){
                max = id;
            }

        }

        return "OSE" + ++max;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM otherSalary WHERE other_salary_id = ?", id);
    }

    @Override
    public List<OtherSalary> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM otherSalary");

        List<OtherSalary> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            double amount = Double.parseDouble(resultSet.getString(2));
            String emp_id = resultSet.getString(3);

            var dto = new OtherSalary(id, amount, emp_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(OtherSalary entity) throws SQLException {
        return SqlUtil.execute("INSERT INTO otherSalary VALUES(?, ?, ?)", entity.getOther_salary_id(), entity.getAmount(), entity.getEmp_id());
    }

    @Override
    public boolean update(OtherSalary entity) throws SQLException {
        return SqlUtil.execute("UPDATE otherSalary SET emp_id = ?, amount = ? WHERE other_salary_id = ?", entity.getEmp_id(), entity.getAmount(), entity.getOther_salary_id());
    }

    @Override
    public OtherSalary search(String tel) throws SQLException {
        return null;
    }

    @Override
    public boolean saveSalary(String empId, double amount) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO otherSalary VALUES(?, ?, ?)", generateNextId(), amount, empId);
    }
}
