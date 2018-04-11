package cn.three.smbms.dao.bill;

import java.util.List;

import cn.three.smbms.pojo.Bill;

public interface BillMapper {
	public List<Bill> getBillList(Bill bill);
	public List<Bill> getBillProviderList(Bill bill);
}
