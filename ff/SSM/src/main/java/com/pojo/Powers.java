package com.pojo;

public class Powers {
	
	
	private AdminInfo adminInfo;
	private Functions f;
	
	
	public AdminInfo getAdminInfo() {
		return adminInfo;
	}
	public void setAdminInfo(AdminInfo adminInfo) {
		this.adminInfo = adminInfo;
	}
	public Functions getF() {
		return f;
	}
	public void setF(Functions f) {
		this.f = f;
	}
	@Override
	public String toString() {
		return "Powers [adminInfo=" + adminInfo + ", f=" + f + "]";
	}
	

}
