package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.OtherSalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface OtherEmployeeSalaryBO extends SuperBO {
    String generateNextSalaryId() throws SQLException, ClassNotFoundException;

    boolean saveSalary(String empId, double amount) throws SQLException, ClassNotFoundException;

    List<OtherSalaryDto> getAllSalary() throws SQLException;

    boolean updateSalary(OtherSalaryDto dto) throws SQLException;

    boolean deleteSalary(String salaryId) throws SQLException;
}
