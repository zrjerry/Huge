package com.huge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.web.pojo.BusInfo;
import com.huge.web.service.BusService;
import com.jt.common.vo.SysResult;

@Controller
public class BusController {
	
	@Autowired
	private BusService busService;
	/*
	 * 按城市查询余票
	 */
	@RequestMapping("/bus")
	@ResponseBody
	public List<BusInfo> getLeft(String city, Model model){
		System.out.print("进入controller");
		List<BusInfo> busList = busService.getLeft(city);
		return busList;
	}
	/*
	 * 修改余票信息
	 */
	@RequestMapping("/updateTicket")
	@ResponseBody
//	Integer id,String startStation,
//	String endStation,Integer leftTicket,Integer price
	public SysResult updateTicket(BusInfo busInfo) {
		try{
			busService.updateTicket(busInfo);
			return SysResult.build(200,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, "失败了");
		}
	}
	
	/*
	 * 删除票-
	 */
	@RequestMapping("/deleteTicket")
	@ResponseBody
	public SysResult deleteTicket(BusInfo busInfo) {
		try{
			busService.deleteTicket(busInfo);
			return SysResult.oK();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, "失败了");
		}
	}
}
