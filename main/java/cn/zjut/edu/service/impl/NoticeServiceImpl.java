package cn.zjut.edu.service.impl;

import cn.zjut.edu.dto.Notice;
import cn.zjut.edu.mapper.NoticeCustomMapper;
import cn.zjut.edu.mapper.NoticeMapper;
import cn.zjut.edu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Leafqun on 2017/5/15.
 */
@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeCustomMapper noticeCustomMapper;
    @Override
    public List<Notice> getAllNotice() {
        return noticeCustomMapper.getAllNotice();
    }

    @Override
    public int insert(Notice notice) {
        return noticeMapper.insert(notice);
    }

    @Override
    public int update(Notice notice) {
        return noticeMapper.updateByPrimaryKeyWithBLOBs(notice);
    }

    @Override
    public int delete(Integer noticeId) {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }

    @Override
    public Notice selectNotice(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Override
    public int getNoticeNum() {
        return noticeCustomMapper.countNotice();
    }
}
