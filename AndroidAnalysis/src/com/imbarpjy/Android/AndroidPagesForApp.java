package com.imbarpjy.Android;

import java.util.ArrayList;

public class AndroidPagesForApp {
	
	ArrayList<AndroidPage> androidPagesList = new ArrayList<AndroidPage>();
	
	public AndroidPagesForApp(String fileName, int fileNumber, String appName) throws Exception {
		for(int i = 1; i < fileNumber + 1; i++)
			androidPagesList.add(new AndroidPageRead(fileName + "/" + appName + i + ".txt").getPage());
	}
	
	public AndroidPage getAndroidPage(int num) {
		return androidPagesList.get(num);
	}
}
