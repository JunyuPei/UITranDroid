package IOS;

import java.util.ArrayList;

public class State {
	String key=null;
	String image=null;
	String backgroundImage=null;
	String title=null;
	ArrayList<Color> colors=new ArrayList<Color>();
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public ArrayList<Color> getColors() {
		return colors;
	}
	public void addColor(Color color) {
		colors.add(color);
	}
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("State ");
		if(key!=null)System.out.print(" key:"+key);
		if(image!=null)System.out.print(" image:"+image);
		if(backgroundImage!=null)System.out.print(" backgroundImage:"+backgroundImage);
		if(title!=null)System.out.print(" title:"+title);
		System.out.println();
		for(int i=0;i<colors.size();i++)
			colors.get(i).print(num+1);	
	}
}
