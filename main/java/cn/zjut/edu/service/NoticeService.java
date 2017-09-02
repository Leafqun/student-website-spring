package cn.zjut.edu.service;

import cn.zjut.edu.dto.Notice;

import java.util.List;

/**
 * Created by Leafqun on 2017/5/15.
 */
public interface NoticeService {
    public List<Notice> getAllNotice();
    public int insert(Notice notice);
    public int update(Notice notice);
    public int delete(Integer noticeId);
    public Notice selectNotice(Integer noticeId);
    public int getNoticeNum();
}
