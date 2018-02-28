# UITranDroid
UITrandroid is a transformation tool for UI transform from iOS project into Android project. For the moment, it can only work for iOS projects with Storyboard/xib files.

![](https://github.com/JunyuPei/UITranDroid/blob/master/overview.png) 
UITranDroid is formed with two parts: the first part MMG is used to collect learned pairs of modules and SFC is used to transform UI codes with the help of collected modules.

Running UITranDroid

Two parts of UITranDroid is Eclipse project and you can run the projects directly. The AndroidAnalysis is the first part and ControlCorrList is the output files storing the generated modules. The you should add the newly collected modules into the ControlList in AndroidExtract and run the AndroidExtract. There several storyboard files can be found in the root directory.

Some example UI pages can be showed as follows:
![](https://github.com/JunyuPei/UITranDroid/blob/master/examples.png) 
