package Main;

import java.io.FileWriter;
import java.util.ArrayList;

import IOS.IOSRead;
import IOS.ViewForIOS;
import ListExchange.AndroidList;
import ListExchange.ListRead;
import PageDivided.ModelForIOS;
import PageDivided.SceneDivided;
import XMLMake.OutputFile;

public class Main {

	public static void main(String[] args) {
		IOSRead a;
		try {
			a = new IOSRead();		
			ArrayList<ViewForIOS> views=a.getView();
//			views.get(4).print();
			ArrayList<ModelForIOS> models=new SceneDivided().sceneDivided(views.get(10));
//			views.get(2).print();
			for(int i=0;i<models.size();i++){
				models.get(i).print(0);
			}
	    	FileWriter fw = new FileWriter("xmlList.xml");	
			fw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"+
	"<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\r\n"+
	"xmlns:app=\"http://schemas.android.com/apk/res-auto\"\r\n"+
	"xmlns:tools=\"http://schemas.android.com/tools\"\r\n"+
	"android:id=\"@+id/content_main\"\r\n"+
	"android:layout_width=\"match_parent\"\r\n"+
	"android:layout_height=\"match_parent\"\r\n"+
	"android:paddingLeft=\"0sp\"\r\n"+
	"android:paddingTop=\"0sp\"\r\n"+
	"app:layout_behavior=\"@string/appbar_scrolling_view_behavior\"\r\n"+
	"tools:context=\"com.example.dell.myapplication4.MainActivity\">\r\n");
			OutputFile Output=new OutputFile(models,fw);
			Output.OutputToFile();
			fw.write("</FrameLayout>");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
