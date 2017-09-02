package cn.zjut.edu.service.impl;
/*
 * @Author: Leafqun
 * @Time: 2017/8/4 14:18
 * @Description: 
 */

import cn.zjut.edu.dto.Tables;
import cn.zjut.edu.mapper.TablesCustomMapper;
import cn.zjut.edu.mapper.TablesMapper;
import cn.zjut.edu.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;
@Service("tablesService")
public class TablesServiceImpl implements TablesService {

    @Autowired
    public TablesMapper tablesMapper;
    @Autowired
    public TablesCustomMapper tablesCustomMapper;
    @Override
    public List<Tables> getTablesByType(int tableType) {
        return tablesCustomMapper.selectTablesByType(tableType);
    }

    @Override
    public List<Tables> getAllTables() {
        return tablesCustomMapper.selectAllTables();
    }

    @Override
    public int getTablesNum() {
        return tablesCustomMapper.selectTablesNum();
    }

    @Override
    public Tables getTables(int tablesId) {
        return tablesMapper.selectByPrimaryKey(tablesId);
    }

    @Override
    public int insertTables(Tables tables) {
        return tablesMapper.insert(tables);
    }

    @Override
    public int deleteTables(int tableId) {
        return tablesMapper.deleteByPrimaryKey(tableId);
    }

    @Override
    public int updateTables(Tables tables) {
        return tablesMapper.updateByPrimaryKey(tables);
    }
}
