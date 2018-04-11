package cn.three.smbms.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	public int add(User user);
	public int modify(User user);
	//修改用户密码
	public int updatePwd(@Param("id")Integer id,@Param("userPassword")String userPassword);
	public int deleteUserById(Integer id);
	//一对一
	public List<User> getUserListByRole(Integer roleid);
}
