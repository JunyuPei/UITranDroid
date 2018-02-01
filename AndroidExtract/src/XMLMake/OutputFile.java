package XMLMake;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import IOS.Color;
import IOS.ControlForIOS;
import ListExchange.AndroidList;
import ListExchange.ListRead;
import PageDivided.ModelForIOS;

public class OutputFile {
	
	ArrayList<ModelForIOS> models;
	FileWriter fw;
	ListRead listRead;
	int numofscrollView=0;
	
	int width=0; 
	
	public OutputFile(ArrayList<ModelForIOS> models,FileWriter fw) throws Exception{
		this.models=models;
		this.fw=fw;
		listRead=new ListRead();
	}
	
	public void OutputToFile() throws Exception{
		OutputList(listRead.Exchange(models.get(models.size()-1)),-1,0,0,0);
	}
	
	public void OutputList(AndroidList control,int left,int top,int father, int father_width) throws Exception{
		//father表示父容器的类型，0表示FrameLayout，1表示LinerLayout,2表示RelatedLayout
		//father_width表示父容器的宽度
		if(control==null||control.getControlForIOS()==null)return;
		System.out.println(control.getName()+" "+control.getID()+" "+control.getControlForIOS().getModelname()+" "+control.getControlForIOS().getName()+" "+control.getControlForIOS().getId());
		if(father==-1)width=(int)Double.parseDouble(control.getControlForIOS().getRect().getWidth());
		int leftnow=left,topnow=top;//left表示当前的左坐标
		if(control.getControlForIOS().getRect().getWidth()!=null){
			if((int)Double.parseDouble(control.getControlForIOS().getRect().getWidth())>width)
				width=(int)Double.parseDouble(control.getControlForIOS().getRect().getWidth());	
			if((left+(int)Double.parseDouble(control.getControlForIOS().getRect().getWidth())>width))
				leftnow=0;
		}
		if(control.getName().replace(" ", "").equals("FrameLayout")){
			fw.write("<FrameLayout"+
		            "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\"");
			if((int)Double.parseDouble(control.getControlForIOS().getRect().getWidth())==father_width)
				fw.write("\r\nandroid:layout_width=\"wrap_content\"");
			else
				fw.write("\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\"");
			fw.write("\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
			if(father==0||father==-1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
		            "\r\nandroid:layout_marginLeft=\""+control.getControlForIOS().getRect().getX()+"sp\"");
			else if(father==1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
					"\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getControlForIOS().getRect().getX())-leftnow)+"sp\"");
			for(int i=0;i<control.getControlForIOS().getColor().size();i++){
				if(control.getControlForIOS().getColor().get(i).getKey().equals("backgroundColor"))
					fw.write("\r\nandroid:background=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
			}
			fw.write(">\r\n");
			for(int i=0;i<control.getSubList().size();i++)
				OutputList(control.getSubList().get(i),leftnow,topnow,0,(int)Double.parseDouble(control.getControlForIOS().getRect().getWidth()));
			fw.write("</FrameLayout>\r\n");
		}
		if(control.getName().replace(" ", "").equals("RelativeLayout")){
			fw.write("<RelativeLayout"+
		            "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\"");
			if((int)Double.parseDouble(control.getControlForIOS().getRect().getWidth())==father_width)
				fw.write("\r\nandroid:layout_width=\"wrap_content\"");
			else
				fw.write("\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\"");
			fw.write("\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
			for(int i=0;i<control.getControlForIOS().getColor().size();i++){
				if(control.getControlForIOS().getColor().get(i).getKey().equals("backgroundColor"))
					fw.write("\r\nandroid:background=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
			}
			fw.write(">\r\n");
			for(int i=0;i<control.getSubList().size();i++)
				OutputList(control.getSubList().get(i),leftnow,topnow,2,(int)Double.parseDouble(control.getControlForIOS().getRect().getWidth()));
			fw.write("</RelativeLayout>\r\n");
		}
		if(control.getName().replace(" ", "").equals("LinearLayout")){
			fw.write("<LinearLayout"+
		            "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\"");
			if((int)Double.parseDouble(control.getControlForIOS().getRect().getWidth())==father_width)
				fw.write("\r\nandroid:layout_width=\"wrap_content\"");
			else
				fw.write("\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\"");
			fw.write("\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
			if(father==0||father==-1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
		            "\r\nandroid:layout_marginLeft=\""+control.getControlForIOS().getRect().getX()+"sp\"");
			else if(father==1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
					"\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getControlForIOS().getRect().getX())-leftnow)+"sp\"");
			fw.write("\r\nandroid:orientation=\"vertical\"");
			for(int i=0;i<control.getControlForIOS().getColor().size();i++){
				if(control.getControlForIOS().getColor().get(i).getKey().equals("backgroundColor"))
					fw.write("\r\nandroid:background=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
			}
			fw.write(">\r\n");
			for(int i=0;i<control.getSubList().size();i++){
				OutputList(control.getSubList().get(i),leftnow,topnow,1,(int)Double.parseDouble(control.getControlForIOS().getRect().getWidth()));
				if(control.getSubList().get(i).getControlForIOS().getRect().getWidth()!=null)
					leftnow=leftnow+(int)Double.parseDouble(control.getSubList().get(i).getControlForIOS().getRect().getWidth())+(int)Double.parseDouble(control.getSubList().get(i).getControlForIOS().getRect().getX());
			}
			fw.write("</LinearLayout>\r\n");
		}
		if(control.getName().replace(" ", "").equals("ScrollView")){
			fw.write("<ScrollView"+
		            "\r\nandroid:id=\"@+id/id"+numofscrollView+"\"");
			if((int)Double.parseDouble(control.getSubList().get(0).getControlForIOS().getRect().getWidth())==father_width)
				fw.write("\r\nandroid:layout_width=\"wrap_content\"");
			else
				fw.write("\r\nandroid:layout_width=\""+control.getSubList().get(0).getControlForIOS().getRect().getWidth()+"sp\"");
			fw.write("\r\nandroid:layout_height=\""+control.getSubList().get(0).getControlForIOS().getRect().getHeight()+"sp\"");
			if(father==0||father==-1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getSubList().get(0).getControlForIOS().getRect().getY()+"sp\""+
		            "\r\nandroid:layout_marginLeft=\""+control.getSubList().get(0).getControlForIOS().getRect().getX()+"sp\"");
			else if(father==1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
					"\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getSubList().get(0).getControlForIOS().getRect().getX())-leftnow)+"sp\"");
			fw.write(">\r\n");
			numofscrollView++;
			for(int i=0;i<control.getSubList().size();i++)
				OutputList(control.getSubList().get(i),leftnow,topnow,0,father_width);
			fw.write("</ScrollView>\r\n");
		}
		if(control.getName().replace(" ", "").equals("TextView")){
			fw.write("<TextView"+
                    "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\"");
			if(control.getControlForIOS().getRect().getWidth()!=null)
				fw.write("\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\"");
			else
				fw.write("\r\nandroid:layout_width=\"wrap_content\"");
			if(control.getControlForIOS().getRect().getHeight()!=null)
				fw.write("\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
			else
				fw.write("\r\nandroid:layout_height=\"16sp\"");
			if(father==0)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
                    "\r\nandroid:layout_marginLeft=\""+control.getControlForIOS().getRect().getX()+"sp\"");
			else if(father==1)
				fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
	                "\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getControlForIOS().getRect().getX())-leftnow)+"sp\"");
			for(int i=0;i<control.getControlForIOS().getColor().size();i++){
				if(control.getControlForIOS().getColor().get(i).getKey().equals("textColor"))
					fw.write("\r\nandroid:textColor=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
				if(control.getControlForIOS().getColor().get(i).getKey().equals("highlightedColor"))
					fw.write("\r\nandroid:textColorHighlight=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
			}
			if(control.getControlForIOS().getFontDescription()!=null)
				fw.write("\r\nandroid:textSize=\""+control.getControlForIOS().getFontDescription().getPointSize()+"sp\"");
			if(control.getControlForIOS().getTextAlignment()!=null&&control.getControlForIOS().getTextAlignment().equals("left"))
            	fw.write("\r\nandroid:gravity=\"left\"");
			if(control.getControlForIOS().getTextAlignment()!=null&&control.getControlForIOS().getTextAlignment().equals("center"))
            	fw.write("\r\nandroid:gravity=\"center\"");
			if(control.getControlForIOS().getTextAlignment()!=null&&control.getControlForIOS().getTextAlignment().equals("right"))
            	fw.write("\r\nandroid:gravity=\"right\"");          
            if(control.getControlForIOS().getText()!=null)
            	fw.write("\r\nandroid:text=\""+control.getControlForIOS().getText()+"\"");
            if(control.getControlForIOS().getFooterTitle()!=null)
            	fw.write("\r\nandroid:text=\""+control.getControlForIOS().getFooterTitle()+"\"");
            fw.write(" />\r\n");
		}
		if(control.getName().replace(" ", "").equals("Button")){
			fw.write("<Button"+
                    "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\""+
                    "\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\""+
                    "\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
            if(father==0)
        		fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
                    "\r\nandroid:layout_marginLeft=\""+control.getControlForIOS().getRect().getX()+"sp\"");
        	else if(father==1)
        		fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
        	        "\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getControlForIOS().getRect().getX())-leftnow)+"sp\"");
            if(control.getControlForIOS().getContentHorizontalAlignment()!=null&&control.getControlForIOS().getContentVerticalAlignment()!=null&&control.getControlForIOS().getContentHorizontalAlignment().equals("center")&&control.getControlForIOS().getContentVerticalAlignment().equals("center"))
            	fw.write("\r\nandroid:gravity=\"center\"");
            else if(control.getControlForIOS().getContentHorizontalAlignment()!=null&&control.getControlForIOS().getContentHorizontalAlignment().equals("center"))
            	fw.write("\r\nandroid:gravity=\"center_horizontal\"");
            else if(control.getControlForIOS().getContentVerticalAlignment()!=null&&control.getControlForIOS().getContentVerticalAlignment().equals("center"))
            	fw.write("\r\nandroid:gravity=\"center_vertical\"");
            for(int i=0;i<control.getControlForIOS().getStates().size();i++){
            	if(control.getControlForIOS().getStates().get(i).getKey().equals("normal")){
            		if(control.getControlForIOS().getStates().get(i).getBackgroundImage()!=null)
            			fw.write("\r\nandroid:background=\"@drawable/"+control.getControlForIOS().getStates().get(i).getBackgroundImage()+"\"");
            		else
            			fw.write("\r\nandroid:background=\"#0ffffff\"");
            		if(control.getControlForIOS().getStates().get(i).getImage()!=null){
            			fw.write("\r\nandroid:drawableLeft=\"@drawable/"+control.getControlForIOS().getStates().get(i).getImage()+"\"");
            			fw.write("\r\nandroid:paddingLeft=\"10sp\"");
            		}
            		if(control.getControlForIOS().getStates().size()!=0&&control.getControlForIOS().getStates().get(0).getTitle()!=null)
            			fw.write("\r\nandroid:text=\""+control.getControlForIOS().getStates().get(0).getTitle()+"\"");
            		for(int j=0;j<control.getControlForIOS().getStates().get(i).getColors().size();j++){
            			if(control.getControlForIOS().getStates().get(i).getColors().get(j).getKey().equals("titleColor"))
            				fw.write("\r\nandroid:textColor=\""+getColor(control.getControlForIOS().getStates().get(i).getColors().get(j))+"\"");	
            		}
            	}
            }
            
            fw.write(" />\r\n");
		}
		if(control.getName().replace(" ", "").equals("ImageView")){
			fw.write("<ImageView"+
                    "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\""+
                    "\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\""+
                    "\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
            if(father==0)
        		fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
                    "\r\nandroid:layout_marginLeft=\""+control.getControlForIOS().getRect().getX()+"sp\"");
            else if(father==1)
        		fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
        	        "\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getControlForIOS().getRect().getX())-leftnow)+"sp\"");
            if(control.getControlForIOS().getContentMode()!=null&&control.getControlForIOS().getContentMode().equals("left"))
                fw.write("\r\nandroid:layout_gravity=\"left\"");
            if(control.getControlForIOS().getContentMode()!=null&&control.getControlForIOS().getContentMode().equals("center"))
                fw.write("\r\nandroid:layout_gravity=\"center\"");
            if(control.getControlForIOS().getContentMode()!=null&&control.getControlForIOS().getContentMode().equals("scaleToFill"))
                fw.write("\r\nandroid:scaleType=\"fitXY\"");
			if(control.getControlForIOS().getImage()!=null&&control.getControlForIOS().getImage().contains(".png"))//control.getControlForIOS().getStates().get(i).getKey().equals("normal")&&
				fw.write("\r\nandroid:src=\"@drawable/"+control.getControlForIOS().getImage().split("\\.")[0]+"\"");
			else if(control.getControlForIOS().getImage()!=null)//control.getControlForIOS().getStates().get(i).getKey().equals("normal")&&
				fw.write("\r\nandroid:src=\"@drawable/"+control.getControlForIOS().getImage()+"\"");  
			else{
				for(int i=0;i<control.getControlForIOS().getStates().size();i++){
					if(control.getControlForIOS().getStates().get(i).getKey().equals("normal")){
						if(control.getControlForIOS().getStates().get(i).getBackgroundImage()!=null)
							fw.write("\r\nandroid:src=\"@drawable/"+control.getControlForIOS().getStates().get(i).getBackgroundImage()+"\"");
						if(control.getControlForIOS().getStates().get(i).getImage()!=null)
							fw.write("\r\nandroid:src=\"@drawable/"+control.getControlForIOS().getStates().get(i).getImage()+"\"");
					}
				}
            }
			if(control.getControlForIOS().getName().equals("switch "))
				fw.write("\r\nandroid:src=\"@drawable/switch\"");  
			fw.write(" />\r\n");
		}
		if(control.getName().replace(" ", "").equals("ProgressBar")){
			fw.write("<ProgressBar"+
                    "\r\nandroid:id=\"@+id/id"+control.getControlForIOS().getId()+"\""+
                    "\r\nandroid:layout_width=\""+control.getControlForIOS().getRect().getWidth()+"sp\""+
                    "\r\nandroid:layout_height=\""+control.getControlForIOS().getRect().getHeight()+"sp\"");
            if(father==0)
        		fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
                    "\r\nandroid:layout_marginLeft=\""+control.getControlForIOS().getRect().getX()+"sp\"");
            else if(father==1)
        		fw.write("\r\nandroid:layout_marginTop=\""+control.getControlForIOS().getRect().getY()+"sp\""+
        	        "\r\nandroid:layout_marginLeft=\""+((int)Double.parseDouble(control.getControlForIOS().getRect().getX())-leftnow)+"sp\"");
            if(control.getControlForIOS().getContentMode()!=null&&control.getControlForIOS().getContentMode().equals("left"))
                fw.write("\r\nandroid:layout_gravity=\"left\"");
            if(control.getControlForIOS().getContentMode()!=null&&control.getControlForIOS().getContentMode().equals("center"))
                fw.write("\r\nandroid:layout_gravity=\"center\"");
            if(control.getControlForIOS().getContentMode()!=null&&control.getControlForIOS().getContentMode().equals("scaleToFill"))
                fw.write("\r\nandroid:scaleType=\"fitXY\"");
            if(control.getControlForIOS().getHidden()!=null&&control.getControlForIOS().getHidden().equals("YES"))
                fw.write("\r\nandroid:visibility=\"visible\"");
			for(int i=0;i<control.getControlForIOS().getColor().size();i++){
				if(control.getControlForIOS().getColor().get(i).getKey().equals("color")){
					fw.write("\r\nandroid:startColor=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
					fw.write("\r\nandroid:centerColor=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
					fw.write("\r\nandroid:endColor=\""+getColor(control.getControlForIOS().getColor().get(i))+"\"");
				}
			} 
			fw.write(" />\r\n");
		}
		if(control.getName().replace(" ", "").startsWith("model")){
			int num=Integer.parseInt(control.getControlForIOS().getModelname().substring(5));
			OutputList(listRead.Exchange(models.get(num-1)),left,top,father,father_width);
		}
	}
	
	public String getColor(Color color){
		String Color_16_hex="#";
		int red=255,green=255,blue=255;
		if(color.getKey().equals("backgroundColor")){
			if(color.getWhite()==null||color.getAlpha()==null)return "#00ffffff";
			if(color.getWhite().equals("0.0")&&color.getAlpha().equals("0.0"))
				return "#ffffff";
			if(color.getWhite().equals("1")&&color.getAlpha().equals("0.0"))
				return "#000000";
			if(color.getWhite().equals("0.0")&&color.getAlpha().equals("1"))
				return "#0ffffff";
			if(color.getWhite().equals("1")&&color.getAlpha().equals("1"))
				return "#0000000";
		}
		if((color.getColorSpace()!=null&&(color.getColorSpace().equals("calibratedRGB")||color.getColorSpace().equals("deviceRGB")))||(color.getCustomColorSpace()!=null&&color.getCustomColorSpace().equals("sRGB"))){
			red=(int)(Double.parseDouble(color.getRed())*255);
			green=(int)(Double.parseDouble(color.getGreen())*255);
			blue=(int)(Double.parseDouble(color.getBlue())*255);
		}
		if(color.getColorSpace()!=null&&color.getColorSpace().equals("calibratedWhite")){
			double color_white=1-Double.parseDouble(color.getWhite());
			red=(int)(red*color_white);
			green=(int)(green*color_white);
			blue=(int)(blue*color_white);
		}
		if(red<16)
			Color_16_hex=Color_16_hex+"0"+Integer.toHexString(red);
		else
			Color_16_hex=Color_16_hex+Integer.toHexString(red);
		if(green<16)
			Color_16_hex=Color_16_hex+"0"+Integer.toHexString(green);
		else
			Color_16_hex=Color_16_hex+Integer.toHexString(green);
		if(blue<16)
			Color_16_hex=Color_16_hex+"0"+Integer.toHexString(blue);
		else
			Color_16_hex=Color_16_hex+Integer.toHexString(blue);
		return Color_16_hex;
	}
	
}
