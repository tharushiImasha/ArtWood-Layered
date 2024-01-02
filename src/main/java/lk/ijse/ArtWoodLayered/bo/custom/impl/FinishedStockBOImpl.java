package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.FinishedStockBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.FinishedStockDAO;
import lk.ijse.ArtWoodLayered.dto.FinishedStockDto;
import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;
import lk.ijse.ArtWoodLayered.entity.FinishedStock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinishedStockBOImpl implements FinishedStockBO {

    FinishedStockDAO finishedStockDAO = (FinishedStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINISHED_STOCK);

    @Override
    public List<FinishedStockDto> getAllFinishedStock() throws SQLException {
        List<FinishedStock> finishedStocks = finishedStockDAO.getAll();
        List<FinishedStockDto> finishedStockDtos =new ArrayList<>();

        for (FinishedStock finishedStock : finishedStocks){
            finishedStockDtos.add(new FinishedStockDto(finishedStock.getFinished_id(), finishedStock.getAmount(), finishedStock.getProduct_id()));
        }
        return finishedStockDtos;
    }

    @Override
    public List<FinishedStockDto> getAllFinishedStockForCombo() throws SQLException {
        return finishedStockDAO.getAllFinishedStockForCombo();
    }

    @Override
    public boolean deleteFinished(String id) throws SQLException {
        return finishedStockDAO.delete(id);
    }

    @Override
    public String generateNextFinishedId() throws SQLException, ClassNotFoundException {
        return finishedStockDAO.generateNextId();
    }

    @Override
    public boolean updateFinishedFromP(String finished_id) throws SQLException {
        return finishedStockDAO.updateFinishedFromP(finished_id);
    }

    @Override
    public int getFinishedCount() throws SQLException {
        return finishedStockDAO.getFinishedCount();
    }

    @Override
    public int getProductCountByType(String type) throws SQLException {
        return finishedStockDAO.getProductCountByType(type);
    }

    @Override
    public boolean saveFinished(FinishedStockDto dto) throws SQLException {
        return finishedStockDAO.save(new FinishedStock(dto.getFinished_id(), dto.getAmount(), dto.getProduct_id()));
    }

    @Override
    public boolean updateFinished(FinishedStockDto dto) throws SQLException {
        return finishedStockDAO.update(new FinishedStock(dto.getFinished_id(), dto.getAmount(), dto.getProduct_id()));
    }

    @Override
    public FinishedStockDto searchFinished(String id) throws SQLException {
        FinishedStock finishedStock = finishedStockDAO.search(id);
        FinishedStockDto finishedStockDto = new FinishedStockDto(finishedStock.getFinished_id(), finishedStock.getAmount(), finishedStock.getProduct_id());
        return finishedStockDto;
    }

    @Override
    public boolean updateItem(List<OrderTm> tmList) throws SQLException {
        return finishedStockDAO.updateItem(tmList);
    }

    @Override
    public boolean updateQty(OrderTm cartTm) throws SQLException {
        return finishedStockDAO.updateQty(cartTm);
    }
}
