package cn.zjut.edu.controller;

import cn.zjut.edu.common.constant;
import cn.zjut.edu.dto.Notice;
import cn.zjut.edu.service.NoticeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Leafqun on 2017/5/15.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    private final static Log log= LogFactory.getLog(NoticeController.class);
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value="/getHeadNotice")
    @ResponseBody
    public Map<String,Object> getHeadNotices(){
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(1,6);
        List<Notice> noticeList=noticeService.getAllNotice();
        map.put("noticeList",noticeList);
        log.info("成功获取首页的5条最新通知！！！");
        return map;
    }
    @RequestMapping(value="/getNotice",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getNotices(int pageNum){
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,15);
        List<Notice> noticeList=noticeService.getAllNotice();
        map.put("noticeList",noticeList);
        log.info("成功获取第"+pageNum+"页的10条通知！！！");
        return map;
    }
    @RequestMapping(value="/getNoticeNum",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getNoticeNum(){
        Map<String,Object> map=new HashMap<String,Object>();
        int num =noticeService.getNoticeNum();
        map.put("num",num);
        log.info("成功获取通知总数："+num+"！！！");
        return map;
    }
    @RequestMapping(value="/getNoticeContent")
    @ResponseBody
    public Map<String,Object> getNoticeContent(Integer noticeId){
        Map<String,Object> map=new HashMap<String, Object>();
        if(noticeId!=null) {
            Notice notice = noticeService.selectNotice(noticeId);
            map.put("notice",notice);
            log.info("成功读取noticeId="+notice.getNoticeId()+"的通知内容");
        }
        return map;
    }
    /*
    @RequestMapping(value="/getNoticeContent")
    public String getNoticeContent(String noticeId,Model model){
        if(noticeId!=null) {
            Notice notice = noticeService.selectNotice(noticeId);
            model.addAttribute("notice",notice);
            log.info("成功读取noticeId="+notice.getNoticeId()+"的通知内容");
        }
        return "notice";
    }*/
    @RequestMapping(value="/submitNotice",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> submitNotice(Notice notice, MultipartFile cfile) throws IOException {
        Map<String,Object> map=new HashMap<String,Object>();
        if(notice.getNoticeId()==null&&notice.getNoticeName()==null&&notice.getContent()==null) {
            map.put("msg","error");
            return map;
        }
        if(!cfile.isEmpty()&&cfile.getSize()>0){
            String filename=cfile.getOriginalFilename();
            if(filename!=null||!filename.isEmpty()){
                File newFile=new File(constant.FILE_PATH+filename);
                newFile.createNewFile();
                if(notice.getFile()!=null||!(notice.getFile().trim().equals(""))){
                    File oldFile=new File(constant.FILE_PATH+notice.getFile());
                    if(oldFile.exists()&&oldFile!=null) {
                        if(notice.getNoticeId()!=null) {
                            oldFile.delete();
                            log.info("成功删除noticeId=" + notice.getNoticeId() + "的旧文件");
                        }
                    }
                }
                cfile.transferTo(newFile);
                log.info("成功上传noticeId="+notice.getNoticeId()+"的新文件");
                notice.setFile(filename);
            }
        }
        notice.setNoticeTime(new Date());
        if(notice.getNoticeId()!=null) {
            noticeService.update(notice);
            map.put("msg","更改成功");
            log.info("成功更改通知！！！");
        }
        else {
            noticeService.insert(notice);
            map.put("msg","添加成功");
            log.info("成功添加通知！！！");
        }
        return map;
    }
   /* @RequestMapping(value="/submitNotice",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> submitNotice( Notice notice, String newFile) throws IOException {
        Map<String,Object> map=new HashMap<String,Object>();
        if(notice.getNoticeId()==null&&notice.getNoticeName()==null&&notice.getContent()==null) {
            map.put("msg","error");
            return map;
        }
        if(notice.getUserId()==null) {
            notice.setUserId(19);//测试用
        }
        String file = notice.getFile();
        if(newFile!=null||!newFile.trim().equals("")) {
            if (file != newFile) {
                if (file != null) {
                    File oldFile = new File(file);
                    oldFile.delete();
                    log.info("旧文件删除成功！！！");
                }
                notice.setFile(newFile);
            }
        }
        notice.setNoticeTime(new Date());
        if(notice.getNoticeId()!=null) {
            noticeService.update(notice);
            map.put("msg","更改成功");
            log.info("成功更改通知！！！");
        }
        else {
            noticeService.insert(notice);
            map.put("msg","添加成功");
            log.info("成功添加通知！！！");
        }
        return map;
    }
    @RequestMapping(value="/submitfile",method = {RequestMethod.POST})
    public Map<String,Object> submitFile(MultipartFile cfile) throws IOException {
        Map<String,Object> map=new HashMap<String,Object>();
        if(!cfile.isEmpty()){
            String filename=cfile.getOriginalFilename();
            if(filename!=null||!filename.trim().equals("")){
                File newFile=new File(constant.FILE_PATH+filename);
                cfile.transferTo(newFile);
                log.info("文件上传成功！！！");
                map.put("isSubmit",true);
            }
        }
        return map;
    }*/
    @RequestMapping(value="/deleteNotice")
    @ResponseBody
    public Map<String,Object> deleteNotice(Integer noticeId){
        Map<String,Object> map=new HashMap<String,Object>();
        if(noticeId==null) {
            map.put("msg","error");
        }else{
            Notice notice=noticeService.selectNotice(noticeId);
            String filename=notice.getFile();
            if(filename!=null){
                File oldFile=new File(constant.FILE_PATH+filename);
                oldFile.delete();
                log.info("成功删除noticeId="+noticeId+"的文件");
            }
            noticeService.delete(noticeId);
            map.put("msg","删除成功");
            log.info("成功删除通知！！！");
        }
        return map;
    }
    @RequestMapping(value="/deleteNoticeBatch")
    @ResponseBody
    public Map<String,Object> deleteNoticeBatch(@RequestParam("noticeId") int[] noticeIds){
        Map<String,Object> map=new HashMap<String,Object>();
        if(noticeIds==null) {
            map.put("msg","error");
        }else{
            for(int noticeId: noticeIds) {
                Notice notice = noticeService.selectNotice(noticeId);
                String filename = notice.getFile();
                if (filename != null) {
                    File oldFile = new File(constant.FILE_PATH + filename);
                    oldFile.delete();
                    log.info("成功删除noticeId=" + noticeId + "的文件");
                }
                noticeService.delete(noticeId);
            }
            map.put("msg","批量删除成功");
            log.info("成功批量删除通知！！！");
        }
        return map;
    }
}
