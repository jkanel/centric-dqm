# Centric Data Quality Monitoring

Centric Data Quality Monitoring (DQM) is a  testing framework for comparing actual and expected datasets. The related Java project and source code is located at [centric-dqm-java](http://github.com/jkanel/centric-dqm-java).

**NOTE: Compatible with Java Runtime Environment 1.6.0.45 (Oracle 6u45) and higher.**

## Framework Use
1. The framework is an executable JAR file.  An example of execution is available in [```centric-dqm/jar_exec_win.bat```](https://github.com/jkanel/centric-dqm/blob/master/jar_exec_win.bat)

2. Several command line parameters are supported:

* **```-t```** Comma-delimited list of tags.  Any scenarios whose tag list contains a match with the parameter list will be tested. Example: ```-t "TAG1,TAG2,ABCD"```

* **```-s```** Comma-delimited list of scenarios.  Any scenarios whose identifier (scenario_uid) is a match with the paramter list will be tested.  Example: ```-s "SCENARIO1,SCENARIO2,XYZ"```

* **```-p```** Specifies days past which test cases will be purged from the system.  Not that while aged test cases are purged, the master test record will be preserved. Example: ```-p 30```



## Extension Installation Options
### #1 - StarUML Extension Manager
0. Install Java 1.6 or higher. http://www.oracle.com/technetwork/java/javase/downloads/index.html
1. Open the StarUML application.
2. Select the menu ```Tools >> Extension Manager...```
3. Click the ```Install From Url...``` button.
4. In the ```Install Extension``` field, enter ```http://github.com/jkanel/staruml-infomodel/archive/master.zip``` and click the ```Install``` button.
5. The extension will automatically install.

### #2 - Manual Windows Installation
0. Install Java 1.6 or higher. http://www.oracle.com/technetwork/java/javase/downloads/index.html
1. Open Windows Explorer and navigate to ```C:\Users\{user}\AppData\Roaming\StarUML\extensions\user``` where ```{user}``` is your windows login user name.
2. Download the file http://github.com/jkanel/staruml-infomodel/archive/master.zip to your local drive.
3. Open the zip archive and extract the ```staruml-infomodel-master``` folder to the ```\extensions\user``` folder (see #1, above).
4. The extension is now installed.

## Customization
The following methods of customization are supported.

**NOTE**: All customizations should be made in the StarUML Extensions folder.  On Windows machines, this folder is located here:
     ```"C:\Users\{user}\AppData\Roaming\StarUML\extensions\user\com.centric.infomodel"```
The placeholder {user} should be replaced with your Windows account name.

1. **Xslt File**. You can alter the Xslt file ```centric.infomodel.xslt``` located located in the StarUML Extensions folder.  This file controls the generation of Html based on Xml derived from the StarUML project.
2. **CSS Style Sheet**. You can alter the CSS style sheet file ```centric.infomodel.css``` located in the StarUML Extensions resources subfolder.  This controls the colors, layout and rendering of the Html page.
3. **Company Logo**. The company logo appearing in the top-left corner of the Html page can be altered by replacing the ```logo.png``` file located in the StarUML Extensions resources subfolder. 
4. **StarUML Menu Behavior**.  The StarUML menu behavior can be altered in the ```main.js``` file located in the StarUML Extensions folder.  For each extension, the respective "main.js" file is loaded into StarUML memory on startup.


