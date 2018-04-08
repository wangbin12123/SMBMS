package cn.tree.smbms.dao.user;

import java.util.List;

import cn.three.smbms.pojo.User;

public interface UserMapper {
	public int count();
	public List<User> getUserList();
}
