package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.OtherEmployeeSalaryBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.OtherEmployeeSalaryDAO;
import lk.ijse.ArtWoodLayered.dto.OtherSalaryDto;
import lk.ijse.ArtWoodLayered.entity.OtherSalary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtherEmployeeSalaryBOImpl implements OtherEmployeeSalaryBO {

    OtherEmployeeSalaryDAO otherEmployeeSalaryDAO = (OtherEmployeeSalaryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.OTHER_SALARY);

    @Override
    public String generateNextSalaryId() throws SQLException, ClassNotFoundException {
        return otherEmployeeSalaryDAO.generateNextId();
    }

    @Override
    public boolean saveSalary(String empId, double amount) throws SQLException, ClassNotFoundException {
        return otherEmployeeSalaryDAO.saveSalary(empId, amount);
    }

    @Override
    public List<OtherSalaryDto> getAllSalary() throws SQLException {
        List<OtherSalary> otherSalaries = otherEmployeeSalaryDAO.getAll();
        List<OtherSalaryDto> otherSalaryDtos = new ArrayList<>();

        for (OtherSalary otherSalary : otherSalaries){
            otherSalaryDtos.add(new OtherSalaryDto(otherSalary.getOther_salary_id(), otherSalary.getAmount(), otherSalary.getEmp_id()));
        }
        return otherSalaryDtos;
    }

    @Override
    public boolean updateSalary(OtherSalaryDto dto) throws SQLException {
        return otherEmployeeSalaryDAO.update(new OtherSalary(dto.getOther_salary_id(), dto.getAmount(), dto.getEmp_id()));
    }

    @Override
    public boolean deleteSalary(String salaryId) throws SQLException {
        return otherEmployeeSalaryDAO.delete(salaryId);
    }
}
