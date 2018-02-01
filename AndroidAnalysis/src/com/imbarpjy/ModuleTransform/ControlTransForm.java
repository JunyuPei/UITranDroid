package com.imbarpjy.ModuleTransform;

import java.util.ArrayList;

import com.imbarpjy.Android.AndroidControl;
import com.imbarpjy.iOS.iOSControl;

public class ControlTransForm {
	
	double x_contrast, y_contrast;
	double error;
	
	public ControlTransForm(int iOS_width, int iOS_height, int Android_width, int Android_height, double error) {
		x_contrast = iOS_width / Android_width;
		y_contrast = iOS_height / Android_height;
		this.error = error;
	}
	
	public AndroidControl translateitem(iOSControl iosControl,AndroidControl androidControlList){
		AndroidControl chooseControl = null; 
		double distance = Double.MAX_VALUE;
		if(androidControlList.beFunction()){			
			chooseControl = androidControlList;
			distance = 0;
			distance += Math.abs(iosControl.getX() - androidControlList.getX() * x_contrast);
			distance += Math.abs(iosControl.getY() - androidControlList.getY() * y_contrast);
			distance += Math.abs(iosControl.getWidth() - androidControlList.getWidth() * x_contrast);
			distance += Math.abs(iosControl.getHeight() - androidControlList.getHeight() * y_contrast);
		}

		for(int i = 0; i < androidControlList.getSubControl().size(); i++){
			AndroidControl androidControl = translateitem(iosControl, androidControlList.getSubControl().get(i));
			if(androidControl == null) continue;
			double distancethis = 0;
			distancethis += Math.abs(iosControl.getX() - androidControlList.getX() * x_contrast);
			distancethis += Math.abs(iosControl.getY() - androidControlList.getY() * y_contrast);
			distancethis += Math.abs(iosControl.getWidth() - androidControlList.getWidth() * x_contrast);
			distancethis += Math.abs(iosControl.getHeight() - androidControlList.getHeight() * y_contrast);
			if(distancethis < distance && !androidControl.isBeTransformed()){
				chooseControl = androidControl;
				distance = distancethis;
			}
		}
//		System.out.println(iosControl.getType()+" "+chooseControl.getName()+" "+distance);
		if(distance > error ) return null;
		return chooseControl;
	}
}
