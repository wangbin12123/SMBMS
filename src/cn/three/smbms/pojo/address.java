package cn.three.smbms.pojo;

import java.math.BigInteger;
import java.util.Date;
/**
 * 
 * @author bin
 *地址详细表
 */
public class address {
	private BigInteger id;//主键ID
	private String contact;//姓名
	private String addressDesc;//地址
	private String postCode;//邮编号
	private String tel;//手机号
	private BigInteger createdBy;//创建者
	private Date creationDate;//订单创建时间
	private BigInteger modifyBy;//修改者
	private Date modifyDate;//修改时间
	private BigInteger userId;//用户ID
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddressDesc() {
		return addressDesc;
	}
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	
}
