package com.imbarpjy.iOS;

import java.util.ArrayList;

public class iOSPagesForApp {
	
	ArrayList<iOSPage> iOSPagesList = new ArrayList<iOSPage>();
	
	public iOSPagesForApp(String fileName, int fileNumber, String appName) throws Exception {
		for(int i = 1; i < fileNumber + 1; i++)
			iOSPagesList.add(new iOSPageRead(fileName + "/" + appName + i + ".txt").getPage());

	}
	
	public iOSPage getiOSPage(int num) {
		return iOSPagesList.get(num);
	}
}
