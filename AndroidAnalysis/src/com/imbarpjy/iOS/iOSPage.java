package com.imbarpjy.iOS;

public class iOSPage {
	iOSControl headControlForPage = null;
	int moduleNumber = 0;
	int pageWidth = 0, pageHeight = 0;
	
	public iOSPage(int width, int height) {
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
	public iOSControl getHeadControlForPage() {
		return headControlForPage;
	}
	public void setHeadControlForPage(iOSControl headControlForPage) {
		this.headControlForPage = headControlForPage;
	}
	public int getModuleNumber() {
		return moduleNumber;
	}
	public void setModuleNumber(int moduleNumber) {
		this.moduleNumber = moduleNumber;
	}
	
	public void print() {
		headControlForPage.print(0);
	}
}
