package com.huge.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huge.web.mapper.BusMapper;
import com.huge.web.pojo.BusInfo;

@Service
public class BusService {

	@Autowired
	private BusMapper busMapper;
	public List<BusInfo> getLeft(String city) {
		List<BusInfo> busList=busMapper.getLeft(city);
		return busList;
	}
	public void updateTicket(BusInfo busInfo) {
		busMapper.updateTicket(busInfo);
	}
	public void deleteTicket(BusInfo busInfo) {
		busMapper.deleteTicket(busInfo);
	}

}
