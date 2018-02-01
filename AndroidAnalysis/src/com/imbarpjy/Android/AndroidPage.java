package com.imbarpjy.Android;

import java.util.Map;

public class AndroidPage {
	AndroidControl headControlForPage = null;
	int moduleNumber = 0;
	int pageWidth = 0, pageHeight = 0;
	
	public AndroidPage(int width, int height) {
		this.pageWidth = width;
		this.pageHeight = height;
	}

	public int getPageWidth() {
		return pageWidth;
	}
	public void setPageWidth(int pageWidth) {
		this.pageWidth = pageWidth;
	}
	public int getPageHeight() {
		return pageHeight;
	}
	public void setPageHeight(int pageHeight) {
		this.pageHeight = pageHeight;
	}
	public AndroidControl getHeadControlForPage() {
		return headControlForPage;
	}
	public void setHeadControlForPage(AndroidControl headControlForPage) {
		this.headControlForPage = headControlForPage;
	}
	public int getModuleNumber() {
		return moduleNumber;
	}
	public void setModuleNumber(int moduleNumber) {
		this.moduleNumber = moduleNumber;
	}
	public AndroidControl getParentControl(int android) {
		if(headControlForPage.getId() == android) return null;
		for(int i = 0; i < headControlForPage.getSubControl().size(); i++)
			if(headControlForPage.getSubControl().get(i).getId() == android)
				return headControlForPage;
		for(int i = 0; i < headControlForPage.getSubControl().size(); i++)
			if(getParentControl(headControlForPage.getSubControl().get(i), android) != null)
				return getParentControl(headControlForPage.getSubControl().get(i), android);
		return null;
	}
	public AndroidControl getParentControl(AndroidControl androidList, int android) {
		for(int i = 0; i < androidList.getSubControl().size(); i++)
			if(androidList.getSubControl().get(i).getId() == android)
				return androidList;
		for(int i = 0; i < androidList.getSubControl().size(); i++)
			if(getParentControl(androidList.getSubControl().get(i), android) != null)
				return getParentControl(androidList.getSubControl().get(i), android);
		return null;
	}
	public AndroidControl getAndroidControl(int android) {
		if(headControlForPage.getId() == android) return headControlForPage;
		for(int i = 0; i < headControlForPage.getSubControl().size(); i++)
			if(getAndroidControl(headControlForPage.getSubControl().get(i), android) != null)
				return getAndroidControl(headControlForPage.getSubControl().get(i), android);
		return null;
	}
	public AndroidControl getAndroidControl(AndroidControl androidList, int android) {
		if(androidList.getId() == android) return androidList;
		for(int i = 0; i < androidList.getSubControl().size(); i++)
			if(getParentControl(androidList.getSubControl().get(i), android) != null)
				return getParentControl(androidList.getSubControl().get(i), android);
		return null;
	}
	
	public void print() {
		headControlForPage.print(0);
	}
}
