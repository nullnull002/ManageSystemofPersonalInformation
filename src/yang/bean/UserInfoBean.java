package yang.bean;

import java.io.Serializable;

public class UserInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userSex;
	private String userBirthday;
	private String userNation;
	private String loginName;
	private String password;
	private String userTelephone;
	private String userEmail;
	private String userAddress;
	public UserInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfoBean(String username, String usersex, String userBirthday, String userNation, String loginName,
			String password, String userTelephone, String userEmail, String userAddress) {
		super();
		this.userName = username;
		this.userSex = usersex;
		this.userBirthday = userBirthday;
		this.userNation = userNation;
		this.loginName = loginName;
		this.password = password;
		this.userTelephone = userTelephone;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String usersex) {
		this.userSex = usersex;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserNation() {
		return userNation;
	}
	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	
}
