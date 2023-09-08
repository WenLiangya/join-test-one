package com.yizhi.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.yizhi.student.dao.StudentInfoDao;
import com.yizhi.student.domain.StudentInfoDO;
import com.yizhi.student.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class StudentInfoServiceImpl implements StudentInfoService {


    @Autowired
    private StudentInfoDao studentInfoDao;

    @Override
    public StudentInfoDO get(Integer id) {
        System.out.println("======service层中传递过来的id参数是：" + id + "======");
        return studentInfoDao.get(id);
    }


    @Override
    public List<StudentInfoDO> list(Map<String, Object> map) {
        int currPage = Integer.parseInt(map.get("currPage").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int offset = (currPage-1)*pageSize;
        int limit = pageSize;
        map.put("offset",offset);
        map.put("limit",limit);
        return studentInfoDao.list(map);
    }

    //"===================================================================================="


    @Override
    public int count(Map<String, Object> map) {
        return studentInfoDao.count(map);
    }

    @Override
    public int save(StudentInfoDO studentInfo) {
        //设置添加时间,当前时间
        studentInfo.setAddTime(new Date());
        studentInfo.setAddUserid(1);
        return studentInfoDao.save(studentInfo);
    }

    /**
     * 更新数据
     *
     * @param studentInfo 封装了要更新的数据
     * @return 返回更新的行数
     */
    @Override
    public int update(StudentInfoDO studentInfo) {
        //设置更新时间,当前时间
        studentInfo.setEditTime(new Date());
        studentInfo.setEditUserid(1);
        return studentInfoDao.update(studentInfo);
    }

    @Override
    public int remove(Integer id) {
        return studentInfoDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return studentInfoDao.batchRemove(ids);
    }

}
