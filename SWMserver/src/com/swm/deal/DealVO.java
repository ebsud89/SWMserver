//예약에 필요햔 데이터

package com.swm.deal;

public class DealVO {
	private String stationName;
	private int minRent;
	private int maxRent;
	private int minGuaranty;
	private int maxGuaranty;
	private int minManage;
	private int maxManage;
	private String options;
	private String infos;
	private String rules;
	/*/
	public DealVO(String stationName, int minRent, int maxRent, int minGuaranty, int maxGuaranty, int minManage, int maxManage, String options, String infos, String rules){
		this.stationName = stationName;
		this.minRent = minRent;
		this.maxRent = maxRent;
		this.minGuaranty = minGuaranty;
		this.maxGuaranty = maxGuaranty;
		this.minManage = minManage;
		this.maxManage = maxManage;
		this.options = options;
		this.infos = infos;
		this.rules = rules;
	}
	/*/

	public int getMinRent() {
		return minRent;
	}
	public void setMinRent(int minRent) {
		this.minRent = minRent;
	}
	public int getMaxRent() {
		return maxRent;
	}
	public void setMaxRent(int maxRent) {
		this.maxRent = maxRent;
	}
	public int getMinGuaranty() {
		return minGuaranty;
	}
	public void setMinGuaranty(int minGuaranty) {
		this.minGuaranty = minGuaranty;
	}
	public int getMaxGuaranty() {
		return maxGuaranty;
	}
	public void setMaxGuaranty(int maxGuaranty) {
		this.maxGuaranty = maxGuaranty;
	}
	public int getMinManage() {
		return minManage;
	}
	public void setMinManage(int minManage) {
		this.minManage = minManage;
	}
	public int getMaxManage() {
		return maxManage;
	}
	public void setMaxManage(int maxManage) {
		this.maxManage = maxManage;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
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
}
