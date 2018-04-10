package cn.three.smbms.dao.provider;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.three.smbms.pojo.Provider;

public interface ProviderMapper {
	public int count();
	public List<Provider> getProviderList();
	public int insert1(Provider provider);
	public int update1(Provider provider);
	public int delete1(Integer id);
	//使用注解传参
	public int insert2(@Param("proCode")String proCode,@Param("proName")String proName,
			@Param("proDesc")String proDesc,@Param("createdBy")Integer createdBy,
			@Param("creationDate")Date creationDate);
}
