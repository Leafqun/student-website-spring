package cn.zjut.edu.service;
/*
 * @Author: Leafqun
 * @Time: 2017/8/4 14:15
 * @Description: 
 */

import cn.zjut.edu.dto.Tables;

import java.util.List;

public interface TablesService {
    List<Tables> getTablesByType(int tableType);
    List<Tables> getAllTables();
    int getTablesNum();
    Tables getTables(int tablesId);
    int insertTables(Tables tables);
    int deleteTables(int tableId);
    int updateTables(Tables tables);
}
