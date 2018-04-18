package cn.three.smbms.dao.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.three.smbms.pojo.Provider;

public interface ProviderMapper {
	public int count();
	public List<Provider> getProviderList();
	public int insert1(Provider provider);
	public int update1(Provider provider);
	public int update2(Provider provider);
	public int delete1(Integer id);
	//使用注解传参
	public int insert2(@Param("proCode")String proCode,
					   @Param("proName")String proName,
					   @Param("proDesc")String proDesc,
					   @Param("createdBy")Integer createdBy,
					   @Param("creationDate")Date creationDate);
	//一对多映射
	public List<Provider> getBillListByProvider(Integer providerid);
	//使用foreach array数组供应商下的订单列表信息
	public List<Provider> getBillList_array(Integer[] providerIds);
	//使用foreach list集合供应商下的订单列表信息
	public List<Provider> getBillList_List(List<Integer> billList);
	//使用foreach map集合供应商下的订单列表信息
	public List<Provider> getBillList_Map(Map<String,Object> map);
	//使用choose查询provider列表信息
	public List<Provider> getProviderList_choose(@Param("proCode")String proCode,
												 @Param("proName")String proName,
												 @Param("proContact")String proContact,
												 @Param("creationDate")Date creationDate);
}
