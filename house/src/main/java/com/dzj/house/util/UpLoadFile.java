package com.dzj.house.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



public class UpLoadFile {

	private static void makedirPath(String path) {
		File file =new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
	public static void upload(InputStream inputStream ,String imageName,String path) throws IOException {
		FileOutputStream fos =null;
		makedirPath(path);
		File file =new File(path+imageName);
		
		
		try {
			fos=new FileOutputStream(file);
			byte[] buffer =new byte[1024];
			int i=0;
			while((i= inputStream.read(buffer, 0, buffer.length)) !=-1) {
				fos.write(buffer, 0, buffer.length);
				fos.flush();
			}
		}
		finally {
			if(inputStream !=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fos !=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
