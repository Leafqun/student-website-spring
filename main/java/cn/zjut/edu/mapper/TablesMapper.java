package cn.zjut.edu.mapper;

import cn.zjut.edu.dto.Tables;

public interface TablesMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(Tables record);

    int insertSelective(Tables record);

    Tables selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Tables record);

    int updateByPrimaryKey(Tables record);
}