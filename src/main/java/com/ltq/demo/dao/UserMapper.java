package com.ltq.demo.dao;

import com.ltq.demo.entity.User;
import com.ltq.demo.entity.InUser;
import com.ltq.demo.core.MybatisDao;

/**
 * 数据访问接口
 * @author admin
 * @since 2019年9月22日
 */
public interface UserMapper extends MybatisDao<User,InUser,Integer> {



}
