package IOS;

public class Color {
	String key=null;
	String red=null;
	String green=null;
	String blue=null;
	String alpha=null;
	String colorSpace=null;
	String customColorSpace=null;
	String white=null;
	
	public void setKey(String K){
		key=K;
	}
	
	public void setRed(String R){
		red=R;
	}
	
	public String getKey() {
		return key;
	}

	public String getRed() {
		return red;
	}

	public String getGreen() {
		return green;
	}

	public String getBlue() {
		return blue;
	}

	public String getAlpha() {
		return alpha;
	}

	public String getColorSpace() {
		return colorSpace;
	}
	public String getCustomColorSpace() {
		return customColorSpace;
	}

	public void setGreen(String G){
		green=G;
	}
	
	public void setBlue(String B){
		blue=B;
	}
	
	public void setAlpha(String A){
		alpha=A;
	}
	
	public void setCustomColorSpace(String C){
		customColorSpace=C;
	}
	
	public void setColorSpace(String C){
		colorSpace=C;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("Color ");
		if(key!=null)System.out.print(" key:"+key);
		if(red!=null)System.out.print(" red:"+red);
		if(green!=null)System.out.print(" green:"+green);
		if(blue!=null)System.out.print(" blue:"+blue);
		if(white!=null)System.out.print(" white:"+white);
		if(alpha!=null)System.out.print(" alpha:"+alpha);
		if(colorSpace!=null)System.out.print(" colorSpace:"+colorSpace);
		if(customColorSpace!=null)System.out.print(" customColorSpace:"+customColorSpace);
		System.out.println();
	}

	public String getWhite() {
		return white;
	}

	public void setWhite(String white) {
		this.white = white;
	}
}
