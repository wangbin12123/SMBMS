package cn.three.smbms.dao.user;

import java.util.Date;
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
	public int modify2(User user);
	public int modify3(User user);
	//�޸��û�����
	public int updatePwd(@Param("id")Integer id,@Param("userPassword")String userPassword);
	public int deleteUserById(Integer id);
	//һ��һ
	public List<User> getUserListByRole(Integer roleid);
	public List<User> getAddressListByUser(Integer userid);
	//if
	public List<User> getUserList3(@Param("userName")String userName,@Param("userRole")Integer userRole);
	//if-where
	public List<User> getUserList4(@Param("userName")String userName,@Param("userRole")Integer userRole);
	//if-trim
	public List<User> getUserList5(@Param("userName")String userName,@Param("userRole")Integer userRole);
	//foreach array
	public List<User> getUserListByRole_array(Integer[] roleIds);
	//foreach list
	public List<User> getUserListByRole_list(List<Integer> roleList);
	//foreach map
	public List<User> getUserListByRole_map(Map<String,Object> map);
	//choose
	public List<User> getUserList_choose(@Param("userName")String userName,
										 @Param("userRole")Integer userRole,
										 @Param("userCode")String userCode,
										 @Param("creationDate")Date creationDate);
	//��ҳ
	public List<User> getUserList_page(@Param("from")Integer from,@Param("pageSize")Integer pageSize);;
}
