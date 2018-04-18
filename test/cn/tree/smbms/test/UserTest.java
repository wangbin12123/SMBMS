package cn.tree.smbms.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.three.smbms.dao.user.UserMapper;
import cn.three.smbms.pojo.Address;
import cn.three.smbms.pojo.User;
import cn.three.smbms.utils.MyBatisUtil;


public class UserTest {
	private Logger logger = Logger.getLogger(UserTest.class);
	@Test
	public void TestCount() {
		String resource = "mybatis-config.xml";
		int count = 0;
		SqlSession session = null;
		try {
			//读取核心配置文件
			InputStream is = Resources.getResourceAsStream(resource);
			//
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//
			session = factory.openSession();
			//count = session.selectOne("cn.tree.smbms.dao.user.UserMapper.count");
			count = session.getMapper(UserMapper.class).count();
			logger.debug("\n"+"User count--->"+count);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//关闭session
			session.close();
		}
	}
	@Test
	public void TestCount2() {
		int count = 0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			count = session.selectOne("cn.tree.smbms.dao.user.UserMapper.count");
			logger.debug("\n"+"User count--->"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//关闭session
			MyBatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void TestList() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			list = session.selectList("cn.tree.smbms.dao.user.UserMapper.getUserList");
			//使用接口方式实现查询
			//list = session.getMapper(UserMapper.class).getUserList();
			for (User user : list) {
				logger.debug("username\t\t"+user.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//模糊查询
	public void TestList2() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			//list = session.selectList("cn.tree.smbms.dao.user.UserMapper.getUserListByName","孙");
			//使用接口方式实现查询
			list = session.getMapper(UserMapper.class).getUserListByName("孙");
			for (User user : list) {
				logger.debug("username\t\t"+user.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//查询userRole=1的值
	public void TestList3() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserRole",1);
			//使用接口方式实现查询
			//list = session.getMapper(UserMapper.class).getUserRole(1);
			for (User user : list) {
				logger.debug("username\t\t"+user.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//多条件查询
	public void TestList4() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Map<String,String> map = new HashMap<String,String>();
			map.put("name","赵");
			map.put("role","3");
			//
			list = session.selectList("cn.tree.smbms.dao.user.UserMapper.getUserListByMap",map);
			list=session.getMapper(UserMapper.class).getUserListByMap(map);
			//使用接口方式实现查询
			//list = session.getMapper(UserMapper.class).getUserRole(1);
			for (User user : list) {
				logger.debug("username\t\t"+user.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//实体类查询
	public void TestList5() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setUserName("张");
			user.setUserRole(3);
			//list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserListByMap2",user);
			//使用接口方式实现查询
			list = session.getMapper(UserMapper.class).getUserListByMap2(user);
			for (User u : list) {
				logger.debug("username\t\t"+u.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//结果集查询
	public void TestList6() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setUserName("张");
			user.setUserRole(3);
			//list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserList2",user);
			//使用接口方式实现查询
			list = session.getMapper(UserMapper.class).getUserList2(user);
			for (User u : list) {
				logger.debug("username\t\t"+u.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//增加数据测试
	public void TestList7() {
		int count=0;  //所影响的行数
		ArrayList<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setUserName("路飞");
			user.setUserCode("lufei");
			user.setUserPassword("456798");
			user.setGender(1);
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-10");
			user.setBirthday(birthday);
			user.setPhone("1200012");
			user.setAddress("东海");
			user.setUserRole(2);
			user.setCreatedBy(1);
			user.setCreationDate(new Date());
			user.setModifyBy(1);
			user.setModifyDate(new Date());
			//count = session.insert("cn.three.smbms.dao.user.UserMapper.add",user);
			//使用接口方式实现查询
			count = session.getMapper(UserMapper.class).add(user);
			session.commit();
			for (User u : list) {
				logger.debug("username\t\t"+u.getUserName());
			}
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	//更新数据测试
	public void TestList8() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setId(22);
			user.setUserName("山治");
			user.setUserCode("sanzhi");
			user.setUserPassword("445566");
			//count = session.update("cn.three.smbms.dao.user.UserMapper.modify",user);
			//使用接口方式实现查询
			count = session.getMapper(UserMapper.class).modify(user);
			session.commit();
			logger.debug("updateCount\t\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//使用注解传参
	public void TestList9() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			String pwd = "55555";
			Integer id =18;
			//使用接口方式实现查询
			count = session.getMapper(UserMapper.class).updatePwd(id, pwd);
			session.commit();
			logger.debug("updateCount\t\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//删除数据测试
	public void TestList10() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer id =26;
			//count = session.delete("cn.three.smbms.dao.user.UserMapper.deleteUserById",id);
			//使用接口方式实现查询
			count = session.getMapper(UserMapper.class).deleteUserById(id);
			session.commit();
			logger.debug("deleteCount\t\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//一对一测试
	public void TestList11() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer roleid =2;
			//list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserListByRole",roleid);
			//使用接口方式实现查询
			list = session.getMapper(UserMapper.class).getUserListByRole(roleid);
			session.commit();
			for (User user2 : list) {
				logger.debug("userCode\t"+user2.getUserCode()+"\tuserName\t"+user2.getUserName()+"\tuserRole\t"+user2.getUserRole()+"\troleName\t"+user2.getRole().getRoleName()+"\t角色编码"+user2.getRole().getRoleCode());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//一对多测试
	public void TestList12() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer userid =1;
			list = session.selectList("cn.three.smbms.dao.user.UserMapper.getAddressListByUser",userid);
			//使用接口方式实现查询
			//list = session.getMapper(UserMapper.class).getAddressListByUser(userid);
			session.commit();
			for (User user2 : list) {
				logger.debug("userCode\t"+user2.getUserCode()+"\tuserName\t"+user2.getUserName()+"userPassword\t"+user2.getUserPassword());
				for(Address a : user2.getAddressList()) {
					logger.debug("addressDesc\t"+a.getAddressDesc());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	/*@Test
	
	public void TestList13() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			//list = session.selectList("cn.three.smbms.dao.user.UserMapper.getAddressListByUser",userid);
			//使用接口方式实现查询
			list = session.getMapper(UserMapper.class).getUserList3("",2);
			for (User u : list) {
				logger.debug("userName\t"+u.getUserName()+"userPassword\t"+u.getUserPassword()+"userRole\t"+u.getUserRole());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}*/
	@Test
	/**
	 * if-where-trim
	 */
	public void TestList13() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			//使用接口方式实现查询
			list = session.getMapper(UserMapper.class).getUserList5("孙",null);
			for (User u : list) {
				logger.debug("userName\t"+u.getUserName()+"userPassword\t"+u.getUserPassword()+"userRole\t"+u.getUserRole());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//if-set更新数据测试
	public void TestList14() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setId(24);
			user.setUserCode("TestUpdate2");
			//使用接口方式实现查询
			count = session.getMapper(UserMapper.class).modify2(user);
			session.commit();
			logger.debug("updateCount\t\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//trim更新数据测试
	public void TestList15() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setId(25);
			user.setUserCode("TestUpdate3");
			//使用接口方式实现查询
			count = session.getMapper(UserMapper.class).modify3(user);
			session.commit();
			logger.debug("updateCount\t\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//foreach list集合查询
	public void TestList16() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			List<Integer> rlist = new ArrayList<Integer>();
			rlist.add(2);
			rlist.add(3);
			list= session.getMapper(UserMapper.class).getUserListByRole_list(rlist);
			for (User u : list) {
				logger.debug("UserName\t"+u.getUserName()+"userCode"+u.getUserCode());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//foreach array数组查询
	public void TestList17() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer[] aee = {2,3}; 
			list= session.getMapper(UserMapper.class).getUserListByRole_array(aee);
			for (User u : list) {
				logger.debug("UserName\t"+u.getUserName()+"userCode"+u.getUserCode());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//foreach map集合查询
	public void TestList18() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Map<String,Object> map = new HashMap<String,Object>();
			List<Integer> rlist = new ArrayList<Integer>();
			rlist.add(2);
 			rlist.add(3);
 			map.put("gender",1);
 			map.put("roleList",rlist);
 			//map.put("rlist",rlist);//单参数也可以封装map
			list= session.getMapper(UserMapper.class).getUserListByRole_map(map);
			for (User u : list) {
				logger.debug("UserName\t"+u.getUserName()+"userCode"+u.getUserCode());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//foreach map集合查询
	public void TestList19() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			String userName = "";
			String userCode = "lu";
			Integer userRole = 2;
			Date creationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01");
			list = session.getMapper(UserMapper.class).getUserList_choose(userName, userRole, userCode, creationDate);
			for (User u : list) {
				logger.debug("UserName\t"+u.getUserName()+"userCode"+u.getUserCode()
				+"userRole\t"+u.getUserRole()+"\t"+"creationDate\t"+u.getCreationDate());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//分页查询
	public void TestList20() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer from = 0;
			Integer pageSize = 5;
			list = session.getMapper(UserMapper.class).getUserList_page(from, pageSize);
			for (User u : list) {
				logger.debug("userName\t"+u.getUserName()+"\t"+"userCode"+u.getUserCode()+"\t"
				+"userRole\t"+u.getUserRole()+"\t"+"creationDate\t"+u.getCreationDate());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
}
