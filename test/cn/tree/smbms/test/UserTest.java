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
			//��ȡ���������ļ�
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
			//�ر�session
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
			//�ر�session
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
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//ģ����ѯ
	public void TestList2() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			//list = session.selectList("cn.tree.smbms.dao.user.UserMapper.getUserListByName","��");
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
			list = session.getMapper(UserMapper.class).getUserListByName("��");
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
	//��ѯuserRole=1��ֵ
	public void TestList3() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserRole",1);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//��������ѯ
	public void TestList4() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Map<String,String> map = new HashMap<String,String>();
			map.put("name","��");
			map.put("role","3");
			//
			list = session.selectList("cn.tree.smbms.dao.user.UserMapper.getUserListByMap",map);
			list=session.getMapper(UserMapper.class).getUserListByMap(map);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//ʵ�����ѯ
	public void TestList5() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setUserName("��");
			user.setUserRole(3);
			//list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserListByMap2",user);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//�������ѯ
	public void TestList6() {
		List<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setUserName("��");
			user.setUserRole(3);
			//list = session.selectList("cn.three.smbms.dao.user.UserMapper.getUserList2",user);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//�������ݲ���
	public void TestList7() {
		int count=0;  //��Ӱ�������
		ArrayList<User> list = new ArrayList<User>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setUserName("·��");
			user.setUserCode("lufei");
			user.setUserPassword("456798");
			user.setGender(1);
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-10");
			user.setBirthday(birthday);
			user.setPhone("1200012");
			user.setAddress("����");
			user.setUserRole(2);
			user.setCreatedBy(1);
			user.setCreationDate(new Date());
			user.setModifyBy(1);
			user.setModifyDate(new Date());
			//count = session.insert("cn.three.smbms.dao.user.UserMapper.add",user);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//�������ݲ���
	public void TestList8() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User user = new User();
			user.setId(22);
			user.setUserName("ɽ��");
			user.setUserCode("sanzhi");
			user.setUserPassword("445566");
			//count = session.update("cn.three.smbms.dao.user.UserMapper.modify",user);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//ʹ��ע�⴫��
	public void TestList9() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			String pwd = "55555";
			Integer id =18;
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
	//ɾ�����ݲ���
	public void TestList10() {
		int count=0;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer id =26;
			//count = session.delete("cn.three.smbms.dao.user.UserMapper.deleteUserById",id);
			//ʹ�ýӿڷ�ʽʵ�ֲ�ѯ
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
}
