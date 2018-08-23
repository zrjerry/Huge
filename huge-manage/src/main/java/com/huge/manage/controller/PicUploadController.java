package com.huge.manage.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;

@RestController
public class PicUploadController {
	/*
	 * 图片上传逻辑:
	 * 1 判断扩展名jpg,png,gif
	 * 2 判断是否木马(正确思路应该是引入第三方jar包的api判断)
	 * 3 生成两个路径:磁盘路径,url相对路径访问地址
	 * C:\apache-tomcat-9.0.6\webapps\ROOT/images\2018\07\26\153536215324.jpg
	 * 	yyyy/mm/dd;
	 * url:http://localhost:8080/images\2018\07\26\153536215324.jpg
	 * 4 图片文件重命名,currentTime+3位随机数
	 * 5 保存
	 * 6 封装picUploadResult返回
	 * 	中途任何问题都导致返回对象的error=1
	 */
	@RequestMapping("pic/upload")
	public PicUploadResult uploadPics(MultipartFile uploadFile){
		//构造一个返回的空对象
		PicUploadResult result= new PicUploadResult();
		//判断后缀,获取原名称,1.JPG
		String oldFileName=uploadFile.getOriginalFilename();
		//截取后缀
		String extFileName=oldFileName.
				substring(oldFileName.lastIndexOf("."));
		//正则判断合法性
		if(!extFileName.matches("^.(jpg|png|gif)$")){
			result.setError(1);
			return result;
		}
		try{
		//判断木马,BufferedImage判断是否有宽高
		BufferedImage bufImage=ImageIO.read
				(uploadFile.getInputStream());
		//getHeight没有抛异常说明数据流中有宽高的属性,不是木马
		result.setHeight(bufImage.getHeight()+"");
		result.setWidth(bufImage.getWidth()+"");
		//以上内容为判断木马过程;
		//生成路径 images\2018\07\26
		String dir="/images/"+new SimpleDateFormat("yyyy/MM/dd").
				format(new Date())+"/";
		//拼接磁盘路径,拼接url路径
		String path="c:/jt-upload"+dir;
		String urlPath="http://image.jt.com"+dir;
		//创建磁盘目录,等待输出文件
		File _dir=new File(path);
		if(!_dir.exists()){
			_dir.mkdirs();//tomcat下的webapp/ROOT/images/***/
		}
		//计算文件重命名
		String fileName=System.currentTimeMillis()+""+
				RandomUtils.nextInt(100, 999)+extFileName;
		result.setUrl(urlPath+fileName);
		//写出磁盘
		uploadFile.transferTo(new File(path+fileName));
		//error为0
		result.setError(0);
		return result;
		}catch(Exception e){
			e.printStackTrace();
			result.setError(1);
			return result;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
