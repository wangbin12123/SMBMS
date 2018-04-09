package cn.three.smbms.dao.user;

import java.util.List;
import java.util.Map;

import cn.three.smbms.pojo.User;

public interface UserMapper {
	public int count();
	//��ѯ�û��б�
	public List<User> getUserList();
	//�����û���ģ����ѯ����û��б�
	public List<User> getUserListByName(String name);
	public List<User> getUserRole(int id);
	public List<User> getUserListByMap(Map map);
	public List<User> getUserListByMap2(User user);
	public List<User> getUserList2(User user);
}
