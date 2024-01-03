package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.SalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface SalaryBO extends SuperBO {
    String generateNextCustomerId() throws SQLException, ClassNotFoundException;

    boolean saveSalary(String empId) throws SQLException, ClassNotFoundException;

    List<SalaryDto> getAllSalary() throws SQLException;
}
