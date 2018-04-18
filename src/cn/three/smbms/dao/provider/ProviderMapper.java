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
	//ʹ��ע�⴫��
	public int insert2(@Param("proCode")String proCode,
					   @Param("proName")String proName,
					   @Param("proDesc")String proDesc,
					   @Param("createdBy")Integer createdBy,
					   @Param("creationDate")Date creationDate);
	//һ�Զ�ӳ��
	public List<Provider> getBillListByProvider(Integer providerid);
	//ʹ��foreach array���鹩Ӧ���µĶ����б���Ϣ
	public List<Provider> getBillList_array(Integer[] providerIds);
	//ʹ��foreach list���Ϲ�Ӧ���µĶ����б���Ϣ
	public List<Provider> getBillList_List(List<Integer> billList);
	//ʹ��foreach map���Ϲ�Ӧ���µĶ����б���Ϣ
	public List<Provider> getBillList_Map(Map<String,Object> map);
	//ʹ��choose��ѯprovider�б���Ϣ
	public List<Provider> getProviderList_choose(@Param("proCode")String proCode,
												 @Param("proName")String proName,
												 @Param("proContact")String proContact,
												 @Param("creationDate")Date creationDate);
}
