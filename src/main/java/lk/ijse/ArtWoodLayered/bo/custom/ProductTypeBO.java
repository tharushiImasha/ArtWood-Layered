package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.ProductTypeDto;

import java.sql.SQLException;
import java.util.List;

public interface ProductTypeBO extends SuperBO {
    List<ProductTypeDto> getAllProduct() throws SQLException;

    String getName(String productId) throws SQLException;

    double getPrice(String productId) throws SQLException;

    String getType(String productId) throws SQLException;

    String getQuality(String productId) throws SQLException;

    boolean deleteProduct(String id) throws SQLException;

    boolean saveProduct(ProductTypeDto dto) throws SQLException;

    boolean updateProduct(ProductTypeDto dto) throws SQLException;

    ProductTypeDto searchProduct(String id) throws SQLException;
}
