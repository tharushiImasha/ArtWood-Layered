package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.LogStockBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.LogStockDAO;
import lk.ijse.ArtWoodLayered.dto.LogsDto;
import lk.ijse.ArtWoodLayered.entity.Logs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogStockBOImpl implements LogStockBO {

    LogStockDAO logStockDAO = (LogStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.LOGS);

    @Override
    public List<LogsDto> getAllLogs() throws SQLException {
        List<Logs> logs = logStockDAO.getAll();
        List<LogsDto> logsDtos = new ArrayList<>();

        for (Logs logs1: logs) {
            logsDtos.add(new LogsDto(logs1.getLogs_id(), logs1.getWood_type(), logs1.getLog_amount()));
        }
        return logsDtos;
    }

    @Override
    public List<LogsDto> getAllLogsForCombo() throws SQLException {
        return logStockDAO.getAllLogsForCombo();
    }

    @Override
    public boolean deleteLogs(String id) throws SQLException {
        return logStockDAO.delete(id);
    }

    @Override
    public String generateNextLogId() throws SQLException, ClassNotFoundException {
        return logStockDAO.generateNextId();
    }

    @Override
    public int getLogCount() throws SQLException {
        return logStockDAO.getLogCount();
    }

    @Override
    public boolean saveLogs(LogsDto dto) throws SQLException {
        return logStockDAO.save(new Logs(dto.getLogs_id(), dto.getWood_type(), dto.getLog_amount()));
    }

    @Override
    public boolean updateLogs(LogsDto dto) throws SQLException {
        return logStockDAO.update(new Logs(dto.getLogs_id(), dto.getWood_type(), dto.getLog_amount()));
    }

    @Override
    public LogsDto searchLogs(String id) throws SQLException {
        Logs logs = logStockDAO.search(id);

        LogsDto logsDto = new LogsDto(logs.getLogs_id(), logs.getWood_type(), logs.getLog_amount());
        return logsDto;
    }
}
