package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean employeeAvailability(String emp_id, String availability) throws SQLException;

    String getName(String job) throws SQLException;

    boolean deleteEmployee(String empId) throws SQLException;

    boolean saveUser(EmployeeDto dto) throws SQLException;

    boolean updateEmployee(EmployeeDto dto) throws SQLException;

    EmployeeDto searchEmployee(String empId) throws SQLException;

    List<EmployeeDto> getAllEmployees() throws SQLException;

    List<EmployeeDto> getAllEmployeesForCombo() throws SQLException;
}
