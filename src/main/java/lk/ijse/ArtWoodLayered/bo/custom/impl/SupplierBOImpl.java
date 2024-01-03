package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.SupplierBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.CustomerDAO;
import lk.ijse.ArtWoodLayered.dao.custom.SupplierDAO;
import lk.ijse.ArtWoodLayered.dto.SupplierDto;
import lk.ijse.ArtWoodLayered.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SUPPLIER);

    @Override
    public List<SupplierDto> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = supplierDAO.getAll();
        List<SupplierDto> supplierDtos = new ArrayList<>();

        for (Supplier supplier : suppliers){
            supplierDtos.add(new SupplierDto(supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getEmail()));
        }
        return supplierDtos;
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.save(new Supplier(dto.getId(), dto.getName(), dto.getAddress(), dto.getEmail()));
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.update(new Supplier(dto.getId(), dto.getName(), dto.getAddress(), dto.getEmail()));
    }

    @Override
    public SupplierDto searchSupplier(String id) throws SQLException {
        Supplier supplier = supplierDAO.search(id);

        SupplierDto supplierDto = new SupplierDto(supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getEmail());
        return supplierDto;
    }
}
