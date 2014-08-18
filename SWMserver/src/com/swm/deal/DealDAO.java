package com.swm.deal;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.swm.data.room.RoomVO;

public class DealDAO {
	public DealVO JSONParsing(JSONObject finder, DealVO Dvo){
		ArrayList<DealVO> member = new ArrayList<DealVO>();
		try{
			JSONArray jarray = new JSONArray();
			
			Dvo.setStationName(finder.get("name").toString());
			Dvo.setMinRent((Integer)finder.get("minRent"));
			Dvo.setMaxRent((Integer)finder.get("maxRent"));
			Dvo.setMinGuaranty((Integer)finder.get("minGuaranty"));
			Dvo.setMaxGuaranty((Integer)finder.get("maxGuaranty"));
			Dvo.setMinManage((Integer)finder.get("minManage"));
			Dvo.setMaxManage((Integer)finder.get("maxManage"));
			Dvo.setOptions(finder.get("options").toString());
			Dvo.setInfos(finder.get("infos").toString());
			Dvo.setRules(finder.get("rules").toString());
			//member.add(0, Dvo);
			//System.out.println(member.get(0).getName()+member.get(0).getStation()+member.get(0).getOptions());
		}catch(Exception e){	
		}
		return Dvo;
	}
}
