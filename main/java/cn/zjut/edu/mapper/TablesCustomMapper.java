package cn.zjut.edu.mapper;
/*
 * @Author: Leafqun
 * @Time: 2017/8/4 13:47
 * @Description: 
 */

import cn.zjut.edu.dto.Tables;

import java.util.List;

public interface TablesCustomMapper {
    List<Tables> selectTablesByType(int tableType);
    List<Tables> selectAllTables();
    int selectTablesNum();
}
