package com.dzj.house.util;

public class PathUtil {

	private static String seperator = System.getProperty("file.separator");

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "C:/house/image";
		} else {
			basePath = "/usr/local/house/work/image";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getHouseImagePath(long houseId) {
		String imagePath = "/upload/item/house/" + houseId + "/";
		return imagePath.replace("/", seperator);
	}
}
