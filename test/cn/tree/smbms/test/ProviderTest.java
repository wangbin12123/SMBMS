package cn.tree.smbms.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	@Test
	//�������ݲ���
	public void TestInsert1() {
		int count = 0;
		SqlSession session = null;
		try {
			Provider provider = new Provider();
			provider.setProCode("Hf_df54555");
			provider.setProName("������");
			provider.setProDesc("��Ҫ�������ͻ�е���,�������");
			provider.setCreatedBy(2);
			Date creationDate =new SimpleDateFormat("yyyy-MM-dd").parse("1998-02-11 10:23:11");
			provider.setCreationDate(creationDate);
			session = MyBatisUtil.createSession();
			//count = session.insert("cn.three.smbms.dao.provider.ProviderMapper.insert1",provider);	
			count = session.getMapper(ProviderMapper.class).insert1(provider);
			session.commit();
			logger.debug("TestInsertCount\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//ע��������ݲ���
	public void TestInset2() {
		int count = 0;
		SqlSession session = null;
		try {
			String proCode="GG_df45564";
			String proName="����ħ���¿Ƽ����޹�˾";
			String proDese="��Ҫ��������";
			Integer createBy=1;
			Date creationDate =new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-12 12:30:30");
			session = MyBatisUtil.createSession();
			count = session.getMapper(ProviderMapper.class).insert2(proCode, proName, proDese, createBy, creationDate);
			logger.debug("TestInsert2Count\t"+count);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//�޸����ݲ���
	public void TestUpdate() {
		int count = 0;
		SqlSession session = null;
		try {
			Provider provider = new Provider();
			provider.setId(19);
			provider.setProCode("wb_jj66666");
			provider.setProName("���˰���");
			provider.setProDesc("��Ҫ������ľ");
			provider.setModifyBy(2);
			Date modifyDate =new SimpleDateFormat("yyyy-MM-dd").parse("1998-02-11 12:02:11");
			provider.setModifyDate(modifyDate);
			session = MyBatisUtil.createSession();
			//count = session.update("cn.three.smbms.dao.provider.ProviderMapper.update1",provider);	
			count = session.getMapper(ProviderMapper.class).update1(provider);
			session.commit();
			logger.debug("TestUpdateCount\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//ɾ�����ݲ���
	public void TestDelete() {
		int count = 0;
		SqlSession session = null;
		try {
			Integer id = 20;
			session = MyBatisUtil.createSession();
			//count = session.delete("cn.three.smbms.dao.provider.ProviderMapper.delete1",id);
			count = session.getMapper(ProviderMapper.class).delete1(id);
			session.commit();
			logger.debug("TestDeleteCount\t"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
}
