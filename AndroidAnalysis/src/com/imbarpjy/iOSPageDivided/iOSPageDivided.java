package com.imbarpjy.iOSPageDivided;

import java.util.ArrayList;

import com.imbarpjy.iOS.iOSControl;
import com.imbarpjy.iOS.iOSPage;


public class iOSPageDivided {
	
	int distance;
	
	public iOSPageDivided(int distance) {
		this.distance = distance;
	}
	
	public void pageDivided(iOSPage page) throws Exception {
		boolean flag = true;
		while(flag) {
			flag = false;
			flag = controlDivided(page.getHeadControlForPage());
		}
	}
	
	public boolean controlDivided(iOSControl control) throws Exception{
		boolean flag = false;
		if(beModule(control)) flag = true;
		for(int i = 0; i < control.getSubControlList().size(); i++)
			if(controlDivided(control.getSubControlList().get(i))) flag = true;
		return flag;
	}
	
	public boolean beModule(iOSControl control){
		ArrayList<iOSControl> stack = new ArrayList<iOSControl>();
		stack.add(control);
		for(int i = 0; i < distance; i++) {
			ArrayList<iOSControl> newstack = new ArrayList<iOSControl>();
			for(int j = 0; j < stack.size(); j++) {
				if(stack.get(j).isBeModelhead()) continue;
				for(int k = 0; k < stack.get(j).getSubControlList().size(); k++)
					newstack.add(stack.get(j).getSubControlList().get(k));
			}
			if(newstack.size() == 0) return false;
			else stack = newstack;
		}
		for(int i = 0; i < stack.size(); i++)
			if(!stack.get(i).isBeModelhead() && !stack.get(i).beFunction())
				return false;
		if(control.isBeModelhead()) return false;
		control.setBeModelhead(true);
		return true;
	}
}
