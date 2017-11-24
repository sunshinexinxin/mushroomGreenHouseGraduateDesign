package com.hbkd.hyx.app.login.dao.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.dao.UserDao;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;


/**
 * @author anke
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    protected final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User getUserByName(String name) {
        // sql语句，传入一个参数，后台查询后返回；
        logger.info("SQL_ID：UserMapper.getUserByName 获取用户个人身份信息");
        User user = getSqlSession().selectOne("UserMapper.getUserByName", name);
        return user;
    }

    @Override
    public Integer getUserCountByName(String name) {
        logger.info("SQL_ID：UserMapper.getUserCountByName 根据用户名统计用户数量");
        Integer rs = getSqlSession().selectOne("UserMapper.getUserCountByName", name);
        return rs;
    }

//	public List<User> getUserList(List<String> list) {
//		List<User> userList = new ArrayList<>();
//		logger.info("SQL_ID：UserMapper.getUserFamiList");
////		userList = getSqlSession().selectList("UserMapper.getUserFamiList", list);
//		return userList;
//	}
}
