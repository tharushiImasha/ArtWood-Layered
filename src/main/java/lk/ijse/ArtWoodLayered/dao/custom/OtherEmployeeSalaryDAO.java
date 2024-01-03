package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.entity.OtherSalary;

import java.sql.SQLException;

public interface OtherEmployeeSalaryDAO extends CrudDAO<OtherSalary> {
    boolean saveSalary(String empId, double amount) throws SQLException, ClassNotFoundException;
}
