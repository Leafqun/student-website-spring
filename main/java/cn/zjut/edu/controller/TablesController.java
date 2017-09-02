package cn.zjut.edu.controller;

import cn.zjut.edu.common.constant;
import cn.zjut.edu.dto.Tables;
import cn.zjut.edu.service.TablesService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Leafqun
 * @Time: 2017/8/4 14:35
 * @Description: 
 */
@RestController
@RequestMapping("/Tables")
public class TablesController {
    @Autowired
    public TablesService tablesService;
    @RequestMapping(value = "getTablesByType", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> getTablesByType(int tablesType){
        Map<String,Object> map = new HashMap<>();
        List<Tables> tablesList = tablesService.getTablesByType(tablesType);
        map.put("tablesList",tablesList);
        return map;
    }
    @RequestMapping( value = "getTables", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> getTables(@RequestParam("pageNum") Integer pageNum){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,15);
        List<Tables> tablesList = tablesService.getAllTables();
        map.put("tablesList",tablesList);
        return map;
    }
    @RequestMapping("getTablesNum")
    public Map<String,Object> getTablesNum(){
        Map<String,Object> map = new HashMap<>();
        int tablesNum = tablesService.getTablesNum();
        map.put("tablesNum",tablesNum);
        return map;
    }
    @RequestMapping(value = "insertTables" , method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> insertTables(@RequestParam("file") MultipartFile tfile) throws IOException {
        Map<String,Object> map = new HashMap<>();
        if (!tfile.isEmpty()&&tfile.getSize()>0) {
            String filename = tfile.getOriginalFilename();
            Tables tables =new Tables();
            if (filename != null || !filename.isEmpty()) {
                File newFile = new File(constant.FILE_PATH + filename);
                newFile.createNewFile();
                tfile.transferTo(newFile);
                tables.setTableFile(filename);
                tablesService.insertTables(tables);
            }
        }
        map.put("msg","success");
        return map;
    }
    @RequestMapping(value = "insertTablesBatch" , method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> insertTablesBatch(@RequestParam("file") MultipartFile[] tfiles) throws IOException {
        Map<String,Object> map = new HashMap<>();
        for(MultipartFile tfile : tfiles) {
            if (!tfile.isEmpty()) {
                String filename = tfile.getOriginalFilename();
                Tables tables =new Tables();
                if (filename != null || !filename.trim().equals("")) {
                    File newFile = new File(constant.FILE_PATH + filename);
                    newFile.createNewFile();
                    tfile.transferTo(newFile);
                    tables.setTableFile(filename);
                    tablesService.insertTables(tables);
                }
            }
        }
        map.put("msg","success");
        return map;
    }
    @RequestMapping(value="/deleteTables",method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> deleteNotice(@RequestParam("tableId") Integer tableId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(tableId == null) {
            map.put("msg","error");
        }else{
            Tables tables = tablesService.getTables(tableId);
            String filename = tables.getTableFile();
            if(filename!=null){
                File oldFile=new File(constant.FILE_PATH+filename);
                oldFile.delete();
            }
            tablesService.deleteTables(tableId);
            map.put("msg","success");
        }
        return map;
    }
}
