package com.swm.data.room;

public class RoomVO {

	int id;
	String name;
	int hostid;
	String addr;
	String doname;
	String siname;
	String dongname;
	String stationName;
	int stationCode;
	int rent;
	int guaranty;
	int management;
	String options;
	String infos;
	String rules;
	int premiumCode;
	int total;
	int avaliable;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHostid() {
		return hostid;
	}
	public void setHostid(int hostid) {
		this.hostid = hostid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDoname() {
		return doname;
	}
	public void setDoname(String doname) {
		this.doname = doname;
	}
	public String getSiname() {
		return siname;
	}
	public void setSiname(String siname) {
		this.siname = siname;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongname(String dongname) {
		this.dongname = dongname;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getStationCode() {
		return stationCode;
	}
	public void setStationCode(int stationCode) {
		this.stationCode = stationCode;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getGuaranty() {
		return guaranty;
	}
	public void setGuaranty(int guaranty) {
		this.guaranty = guaranty;
	}
	public int getManagement() {
		return management;
	}
	public void setManagement(int management) {
		this.management = management;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public int getPremiumCode() {
		return premiumCode;
	}
	public void setPremiumCode(int premiumCode) {
		this.premiumCode = premiumCode;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(int avaliable) {
		this.avaliable = avaliable;
	}
	
	@Override
	// need to convert JSON style
	public String toString() {
		return "RoomVO [id=" + id + ", name=" + name + ", hostid=" + hostid
				+ ", addr=" + addr + ", doname=" + doname + ", siname="
				+ siname + ", dongname=" + dongname + ", stationName="
				+ stationName + ", stationCode=" + stationCode + ", rent="
				+ rent + ", guaranty=" + guaranty + ", management="
				+ management + ", options=" + options + ", infos=" + infos
				+ ", rules=" + rules + ", premiumCode=" + premiumCode
				+ ", total=" + total + ", avaliable=" + avaliable + "]";
	}
	
}
