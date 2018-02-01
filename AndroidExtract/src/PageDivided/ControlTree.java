package PageDivided;

import Android.ControlForAndroid;
import IOS.ControlForIOS;

public class ControlTree {
	ControlForIOS[] controltree=new ControlForIOS[100];
	int top=0;
	
	public void push(ControlForIOS element){
		controltree[top]=element;
		top++;
	}
	public ControlForIOS pop(){
		top--;
		return controltree[top];
	}
	public ControlForIOS getRoot(){
		return controltree[0];
	}
	public ControlForIOS getParent(int i){
		if(top-1-i<0)return null;
		return controltree[top-1-i];
	}
	public boolean beEmpty(){
		if(top==0)return true;
		else return false;
	}
	public int getelementnum(){
		return top;
	}
}
