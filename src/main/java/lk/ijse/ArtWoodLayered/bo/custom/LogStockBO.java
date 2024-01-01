package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.LogsDto;

import java.sql.SQLException;
import java.util.List;

public interface LogStockBO extends SuperBO {
    List<LogsDto> getAllLogs() throws SQLException;

    List<LogsDto> getAllLogsForCombo() throws SQLException;

    boolean deleteLogs(String id) throws SQLException;

    String generateNextLogId() throws SQLException, ClassNotFoundException;


    int getLogCount() throws SQLException;

    boolean saveLogs(LogsDto dto) throws SQLException;

    boolean updateLogs(LogsDto dto) throws SQLException;

    LogsDto searchLogs(String id) throws SQLException;
}
