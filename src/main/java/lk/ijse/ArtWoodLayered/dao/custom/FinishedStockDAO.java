package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.dto.FinishedStockDto;
import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;
import lk.ijse.ArtWoodLayered.entity.FinishedStock;

import java.sql.SQLException;
import java.util.List;

public interface FinishedStockDAO extends CrudDAO<FinishedStock> {
    int getProductCountByType(String type) throws SQLException;
    List<FinishedStockDto> getAllFinishedStockForCombo() throws SQLException;

    boolean updateFinishedFromP(String finished_id) throws SQLException;

    boolean updateItem(List<OrderTm> tmList) throws SQLException;

    int getFinishedCount() throws SQLException;

    boolean updateQty(OrderTm cartTm) throws SQLException;
}
