package com.imbarpjy.Android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AndroidControl {
	ArrayList<AndroidControl> subControl=new ArrayList<AndroidControl>();
	String name = null;
	String contentDesc = null;
	String text = null;
	int id = 0;
	int x = 0, y = 0, width = 0, height = 0;
	boolean beTransformed = false;
	boolean clickable = false;
	boolean enabled = false;
	boolean beModelhead = false;
	
	public AndroidControl(int id) {
		this.id=id;
	}	
	public String getContentDesc() {
		return contentDesc;
	}
	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isBeTransformed() {
		return beTransformed;
	}
	public void setBeTransformed(boolean beTransformed) {
		this.beTransformed = beTransformed;
	}
	public boolean isClickable() {
		return clickable;
	}
	public void setClickable(boolean clickable) {
		this.clickable = clickable;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setSubControl(ArrayList<AndroidControl> subControl) {
		this.subControl = subControl;
	}	
	public void addSubControl(AndroidControl Control) {
		subControl.add(Control);
	}
	public ArrayList<AndroidControl> getSubControl(){
		return subControl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean beFunction() {
		if(subControl.size() == 0) return true;
		return false;
	}
	public boolean beModuled() {
		return beModelhead;
	}
	public void setModuled(boolean moduled) {
		beModelhead = moduled;
	}
	
	public void print(int num){
		for(int j=0;j<num;j++)
			System.out.print("    ");
		System.out.println(id+" "+name+" "+x+" "+y+" "+width+" "+height);
		for(int k=0;k<subControl.size();k++)
			subControl.get(k).print(num+1);
	}
}
