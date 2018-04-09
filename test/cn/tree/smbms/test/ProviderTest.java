package cn.tree.smbms.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import cn.three.smbms.dao.provider.ProviderMapper;
import cn.three.smbms.pojo.Provider;
import cn.three.smbms.utils.MyBatisUtil;



public class ProviderTest {
	private Logger logger = Logger.getLogger(ProviderTest.class);
	@Ignore
	@Test
	public void TestCount() {
		String resource = "mybatis-config.xml";
		int count = 0;
		SqlSession session = null;
		try {
			//��ȡ���������ļ�
			InputStream is = Resources.getResourceAsStream(resource);
			//����SqlSessionFactory����
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//����SqlSession����
			session = factory.openSession();
			count = session.selectOne("cn.tree.smbms.dao.provider.ProviderMapper.count");
			logger.debug("ProviderMapper count--->"+count);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//�ر�session
			session.close();
		}
	}
	@Test
	public void TestProName() {
		List<Provider> list = new ArrayList<Provider>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			//list = session.selectList("cn.tree.smbms.dao.provider.ProviderMapper.getProviderList");
			list = session.getMapper(ProviderMapper.class).getProviderList();
			for (Provider provider : list) {
				logger.debug("proName\t"+provider.getProName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
}
