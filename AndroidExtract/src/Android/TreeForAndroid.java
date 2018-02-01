package Android;

import java.util.Map;

public class TreeForAndroid {
	ControlForAndroid[] tree=new ControlForAndroid[100];
	int top=0;
	public TreeForAndroid(){
	}
	public void push(ControlForAndroid element){
		tree[top]=element;
		top++;
	}
	public void pop(){
		top--;
	}
	public ControlForAndroid getRoot(){
		return tree[0];
	}
	public ControlForAndroid getPre(){
		return tree[top-1];
	}
	public boolean beEmpty(){
		if(top==0)return true;
		else return false;
	}
	public int getelementnum(){
		return top;
	}
}
