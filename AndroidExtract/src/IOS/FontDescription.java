package IOS;

public class FontDescription {
	String key=null;
	String type=null;
	String pointSize=null;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPointSize() {
		return pointSize;
	}
	public void setPointSize(String pointSize) {
		this.pointSize = pointSize;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("FontDescription ");
		if(key!=null)System.out.print(" key:"+key);
		if(type!=null)System.out.print(" type:"+type);
		if(pointSize!=null)System.out.print(" pointSize:"+pointSize);
		System.out.println();
	}
}
