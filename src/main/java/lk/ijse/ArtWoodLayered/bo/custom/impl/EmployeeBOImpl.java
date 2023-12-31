package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.EmployeeBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.EmployeeDAO;
import lk.ijse.ArtWoodLayered.dto.EmployeeDto;
import lk.ijse.ArtWoodLayered.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.EMPLOYEE);

    @Override
    public boolean employeeAvailability(String emp_id, String availability) throws SQLException {
        return employeeDAO.employeeAvailability(emp_id, availability);
    }

    @Override
    public String getName(String job) throws SQLException {
        return employeeDAO.getName(job);
    }

    @Override
    public boolean deleteEmployee(String empId) throws SQLException {
        return employeeDAO.delete(empId);
    }

    @Override
    public boolean saveUser(EmployeeDto dto) throws SQLException {
        return employeeDAO.save(new Employee(dto.getEmp_id(), dto.getName(), dto.getAddress(), dto.getTel(), dto.getStatus(), dto.getJob_role()));
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.update(new Employee(dto.getEmp_id(), dto.getName(), dto.getAddress(), dto.getTel(), dto.getStatus(), dto.getJob_role()));
    }

    @Override
    public EmployeeDto searchEmployee(String empId) throws SQLException {
        Employee employee = employeeDAO.search(empId);

        EmployeeDto employeeDto = new EmployeeDto(employee.getEmp_id(), employee.getName(), employee.getAddress(), employee.getTel(), employee.getStatus(), employee.getJob_role());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() throws SQLException {
        List<Employee> employees = employeeDAO.getAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee: employees) {
            employeeDtos.add(new EmployeeDto(employee.getEmp_id(), employee.getName(), employee.getAddress(), employee.getTel(), employee.getStatus(), employee.getJob_role()));
        }
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getAllEmployeesForCombo() throws SQLException {
        return employeeDAO.getAllEmployeesForCombo();
    }
}
