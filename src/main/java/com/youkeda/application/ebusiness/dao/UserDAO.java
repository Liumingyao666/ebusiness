package com.youkeda.application.ebusiness.dao;

import com.youkeda.application.ebusiness.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 * 用户数据库操作
 */

@Mapper
public interface UserDAO {

    /**
     * 批量增加用户
     * @param userDOS
     * @return
     */
    int batchAdd(@Param("list") List<UserDO> userDOS);

    /**
     * 根据一组id批量查找
     * @param ids
     * @return
     */
    List<UserDO> findByIds(@Param("ids") List<Long> ids);

    /**
     * 新增用户
     * @param userDO
     * @return
     */
    int add(UserDO userDO);

    /**
     * 修改用户
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(@Param("id") long id);

    /**
     *根据用户名查找用户
     * @param name
     * @return
     */
    UserDO findByUserName(@Param("userName") String name);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserDO findByUserId(@Param("id") long id);
}


