package PageDivided;

import java.util.ArrayList;

import IOS.AutoresizingMask;
import IOS.Color;
import IOS.Connection;
import IOS.Constraint;
import IOS.ControlForIOS;
import IOS.Rect;

public class ModelForIOS {
	String name=null;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	ControlForIOS subcontrol=new ControlForIOS();
	
	public void setControl(ControlForIOS control){
		subcontrol=control;
	}
	
	public ControlForIOS getControl(){
		return subcontrol;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("  ");
		if(name!=null)System.out.println("Modelname:"+name);	
		subcontrol.print(num+1);
	}
}
