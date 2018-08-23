package com.huge.web.mapper;

import java.util.List;

import com.huge.web.pojo.BusInfo;

public interface BusMapper {

	List<BusInfo> getLeft(String city);

	void updateTicket(BusInfo businfo);

	void deleteTicket(BusInfo busInfo);

}
