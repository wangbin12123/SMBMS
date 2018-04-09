package cn.three.smbms.dao.user;

import java.util.List;
import java.util.Map;

import cn.three.smbms.pojo.User;

public interface UserMapper {
	public int count();
	//查询用户列表
	public List<User> getUserList();
	//根据用户名模糊查询获得用户列表
	public List<User> getUserListByName(String name);
	public List<User> getUserRole(int id);
	public List<User> getUserListByMap(Map map);
	public List<User> getUserListByMap2(User user);
	public List<User> getUserList2(User user);
}
