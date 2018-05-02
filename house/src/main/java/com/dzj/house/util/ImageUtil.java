package com.dzj.house.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dzj.house.ExceptionHandle.GlobalExceptionHandle;

public class ImageUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static Random random = new Random();
	
	private static final Logger log= LoggerFactory.getLogger(GlobalExceptionHandle.class);
	
	private static String getRandomName() {
		return dateFormat.format(new Date())+""+random.nextInt(8999)+10000;
	}

	public static String uploadImage(InputStream inputStream, String imageName,Long houseId)  {
		String location=null;
		String suffixName = imageName.substring(imageName.lastIndexOf(".")+1, imageName.length());
		if (suffixName.toLowerCase().equals("bmp") || suffixName.toLowerCase().equals("png")
				|| suffixName.toLowerCase().equals("jpg") || suffixName.toLowerCase().equals("jpeg")) {

			String newName = getRandomName()+"."+suffixName;
			String pathUrl=PathUtil.getHouseImagePath(houseId);
			location= pathUrl+newName;
			String path = PathUtil.getImgBasePath()+pathUrl;
			try {
				UpLoadFile.upload(inputStream, newName, path);
			} catch (IOException e) {
				log.error("上传图片失败！");
			}
			
		}
		return location;

	}
}
