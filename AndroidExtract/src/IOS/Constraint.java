package IOS;

public class Constraint {
	String firstItem=null;
	String firstAttribute=null;
	String secondItem=null;
	String secondAttribute=null;
	String id=null;
	
	public void setFirstItem(String F){
		firstItem=F;
	}
	
	public void setFirstAttribute(String Fi){
		firstAttribute=Fi;
	}
	
	public void setSecondItem(String G){
		secondItem=G;
	}
	
	public void setSecondAttribute(String B){
		secondAttribute=B;
	}
	
	public void setID(String A){
		id=A;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("Constraint ");
		if(firstItem!=null)System.out.print(" firstItem:"+firstItem);
		if(firstAttribute!=null)System.out.print(" firstAttribute:"+firstAttribute);
		if(secondItem!=null)System.out.print(" secondItem:"+secondItem);
		if(secondAttribute!=null)System.out.print(" secondAttribute:"+secondAttribute);
		if(id!=null)System.out.print(" id:"+id);
		System.out.println();
	}
}
