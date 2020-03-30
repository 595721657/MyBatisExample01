package entity;
/**
 * 角色表
 * @author 黄龙
 *
 */

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = -3282844585517456123L;
	private int id;//主键id
     private String roleCode;//角色编码
     private String userRoleName;//角色名称
     private int createdBy;//创建者
     private Date creationDate;//创建时间
     private int modifyBy;//修改者
     private Date modifyDate;//修改时间
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
