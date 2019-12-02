package cn.tblack.bookstack.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookAdmin implements Serializable {
    private Integer id;

    private String adminName;

    private String authorizer;

    private Date authorizerTime;

    private static final long serialVersionUID = 1L;

    public Integer getAdminId() {
        return id;
    }

    public void setAdminId(Integer adminId) {
        this.id = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer == null ? null : authorizer.trim();
    }

    public Date getAuthorizerTime() {
        return authorizerTime;
    }

    public void setAuthorizerTime(Date authorizerTime) {
        this.authorizerTime = authorizerTime;
    }

	@Override
	public String toString() {
		return "BookAdmin [adminId=" + id + ", adminName=" + adminName + ", authorizer=" + authorizer
				+ ", authorizerTime=" + authorizerTime + "]";
	}
    
}