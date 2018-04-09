package cn.three.smbms.dao.provider;

import java.util.List;

import cn.three.smbms.pojo.Provider;

public interface ProviderMapper {
	public int count();
	public List<Provider> getProviderList();
}
