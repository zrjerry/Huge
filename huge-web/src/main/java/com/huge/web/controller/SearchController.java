package com.huge.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.web.pojo.BusInfo;
import com.huge.web.pojo.Item;
import com.huge.web.service.SearchService;
import com.jt.common.vo.SysResult;

@Controller
public class SearchController {
	/*
	 * 查询功能
	 */
	@Autowired
	private TransportClient client;
	@RequestMapping("search")
	public String searchItems(String q,Model model){
		//查询条件是q 构造查询条件的对象matchQuery
		QueryBuilder query=QueryBuilders.
				matchQuery("title", q).
				operator(Operator.AND);
		SearchResponse response = client.prepareSearch("jtdb_item").
		setQuery(query).setSize(10).get();
		//循环遍历,封装List<Item>
		List<Item> itemList=new ArrayList<Item>();
		SearchHits hits = response.getHits();
		Iterator<SearchHit> iterator = hits.iterator();
		while(iterator.hasNext()){
			SearchHit result = iterator.next();
		}
		for (SearchHit hit : hits) {
			//封装数据,新建对象item,
			Item item=new Item();
			item.setId(((int)hit.getSource().get("id")+0L));
			item.setImage((String)hit.getSource().get("image"));
			item.setTitle((String)hit.getSource().get("title"));
			item.setPrice(((int)hit.getSource().get("price")+0l));
			itemList.add(item);
		}
		model.addAttribute("itemList", itemList);
		return "search";
	}
	@RequestMapping("searchBus") 
	public String goIndex(){
		return "search";
	}
	/*
	 * 通过查询数据库查询功能
	 */
	@Autowired
	private SearchService searchService;
	@RequestMapping(value="user/searchBus")
//	@ResponseBody
	public String searchBusInfo(BusInfo busInfo,ModelMap model) {
		System.out.println(busInfo);
		List<BusInfo> busInfoList = searchService.searchBusInfo(busInfo);
		model.addAttribute("busInfoList", busInfoList);
		System.out.println(busInfoList);
//		for(BusInfo b: busInfoList) {
//			System.out.println(b.getEndCity());
//		}
		return "search";
	}
	
}
