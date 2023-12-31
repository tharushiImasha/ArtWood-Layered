package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.ProductTypeBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.ProductTypeDAO;
import lk.ijse.ArtWoodLayered.dto.ProductTypeDto;
import lk.ijse.ArtWoodLayered.entity.ProductType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeBOImpl implements ProductTypeBO {

    ProductTypeDAO productTypeDAO = (ProductTypeDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.PRODUCT_TYPE);

    @Override
    public List<ProductTypeDto> getAllProduct() throws SQLException {
        List<ProductType> productTypes = productTypeDAO.getAll();
        List<ProductTypeDto> productTypeDtos = new ArrayList<>();

        for (ProductType productType: productTypes) {
            productTypeDtos.add(new ProductTypeDto(productType.getProduct_id(), productType.getProduct_name(), productType.getQuality(), productType.getWood_type(), productType.getPrice()));
        }
        return productTypeDtos;
    }

    @Override
    public String getName(String productId) throws SQLException {
        return productTypeDAO.getName(productId);
    }

    @Override
    public double getPrice(String productId) throws SQLException {
        return productTypeDAO.getPrice(productId);
    }

    @Override
    public String getType(String productId) throws SQLException {
        return productTypeDAO.getType(productId);
    }

    @Override
    public String getQuality(String productId) throws SQLException {
        return productTypeDAO.getQuality(productId);
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException {
        return productTypeDAO.delete(id);
    }

    @Override
    public boolean saveProduct(ProductTypeDto dto) throws SQLException {
        return productTypeDAO.save(new ProductType(dto.getProduct_id(), dto.getProduct_name(), dto.getQuality(), dto.getWood_type(), dto.getPrice()));
    }

    @Override
    public boolean updateProduct(ProductTypeDto dto) throws SQLException {
        return productTypeDAO.update(new ProductType(dto.getProduct_id(), dto.getProduct_name(), dto.getQuality(), dto.getWood_type(), dto.getPrice()));
    }

    @Override
    public ProductTypeDto searchProduct(String id) throws SQLException {
        ProductType productType = productTypeDAO.search(id);
        ProductTypeDto productTypeDto = new ProductTypeDto(productType.getProduct_id(), productType.getProduct_name(), productType.getQuality(), productType.getWood_type(), productType.getPrice());

        return productTypeDto;
    }
}
