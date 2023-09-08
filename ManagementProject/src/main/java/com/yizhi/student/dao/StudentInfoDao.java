package com.yizhi.student.dao;

import com.yizhi.student.domain.StudentInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * `
 * 生基础信息表
 *
 * @author dunhf
 * @email 499345515@qq.com
 * @date 2019-08-01 09:45:46
 */
@Mapper
public interface StudentInfoDao {

    StudentInfoDO get(Integer id);

    List<StudentInfoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StudentInfoDO studentInfo);

    /**
     * 更新数据
     *
     * @param studentInfo 封装了要更新的数据
     * @return 返回更新的行数
     */
    int update(StudentInfoDO studentInfo);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
