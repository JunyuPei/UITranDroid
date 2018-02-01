package com.imbarpjy.Android;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.imbarpjy.iOS.iOSControl;
import com.imbarpjy.iOS.iOSPage;

public class AndroidPageRead {
	AndroidPage page = null;
	int currentControlID = 1;
	
	public AndroidPageRead(String fileName) throws Exception {
		InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		BufferedReader br = new BufferedReader(is); 
		String line = br.readLine();line = br.readLine();line = br.readLine();
		String oneSubControl = "";
		int left = 0, right = 0;
		while (line != null) {
			if(line.contains("=") && line.contains("/>"));
			if(line.contains("=") && !line.contains("/>")) left++;
			if(!line.contains("=")) right++;
			
			if(left == right) {
				if(oneSubControl.equals("")) continue;
				AndroidControl head = getHeadControlOfFragment(oneSubControl);	
//				System.out.println(oneSubControl);
				page = new AndroidPage(head.getWidth(), head.getHeight());
				page.setHeadControlForPage(head);
				break;
			}

			if(left != right) oneSubControl = oneSubControl + line + "\n";
			line = br.readLine();
		}
	}
	
	public AndroidControl getHeadControlOfFragment(String fragment) {
		AndroidControl head = new AndroidControl(currentControlID); currentControlID++;
		String[] controlList = fragment.split("\n");		
		addAttributes(controlList[0], head);
		String oneSubControl = ""; int left = 0, right = 0;
		for(int i = 1; i < controlList.length; i++) {
			if(left == 0 && right == 0 && controlList[i].contains("=") && controlList[i].contains("/>")) {
				head.addSubControl(getHeadControlOfFragment(controlList[i]));
				continue;
			}
			if(controlList[i].contains("=") && !controlList[i].contains("/>")) left++;
			if(!controlList[i].contains("=")) right++;

			if(left == right) {
				if(oneSubControl.equals("")) continue;
				head.addSubControl(getHeadControlOfFragment(oneSubControl));
				left = 0; right = 0; oneSubControl = "";
			}
			if(left != right) oneSubControl = oneSubControl + controlList[i] + "\n";
		}

		return head;
	}
	
	public void addAttributes(String controlDescribe, AndroidControl androidControl) {
		String[] attributeList = controlDescribe.trim().split(" ");
		if(attributeList[0].equals("")) return;
		androidControl.setName(attributeList[0].split("\\.")[2]);
		for(int i = 1; i < attributeList.length; i++) {
			if(attributeList[i].split("=")[0].equals("content-Desc")) androidControl.setContentDesc(attributeList[i].split("=")[1]);
			if(attributeList[i].split("=")[0].equals("enabled") && attributeList[i].split("=")[1].equals("true")) androidControl.setEnabled(true); else androidControl.setEnabled(false);
			if(attributeList[i].split("=")[0].equals("clickable") && attributeList[i].split("=")[1].equals("true")) androidControl.setClickable(true); else androidControl.setClickable(false);
			if(attributeList[i].split("=")[0].equals("text")) androidControl.setText(attributeList[i].split("=")[1]);
			if(attributeList[i].split("=")[0].equals("bounds")) {
				int x = Integer.parseInt(attributeList[i].split("=")[1].split(",")[0].split("\\[")[1]);
				int y = Integer.parseInt(attributeList[i].split("=")[1].split(",")[1].split("]")[0]);
				androidControl.setX(x);
				androidControl.setY(y);
				androidControl.setWidth(Integer.parseInt(attributeList[i].split("=")[1].split(",")[1].split("\\[")[1]) - x);
				androidControl.setHeight(Integer.parseInt(attributeList[i].split("=")[1].split(",")[2].split("]")[0]) - y);
			}
		}
	}
	
	public AndroidPage getPage() {
		return page;
	}
}
