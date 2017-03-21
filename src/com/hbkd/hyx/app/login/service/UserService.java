package com.hbkd.hyx.app.login.service;

import com.hbkd.hyx.app.login.bean.User;

import javax.xml.ws.ServiceMode;

//import java.util.List;

@ServiceMode
public interface UserService {

	public User getUserById(String id);

//	public List<User> getUserList(String id);
}
