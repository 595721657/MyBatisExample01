package entity;
/**
 * ��ɫ��
 * @author ����
 *
 */

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = -3282844585517456123L;
	private int id;//����id
     private String roleCode;//��ɫ����
     private String userRoleName;//��ɫ����
     private int createdBy;//������
     private Date creationDate;//����ʱ��
     private int modifyBy;//�޸���
     private Date modifyDate;//�޸�ʱ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
     
}
