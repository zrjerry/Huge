package com.huge.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huge.web.mapper.SearchMapper;
import com.huge.web.pojo.BusInfo;
import com.huge.web.pojo.Item;

@Service
public class SearchService {
	@Autowired
	private SearchMapper searchMapper;
	public List<BusInfo> searchBusInfo(BusInfo busInfo) {
		
		String date = busInfo.getStartDate();
		date = date.replaceAll("/","-");
		System.out.println(busInfo);
		// 将日期字符串转化为日期
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date day = new Date();
		try {
			Date rideDate = sf.parse(date);
			System.out.println(date);
			// 判断日期是否正确
			if(day.getTime() <= rideDate.getTime()){
				System.out.println(date);
				busInfo.setStartDate(date);
				List<BusInfo> list = searchMapper.searchBusInfo(busInfo);
//				for(BusInfo b:list) {
//					System.out.println(b);
//				}
				return list;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
