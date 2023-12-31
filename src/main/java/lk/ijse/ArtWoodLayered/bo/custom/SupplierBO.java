package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierBO extends SuperBO {
    List<SupplierDto> getAllSuppliers() throws SQLException;

    boolean deleteSupplier(String id) throws SQLException;

    boolean saveSupplier(SupplierDto dto) throws SQLException;

    boolean updateSupplier(SupplierDto dto) throws SQLException;

    SupplierDto searchSupplier(String id) throws SQLException;
}
