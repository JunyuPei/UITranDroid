package com.imbarpjy.Main;

import java.util.ArrayList;

import com.imbarpjy.Android.AndroidPagesForApp;
import com.imbarpjy.ModuleTransform.PageModuleTransForm;
import com.imbarpjy.iOS.iOSPagesForApp;
import com.imbarpjy.iOSPageDivided.iOSPageDivided;

public class Main {
	
	static int config_distance = 2;
	static int config_pagenumber = 20;
	static double config_error = 600;

	public static void main(String[] args) {		
		try {
			iOSPagesForApp iOSapp = new iOSPagesForApp("zhifubao_ios", config_pagenumber, "Ö§¸¶±¦");
			AndroidPagesForApp Androidapp = new AndroidPagesForApp("zhifubao_Android", config_pagenumber, "Ö§¸¶±¦");

			iOSPageDivided pageDivided = new iOSPageDivided(config_distance);

//			Androidapp.getAndroidPage(0).print();
			for(int i = 0; i < config_pagenumber; i++) {
				pageDivided.pageDivided(iOSapp.getiOSPage(i));
				new PageModuleTransForm(iOSapp.getiOSPage(i), Androidapp.getAndroidPage(i), config_error);
			}
			
			
			
//			SceneDivided divided=new SceneDivided();
//			divided.sceneDivided(iosControl);
//			ArrayList<ModelForIOS> models=divided.getModels();
//			
//			System.out.println(models.size());
//			
//			ModelCorrespondence modelCorrespondence=new ModelCorrespondence();
//			for(int i=0;i<models.size();i++){
//				modelCorrespondence.setAndroidList(androidControl);
//				modelCorrespondence.getCorrespondence(models.get(i).getControl());
//			}
			
//			modelCorrespondence.setAndroidList(androidControl.getSubControl().get(0));
//			modelCorrespondence.setModel(models.get(6));
//			modelCorrespondence.ModelExchange();
//			if(modelCorrespondence.modelBeCorrect())
//				modelCorrespondence.fprint();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
