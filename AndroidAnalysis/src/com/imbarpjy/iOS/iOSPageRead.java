package com.imbarpjy.iOS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class iOSPageRead {
	iOSPage page = null;
	int currentControlID = 1;
	
	public iOSPageRead(String fileName) throws Exception {
		InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		BufferedReader br = new BufferedReader(is); 
		String line = br.readLine();line = br.readLine();line = br.readLine();
		String oneSubControl = "";
		int left = 0, right = 0;
		while (line != null) {
//			System.out.println(line);
			if(line.contains("=") && line.contains("/"));
			if(line.contains("=") && !line.contains("/")) left++;
			if(!line.contains("=")) right++;
			
			if(left == right) {
//				System.out.println(oneSubControl);
				iOSControl head = getHeadControlOfFragment(oneSubControl);
				page = new iOSPage(head.getWidth(), head.getHeight());
				page.setHeadControlForPage(head);
				break;
			}
			if(!line.contains("x=\"inf\"") && left != right) oneSubControl = oneSubControl + line + "\n";
			line = br.readLine();
		}
	}
	
	public iOSControl getHeadControlOfFragment(String fragment) {
		iOSControl head = new iOSControl(currentControlID); currentControlID++;
		String[] controlList = fragment.split("\n");
		addAttributes(controlList[0], head);
		String oneSubControl = ""; int left = 0, right = 0;
		for(int i = 1; i < controlList.length; i++) {
			if(left == 0 && right == 0 && controlList[i].contains("=") && controlList[i].contains("/")) {
				head.addSubControl(getHeadControlOfFragment(controlList[i]));
				continue;
			}
			if(controlList[i].contains("=") && !controlList[i].contains("/")) left++;
			if(!controlList[i].contains("=")) right++;
			
			if(left == right) {
				head.addSubControl(getHeadControlOfFragment(oneSubControl));
				left = 0; right = 0; oneSubControl = "";
			}
			if(left != right) oneSubControl = oneSubControl + controlList[i] + "\n";
		}
		return head;
	}
	
	public void addAttributes(String controlDescribe, iOSControl iosControl) {
		String[] attributeList = controlDescribe.trim().split(" ");
		for(int i = 1; i < attributeList.length; i++) {
			if(attributeList[i].split("=").length == 0) continue;
			if(attributeList[i].split("=")[0].equals("type")) {
				if((attributeList[i].split("=")[1]).contains("Button")) iosControl.setType("Button");
				else if((attributeList[i].split("=")[1]).contains("Text")) iosControl.setType("Label");
				else if((attributeList[i].split("=")[1]).contains("Image")) iosControl.setType("ImageView");
				else if(attributeList[i].contains("/")) iosControl.setType("ImageView");
				else if((attributeList[i].split("=")[1]).contains("ScrollView")) iosControl.setType("ScrollView");
				else if((attributeList[i].split("=")[1]).contains("TabBar")) iosControl.setType("TabBar");
				else if((attributeList[i].split("=")[1]).contains("NavigationBar")) iosControl.setType("NavigationBar");
				else if((attributeList[i].split("=")[1]).contains("WebView")) iosControl.setType("WebView");
				else iosControl.setType("View");
			}
			if(attributeList[i].split("=")[0].equals("enabled") && attributeList[i].split("=")[1].equals("true")) iosControl.setEnabled(true); else iosControl.setEnabled(false);
			if(attributeList[i].split("=")[0].equals("visible") && attributeList[i].split("=")[1].equals("true")) iosControl.setVisible(true); else iosControl.setVisible(false);
			if(attributeList[i].split("=")[0].equals("label")) iosControl.setLabel(attributeList[i].split("=")[1]);
			if(attributeList[i].split("=")[0].equals("name")) iosControl.setName(attributeList[i].split("=")[1]);
			if(attributeList[i].split("=")[0].equals("x")) iosControl.setX(Integer.parseInt(attributeList[i].split("=")[1].split("\"")[1]));
			if(attributeList[i].split("=")[0].equals("y")) iosControl.setY(Integer.parseInt(attributeList[i].split("=")[1].split("\"")[1]));
			if(attributeList[i].split("=")[0].equals("width")) iosControl.setWidth(Integer.parseInt(attributeList[i].split("=")[1].split("\"")[1]));
			if(attributeList[i].split("=")[0].equals("height")) iosControl.setHeight(Integer.parseInt(attributeList[i].split("=")[1].split("\"")[1]));

		}
	}
	
	public iOSPage getPage() {
		return page;
	}
}
