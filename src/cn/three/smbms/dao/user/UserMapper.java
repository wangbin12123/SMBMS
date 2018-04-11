package cn.three.smbms.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	public int add(User user);
	public int modify(User user);
	//�޸��û�����
	public int updatePwd(@Param("id")Integer id,@Param("userPassword")String userPassword);
	public int deleteUserById(Integer id);
	//һ��һ
	public List<User> getUserListByRole(Integer roleid);
}
