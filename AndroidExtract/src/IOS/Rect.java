package IOS;

public class Rect {
	String key=null;
	String x="0";
	String y="0";
	String width=null;
	String height=null;
	
	public void setKey(String K){
		key=K;
	}
	
	public void setX(String X){
		x=X;
	}
	
	public void setY(String Y){
		y=Y;
	}
	
	public void setHeight(String H){
		height=H;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("Rect ");
		if(key!=null)System.out.print(" key:"+key);
		if(x!=null)System.out.print(" x:"+x);
		if(y!=null)System.out.print(" y:"+y);
		if(width!=null)System.out.print(" width:"+width);
		if(height!=null)System.out.print(" height:"+height);
		System.out.println();
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getKey() {
		return key;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}

	public String getHeight() {
		return height;
	}
}
