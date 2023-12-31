package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.dto.EmployeeDto;
import lk.ijse.ArtWoodLayered.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {
    boolean employeeAvailability(String emp_id, String availability) throws SQLException;
    String getName(String job) throws SQLException;
    List<EmployeeDto> getAllEmployeesForCombo() throws SQLException;
}
