package com.huge.web.config;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig implements 
FactoryBean<TransportClient>,InitializingBean{
	@Value("${cluster-name}")
	private String name;
	@Value("${cluster-nodes}")
	private String node;
	private TransportClient client;
	@Override //初始化方法,在这个方法中将对象
	//各种参数进行赋值
	public void afterPropertiesSet() throws Exception {
		//准备一个setting,setting里的数据来自properties配置文件
		Settings setting=Settings.
		builder().put("cluster.name",name).build();
		//构建一个client对象,同过对node截取获取ip port,setting
		//进行创建
		TransportClient preClient=new PreBuiltTransportClient(
				setting);
		String[] hostAndPort = node.split(":");
		preClient.addTransportAddress(
						new InetSocketTransportAddress(
					InetAddress.getByName(hostAndPort[0]),
					Integer.parseInt(hostAndPort[1])));
		client=preClient;
	}

	@Override
	//获取由FactoryBean管理的对象,
	public TransportClient getObject() throws Exception {
		// TODO Auto-generated method stub
		return client;
	}

	@Override //与getObject的返回类型对应,返回的是反射对象
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return TransportClient.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
