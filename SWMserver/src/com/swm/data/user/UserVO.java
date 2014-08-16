package com.swm.data.user;

public class UserVO {
	
	int uid;
	String password = null;
	String uname = null;
	int age;
	int sex;
	int job;
	String email = null;
	String phone = null;
	String nick = null;
	int opt;
	String styles = null;
	int role;
	String fbid = null;
	String rules = null;
	int allowsex;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getOpt() {
		return opt;
	}
	public void setOpt(int opt) {
		this.opt = opt;
	}
	public String getStyles() {
		return styles;
	}
	public void setStyles(String styles) {
		this.styles = styles;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getFbid() {
		return fbid;
	}
	public void setFbid(String userid) {
		this.fbid = userid;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public int getAllowsex() {
		return allowsex;
	}
	public void setAllowsex(int allowsex) {
		this.allowsex = allowsex;
	}
	
	@Override
	public String toString() {
		return "{\"uid\":\"" + uid + "\", \"password\":\"" + password + "\", \"uname\":\""
				+ uname + "\", \"age\":\"" + age + "\", \"sex\":\"" + sex + "\", \"job\":\"" + job
				+ "\", \"email\":\"" + email + "\", \"phone\":\"" + phone + "\", \"nick\":\"" + nick
				+ "\", \"opt\":\"" + opt + "\", \"styles\":\"" + styles + "\", \"role\":\"" + role
				+ "\", \"fbid\":\"" + fbid + "\", \"rules\":\"" + rules + "\", \"allowsex\":\""
				+ allowsex + "\"}";
	}

}
