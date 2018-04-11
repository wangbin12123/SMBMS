package cn.tree.smbms.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.three.smbms.dao.bill.BillMapper;
import cn.three.smbms.pojo.Bill;
import cn.three.smbms.utils.MyBatisUtil;

public class BillTest {
	private Logger logger = Logger.getLogger(BillTest.class);
	@Test
	public void TestBillList() {
		List<Bill> list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Bill bill = new Bill();
			bill.setProductName("油");
			bill.setIsPayment(2);
			bill.setProviderId(6);
			//list = session.selectList("cn.three.smbms.dao.bill.BillMapper.getBillList",bill);
			list = session.getMapper(BillMapper.class).getBillList(bill);
			for (Bill b : list) {
				logger.debug("billCode\t"+b.getBillCode()+"\n"+"ProductName\t"+b.getProductName()+"\n"+"proName\t"+b.getProviderName()+"\n"+"productCount\t"+b.getProductCount()+"\n"+"isPayment\t"+b.getIsPayment()+"\n"+"creationDate\t"+b.getCreationDate());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
	@Test
	public void TestBillProviderList() {
		List<Bill> list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			Bill bill = new Bill();
			bill.setProductName("米");
			bill.setIsPayment(2);
			bill.setProviderId(3);
			//list = session.selectList("cn.three.smbms.dao.bill.BillMapper.getBillProviderList",bill);
			list = session.getMapper(BillMapper.class).getBillProviderList(bill);
			for (Bill b : list) {
				logger.debug(
				"\n"+b.getId()+"\t"+"\n订单编码\t"+b.getBillCode()+"\n"
				+"商品名称\t"+b.getProductName()+"\n"
				+"供应商名称\t"+b.getProvider().getProName()+"\n"
				+"订单金额\t"+b.getProductCount()+"\n"
				+"是否支付\t"+b.getIsPayment()+"\n"
				+"创建时间\t"+b.getCreationDate()+"\n"
				+"供应商联系人\t"+b.getProvider().getProContact()+"\n"
				+"供应商联系电话\t"+b.getProvider().getProPhone()+"\n"
				+"供应商编码\t"+b.getProvider().getProCode()+"\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession(session);
		}
	}
}
