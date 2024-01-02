package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.dto.LogsDto;
import lk.ijse.ArtWoodLayered.entity.Logs;

import java.sql.SQLException;
import java.util.List;

public interface LogStockDAO extends CrudDAO<Logs> {
    int getLogCount() throws SQLException;
    List<LogsDto> getAllLogsForCombo() throws SQLException;
    boolean reduce(String log_id) throws SQLException;
}
