package cn.three.smbms.pojo;

import java.math.BigInteger;
import java.util.Date;
/**
 * �û���
 * @author bin
 *
 */
public class User {
	private BigInteger id;//����ID
	private String userCode;//�û�����
	private String userName;//�û�����
	private String userPassword;//�û�����
	private Integer gender;//�Ա�1:Ů�� 2:�У�
	private Date birthday;//��������
	private String phone;//�ֻ�
	private String address;//��ַ
	private Integer userRole;//�û���ɫ��ȡ�Խ�ɫ��-��ɫid��
	private BigInteger createdBy;//������
	private Date creationDate;//����ʱ��
	private BigInteger modifyBy;//������
	private Date modifyDate;//����ʱ��
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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
