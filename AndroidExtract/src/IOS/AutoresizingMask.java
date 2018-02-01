package IOS;

public class AutoresizingMask {
	String key=null;
	String flexibleMaxX=null;
	String flexibleMaxY=null;
	
	public void setKey(String K){
		key=K;
	}
	
	public void setflexibleMaxX(String X){
		flexibleMaxX=X;
	}
	
	public void setflexibleMaxY(String Y){
		flexibleMaxY=Y;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("AutoresizingMask ");
		if(key!=null)System.out.print(" key:"+key);
		if(flexibleMaxX!=null)System.out.print(" flexibleMaxX:"+flexibleMaxX);
		if(flexibleMaxY!=null)System.out.print(" flexibleMaxY:"+flexibleMaxY);
		System.out.println();
	}

}
