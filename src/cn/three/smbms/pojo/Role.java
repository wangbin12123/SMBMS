package cn.three.smbms.pojo;

import java.math.BigInteger;
import java.util.Date;
/**
 * 角色表
 * @author bin
 *
 */
public class Role {
	private BigInteger id;//主键ID
	private String roleCode;//角色编码
	private String roleName;//角色名称
	private BigInteger createdBy;//创建者
	private Date creationDate;//创建时间
	private BigInteger modifyBy;//修改者
	private Date modifyDate;//修改时间
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public BigInteger getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public BigInteger getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(BigInteger modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
