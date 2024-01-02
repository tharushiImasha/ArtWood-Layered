package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.FinishedStockDto;
import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;

import java.sql.SQLException;
import java.util.List;

public interface FinishedStockBO extends SuperBO {
    List<FinishedStockDto> getAllFinishedStock() throws SQLException;

    List<FinishedStockDto> getAllFinishedStockForCombo() throws SQLException;

    boolean deleteFinished(String id) throws SQLException;

    String generateNextFinishedId() throws SQLException, ClassNotFoundException;

    boolean updateFinishedFromP(String finished_id) throws SQLException;

    int getFinishedCount() throws SQLException;

    int getProductCountByType(String type) throws SQLException;

    boolean saveFinished(FinishedStockDto dto) throws SQLException;

    boolean updateFinished(FinishedStockDto dto) throws SQLException;

    FinishedStockDto searchFinished(String id) throws SQLException;

    boolean updateItem(List<OrderTm> tmList) throws SQLException;

    boolean updateQty(OrderTm cartTm) throws SQLException;
}
