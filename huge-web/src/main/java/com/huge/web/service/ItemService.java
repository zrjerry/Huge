package com.huge.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.web.pojo.Item;
import com.jt.common.service.HttpClientService;

@Service
public class ItemService {
	@Autowired
	private HttpClientService client;
	/*
	 * 需要调用后台的方法,获取某个id对应的
	 * 商品信息(商品详情=作业)
	 */
	public static final ObjectMapper mapper=new ObjectMapper();
	public Item getItem(Long itemId) {
		//调用httpClient对象完成数据的获取和传递
		//创建一个访问对象
		/*try{
		CloseableHttpClient client=HttpClients.createDefault();
		String url="http://manage.jt.com/items/"+itemId;
		HttpGet get=new HttpGet(url);
		//HttpPost post=new HttpPost(url);
		CloseableHttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		String jsonItem=EntityUtils.toString(entity);//{}
		//页面需要对象数据,ObjectMapper转化,单个对象转化
		Item item = mapper.readValue(jsonItem, Item.class);
		return item;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}*/
		try{
		String url="http://manage.jt.com/items/"+itemId;
		String itemJson = client.doGet(url);
		Item item = mapper.readValue(itemJson, Item.class);
		return item;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
