package cn.tree.smbms.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import cn.three.smbms.dao.provider.ProviderMapper;
import cn.three.smbms.dao.user.UserMapper;
import cn.three.smbms.pojo.Address;
import cn.three.smbms.pojo.Bill;
import cn.three.smbms.pojo.Provider;
import cn.three.smbms.pojo.User;
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
			//读取核心配置文件
			InputStream is = Resources.getResourceAsStream(resource);
			//创建SqlSessionFactory对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//创建SqlSession对象
			session = factory.openSession();
			count = session.selectOne("cn.tree.smbms.dao.provider.ProviderMapper.count");
			logger.debug("ProviderMapper count--->"+count);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//关闭session
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
	//插入数据测试
	public void TestInsert1() {
		int count = 0;
		SqlSession session = null;
		try {
			Provider provider = new Provider();
			provider.setProCode("Hf_df54555");
			provider.setProName("军工厂");
			provider.setProDesc("主要生产大型机械零件,电脑配件");
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
	//注解插入数据测试
	public void TestInset2() {
		int count = 0;
		SqlSession session = null;
		try {
			String proCode="GG_df45564";
			String proName="深圳魔利奥科技有限公司";
			String proDese="主要生产耳机";
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
	//修改数据测试
	public void TestUpdate() {
		int count = 0;
		SqlSession session = null;
		try {
			Provider provider = new Provider();
			provider.setId(19);
			provider.setProCode("wb_jj66666");
			provider.setProName("大兴安岭");
			provider.setProDesc("主要生产树木");
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
	//删除数据测试
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
	@Test
	/**
	 * 一对多测试
	 */
	public void TestgetProviderBillList() {
		List<Provider> list = new ArrayList<Provider>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer providerid =1;
			//list = session.selectList("cn.three.smbms.dao.provider.ProviderMapper.getBillListByProvider",providerid);
			//使用接口方式实现查询
			list = session.getMapper(ProviderMapper.class).getBillListByProvider(providerid);
			for (Provider p : list) {
				logger.debug("供应商id\t"+p.getId()+"\n"+"供应商编码\t"+p.getProCode()+"\n"+"供应商名字\t"+p.getProName()+"\n"+"供应商联系人\t"+p.getProContact()+"\n"+"供应商联系电话\t"+p.getProPhone());
				for(Bill b : p.getBillList()) {
					logger.debug("biilCode\t"+b.getBillCode()+"\n"+"productName\t"+b.getProductName()+"\n"+"totalPrice\t"+b.getTotalPrice()+"\n"+"isPayment\t"+b.getIsPayment());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	//if-set修改数据测试
	public void TestUpdate2() {
		int count = 0;
		SqlSession session = null;
		try {
			Provider provider = new Provider();
			provider.setId(19);
			provider.setProCode("re_re12306");
			provider.setProName(null);
			provider.setProDesc("主要生产玩具");
			provider.setModifyBy(1);
			Date modifyDate =new Date();
			provider.setModifyDate(modifyDate);
			session = MyBatisUtil.createSession();
			//count = session.update("cn.three.smbms.dao.provider.ProviderMapper.update1",provider);	
			count = session.getMapper(ProviderMapper.class).update2(provider);
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
	/**
	 * 使用foreach array实现供应商下的订单列表信息
	 */
	public void Testarray1() {
		List<Provider> list = new ArrayList<Provider>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Integer[] providerIds = {1,3};
			list = session.getMapper(ProviderMapper.class).getBillList_array(providerIds);
			for (Provider provider : list) {
				logger.debug("proName\t"+provider.getProName()+"proCode\t"+provider.getProCode());
				for(Bill b : provider.getBillList()) {
					logger.debug("billCode\t"+b.getBillCode()+"productName\t"+b.getProductName()+"proDesc\t"+b.getProductDesc());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	/**
	 * 使用foreach list实现供应商下的订单列表信息
	 */
	public void TestList1() {
		List<Provider> list = new ArrayList<Provider>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			List<Integer> plist = new ArrayList<Integer>();
			plist.add(6);
			plist.add(7);
			list = session.getMapper(ProviderMapper.class).getBillList_List(plist);
			for (Provider provider : list) {
				logger.debug("proName\t"+provider.getProName()+"proCode\t"+provider.getProCode());
				for(Bill b : provider.getBillList()) {
					logger.debug("billCode\t"+b.getBillCode()+"productName\t"+b.getProductName()+"proDesc\t"+b.getProductDesc());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	/**
	 * 使用foreach map实现供应商下的订单列表信息
	 */
	public void Testmap1() {
		List<Provider> list = new ArrayList<Provider>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Map<String,Object> map = new HashMap<String,Object>();
			List<Integer> plist = new ArrayList<Integer>();
			plist.add(6);
			plist.add(7);
			map.put("proCode","BJ_GYS002");
			map.put("billList", plist);
			list = session.getMapper(ProviderMapper.class).getBillList_Map(map);
			for (Provider provider : list) {
				logger.debug("proName\t"+provider.getProName()+"proCode\t"+provider.getProCode());
				for(Bill b : provider.getBillList()) {
					logger.debug("billCode\t"+b.getBillCode()+"productName\t"+b.getProductName()+"proDesc\t"+b.getProductDesc());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
	@Test
	/**
	 * 使用foreach map实现供应商下的订单列表信息
	 */
	public void Testchoose() {
		List<Provider> list = new ArrayList<Provider>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			String proName = null;
			String proCode = "";
			String proContact = "王";
			Date creationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2013-03-22"); 
			list = session.getMapper(ProviderMapper.class).getProviderList_choose(proCode, proName, proContact, creationDate);
			for (Provider provider : list) {
				logger.debug("proName\t"+provider.getProName()+"\t"
							+"proCode\t"+provider.getProCode()+"\t"
							+"proContact\t"+provider.getProContact()+"\t"
							+"creationDate\t"+provider.getCreationDate()
							);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
			session.rollback();
		}
	}
}
