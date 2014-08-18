package com.swm.data.room;

public class RoomVO {

	int rid;
	String name;
	int hostid;
	String doname;
	String siname;
	String dongname;
	String stationName;
	String stationCode;
	int rent;
	int guaranty;
	int management;
	String options;
	String infos;
	String rules;
	String styles;
	int premiumCode;
	int total;
	int avaliable;
	int msex;
	int wsex;
	int wsexr;
	int msexr;
	float jaccard;
	/*/
	public RoomVO(String name, String doname, String siname, String dongname, String station, int rent, int guaranty, int management, String options, String infos, String rules, int premium, int total, int available, float jaccard){
		this.name = name;
		this.doname = doname;
		this.siname = siname;
		this.dongname = dongname;
		this.stationName = station;
		this.rent = rent;
		this.guaranty = guaranty;
		this.management = management;
		this.options = options;
		this.infos = infos;
		this.rules = rules;
		this.premiumCode = premium;
		this.total = total;
		this.avaliable = available;
		this.jaccard = jaccard;
	}
	/*/
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
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
	
	public int getMsex() {
		return msex;
	}
	public void setMsex(int msex) {
		this.msex = msex;
	}
	public int getWsex() {
		return wsex;
	}
	public void setWsex(int wsex) {
		this.wsex = wsex;
	}
	public String getStyles() {
		return styles;
	}
	public void setStyles(String styles) {
		this.styles = styles;
	}
	public float getJaccard() {
		return jaccard;
	}
	public void setJaccard(float jaccard) {
		this.jaccard = jaccard;
	}
	
	@Override
	public String toString() {
		return "{\"rid\":\"" + rid + "\", \"name\":\"" + name + "\", \"hostid\":\"" + hostid
				+ "\", \"stationName\":\"" + stationName + "\", \"stationCode\":\""
				+ stationCode + "\", \"rent\":\"" + rent + "\", \"guaranty\":\"" + guaranty
				+ "\", \"management\":\"" + management + "\", \"options\":\"" + options
				+ "\", \"infos\":\"" + infos + "\", \"rules\":\"" + rules + "\", \"styles\":\""
				+ styles + "\", \"premiumCode\":\"" + premiumCode + "\", \"total\":\"" + total
				+ "\", \"avaliable\":\"" + avaliable + "\", \"msex\":\"" + msex + "\", \"wsex\":\""
				+ wsex + "\", \"jaccard\":\"" + jaccard + "\", \"wsexr\":\"" +wsexr + "\", \"msexr\" :\"" + msexr + "\" }";
	}
	public int getWsexr() {
		return wsexr;
	}
	public void setWsexr(int wsexr) {
		this.wsexr = wsexr;
	}
	public int getMsexr() {
		return msexr;
	}
	public void setMsexr(int msexr) {
		this.msexr = msexr;
	}
	
}
