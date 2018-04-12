package cn.three.smbms.dao.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.three.smbms.pojo.Bill;

public interface BillMapper {
	public List<Bill> getBillList(Bill bill);
	public List<Bill> getBillProviderList(Bill bill);
	//ʹ��if+where ʵ�ֲ�ѯ����
	public List<Bill> getBillList2(@Param("productName")String productName,@Param("providerId")Integer providerId,@Param("isPayment")Integer isPayment);
}
