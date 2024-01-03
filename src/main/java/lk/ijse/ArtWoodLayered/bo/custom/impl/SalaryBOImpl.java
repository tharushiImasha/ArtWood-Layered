package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.SalaryBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.SalaryDAO;
import lk.ijse.ArtWoodLayered.dto.SalaryDto;
import lk.ijse.ArtWoodLayered.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryBOImpl implements SalaryBO {

    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SALARY);

    @Override
    public String generateNextCustomerId() throws SQLException, ClassNotFoundException {
        return salaryDAO.generateNextId();
    }

    @Override
    public boolean saveSalary(String empId) throws SQLException, ClassNotFoundException {
        return salaryDAO.saveSalary(empId);
    }

    @Override
    public List<SalaryDto> getAllSalary() throws SQLException {
        List<Salary> salaries = salaryDAO.getAll();
        List<SalaryDto> salaryDtos = new ArrayList<>();

        for (Salary salary: salaries){
            salaryDtos.add(new SalaryDto(salary.getSalary_id(), salary.getAmount(), salary.getEmp_id()));
        }

        return salaryDtos;
    }
}
