package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.entity.PendingStock;

import java.sql.SQLException;

public interface PendingStockDAO extends CrudDAO<PendingStock> {
    int getPendingCount() throws SQLException;
}
