package com.imbarpjy.ModuleTransform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.imbarpjy.Android.AndroidControl;
import com.imbarpjy.Android.AndroidPage;
import com.imbarpjy.iOS.iOSControl;
import com.imbarpjy.iOS.iOSPage;

public class PageModuleTransForm {
	iOSPage iOSpage;
	AndroidPage androidpage;
	double error;
	ControlTransForm controlTransForm;
	
	int file_number = 1;
	int iOS_flag = 1, Android_flag = 1;
	
	public PageModuleTransForm(iOSPage iOSpage, AndroidPage androidpage, double error) {
		this.iOSpage = iOSpage;
		this.androidpage = androidpage;
		this.error = error;
		controlTransForm = new ControlTransForm(iOSpage.getPageWidth(), iOSpage.getPageHeight(), androidpage.getPageWidth(), androidpage.getPageHeight(), error);
		functionBeTransformed(iOSpage.getHeadControlForPage());
		containerBeTransformed();
		printOutToFile();
	}
	
	public void functionBeTransformed(iOSControl iosControl){	
		if(iosControl.beFunction()){
			AndroidControl androidControl=controlTransForm.translateitem(iosControl, androidpage.getHeadControlForPage());
			if(androidControl != null) {
				iosControl.setRelatedAndroidId(androidControl.getId());
				androidControl.setBeTransformed(true);
			}

		}
		else
			for(int i = 0; i < iosControl.getSubControlList().size(); i++)
				functionBeTransformed(iosControl.getSubControlList().get(i));
	}
	
	public void containerBeTransformed(){
		for(int i = 0; i < 20; i++) {
			FunctionBack(iOSpage.getHeadControlForPage());
		}
	}
	
	public void FunctionBack(iOSControl iosControl) {
		if(iosControl.beFunction() || iosControl.getRelatedAndroidId() > 0) return;
		int i;
		for(i = 0; i < iosControl.getSubControlList().size(); i++) {
			if(iosControl.getSubControlList().get(i).getRelatedAndroidId() == 0)
				break;
		}
		if(i == iosControl.getSubControlList().size()) FindContainer(iosControl);
		for(i = 0; i < iosControl.getSubControlList().size(); i++) {
			FunctionBack(iosControl.getSubControlList().get(i));
		}
	}

	public void FindContainer(iOSControl iosControl) {
		AndroidControl android = androidpage.getParentControl(iosControl.getSubControlList().get(0).getRelatedAndroidId());
		while(true) {
			if(android == null || android.getId() == androidpage.getHeadControlForPage().getId()) break;
			int i;
			for(i = 0; i < iosControl.getSubControlList().size(); i++) {
				if(!AndroidContainId(iosControl.getSubControlList().get(i).getRelatedAndroidId(), android))
					break;
			}
			if(i == iosControl.getSubControlList().size()) {
				
				iosControl.setRelatedAndroidId(android.getId());
				if(iosControl.isBeModelhead()) android.setModuled(true);
				return;
			}
			android = androidpage.getParentControl(android.getId());
		}
	}
	
	public boolean AndroidContainId(int id, AndroidControl androidControl){
		for(int i = 0; i < androidControl.getSubControl().size(); i++){
			if(androidControl.getSubControl().get(i).getId() == id)
				return true;
			else if(AndroidContainId(id, androidControl.getSubControl().get(i)))
				return true;
		}
		return false;
	}
	
	public void printOutToFile() {
		if(iOSpage.getHeadControlForPage().isBeModelhead() && iOSpage.getHeadControlForPage().getRelatedAndroidId() > 0) fprint(iOSpage.getHeadControlForPage());
		for(int i = 0; i < iOSpage.getHeadControlForPage().getSubControlList().size(); i++)
			printOutToFile(iOSpage.getHeadControlForPage().getSubControlList().get(i));
	}
	
	public void printOutToFile(iOSControl iosControl) {
		if(iosControl.isBeModelhead() && iosControl.getRelatedAndroidId() > 0) fprint(iosControl);
		for(int i = 0; i < iosControl.getSubControlList().size(); i++)
			printOutToFile(iosControl.getSubControlList().get(i));
	}
	
	public void fprint(iOSControl iosControl){  	
		FileWriter Androidfw = null, iOSfw = null;
		iOS_flag = 1; Android_flag = 1;
		try {
			File file = new File("ControlCorrList/Android_module"+file_number+".txt");    
			while(file.exists()) {  
				file_number++;
				file = new File("ControlCorrList/Android_module"+file_number+".txt"); 
			}   
			Androidfw = new FileWriter("ControlCorrList/Android_module"+file_number+".txt");
			iOSfw = new FileWriter("ControlCorrList/IOS_module"+file_number+".txt");
			fAndroidprint(Androidfw, androidpage.getAndroidControl(iosControl.getRelatedAndroidId()));
			fiOSprint(iOSfw, iosControl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
            if (Androidfw != null) {
                try {
                	Androidfw.close();
                } catch (Exception e1) {
                }
            }
            if (iOSfw != null) {
                try {
                	iOSfw.close();
                } catch (Exception e1) {
                }
            }
        }
	}
	
	public void fAndroidprint(FileWriter fw, AndroidControl androidControl) throws IOException{
		if(androidControl == null ) return;
		fw.write(androidControl.getId() + " " + androidControl.getName() + " ");
		for(int i = 0; i < androidControl.getSubControl().size(); i++){
			if(i < androidControl.getSubControl().size() - 1)
				fw.write(androidControl.getSubControl().get(i).getId() + "|");
			else
				fw.write(androidControl.getSubControl().get(i).getId() + " ");
		}
		fw.write("\n");
		for(int i = 0; i < androidControl.getSubControl().size(); i++)
			fAndroidprint(fw, androidControl.getSubControl().get(i));
	}
	
	public void fiOSprint(FileWriter fw,iOSControl iosControl) throws IOException{
		if(iosControl.isBeModelhead() && iOS_flag != 1) {
			fw.write(iosControl.getId() + " " + "model\n");
			return;
		}
		else if(iosControl.isBeModelhead() && iOS_flag == 1) {
			fw.write(iosControl.getId() + " " + iosControl.getType() + " ");
			iOS_flag = 0;
		}
		else fw.write(iosControl.getId() + " " + iosControl.getType() + " ");
		if(iosControl.getSubControlList().size() == 0) fw.write("0" + " ");
		for(int i = 0; i < iosControl.getSubControlList().size(); i++){
			if(i < iosControl.getSubControlList().size() - 1)
				fw.write(iosControl.getSubControlList().get(i).getId() + "|");
			else
				fw.write(iosControl.getSubControlList().get(i).getId() + " ");
		}
		fw.write(iosControl.getRelatedAndroidId() + "\n");	
		for(int i = 0; i < iosControl.getSubControlList().size(); i++)
			fiOSprint(fw, iosControl.getSubControlList().get(i));
	}
}
