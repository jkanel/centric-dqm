# Centric Data Quality Monitoring

Centric Data Quality Monitoring (DQM) is a  testing framework for comparing actual and expected datasets. The related Java project and source code is located at [centric-dqm-java](http://github.com/jkanel/centric-dqm-java).

**Compatible with Java Runtime Environment 1.6.0.45 (Oracle 6u45) and higher.**

## Framework Execution
The framework is an executable JAR file, ```com.centric.dqm.jar```.  This application manages scenario definition and test result data in a management database.

An example of execution is available in [```centric-dqm/jar_exec_win.bat```](https://github.com/jkanel/centric-dqm/blob/master/jar_exec_win.bat)

## Command Line Parameters
Several command line parameters are supported:

**```-t```** Comma-delimited list of tags.  Any scenarios whose tag list contains a match with the parameter list will be tested. Example: ```-t "TAG1,TAG2,ABCD"```...any scenario whose tag list contains either TAG1, TAG2 or ABCD will be tested.

**```-s```** Comma-delimited list of scenarios.  Any scenarios whose identifier (scenario_uid) is a match with the paramter list will be tested.  Example: ```-s "SCENARIO1,SCENARIO2,XYZ"```...all scenearios with an identifer of SCENARIO1, SCENARIO2 or XYZ will be tested.

**```-p```** Specifies days past which test cases will be purged from the system.  Not that while aged test cases are purged, the master test record will be preserved. Example: ```-p 30```...all tests whose test date is greater than 30 days old will have its corresponding test cases deleted from the management database.

If there are no tag **```-t```** or scenario **```-s```** command line parameters specified, the framework will test all active ```active_flag = "Y"``` scenarios.

## Management Database Properties File
The properties file, ```com.centric.dqm.properties```, specifies location and access to the DQM management database.   This file is located in the same directory as the executable JAR file.

The following code block shows contents of an example properties file:
```
driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
url=jdbc:sqlserver://localhost;databaseName=dqm_mgr
user=dqm_admin
password=123$dqm_admin_password
maxrows=0
```

* ```driver``` is the JDBC driver corresponding to the management database. **At this time only SQL Server is supported to host the management database.**
* ```url``` is the JDBC connection URL that specifies the server and database. 
* ```user``` is the database login for the management database.  **LDAP authenticated login is not yet supported. A database login with user name and password are required. This user must have DDL and read/write privileges on the management database**
* ```password``` is the corresponding password to access the management database.
* ```maxrows``` specifies the maximum number of rows allowed in a test resultset.  A zero (0) value indiciates no limit.
