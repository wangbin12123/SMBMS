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
			bill.setProductName("см");
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
}
