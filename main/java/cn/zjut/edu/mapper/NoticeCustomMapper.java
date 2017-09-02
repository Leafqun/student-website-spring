package cn.zjut.edu.mapper;
/*
 * @Author: Leafqun
 * @Time: 2017/7/13 17:21
 * @Description: 
 */

import cn.zjut.edu.dto.Notice;

import java.util.List;

public interface NoticeCustomMapper {
    List<Notice> getAllNotice();

    int countNotice();
}
