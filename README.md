# FarmLeadQATechnicalExam

Please refer the file **Combyne_ManualTestCases_V1.0** excel sheet for manual test cases, **testng.xml** file for test suite, **CombyneLogin.java** for automation test scripts and **LoginPage.java** for Page objects.

Please install **Eclipse IDE** in your machine before you begin the steps outlined below.

**Setup Maven**:

1) From the top menu of Eclipse select Help -> Install new Software.
2) Click on the Add button. An add repository dialogue box will open, enter the following in the two text fields of this box.

Name: Maven
Location: http://download.Eclipse.org/technology/m2e/releases/

3) Maven will be displayed in the window. Click on the checkbox next to Maven Integration for Eclipse and click on next.

4) Please proceed with the next steps by clicking Next button

5) The license agreement page will be displayed on the next page. Click accept and restart the eclipse.



**Create Maven project**:

1) In Eclipse, Go to File-> New -> Project and choose Maven project.
2) Please specify artifact id and group id if the application prompts you to mention them.
3) After Maven project has been created, please open **pom.xml** file in the project hierarchy, and paste the content from the pom.xml file which I have attached in the repository and hit CTRL+S so that the required jar files get downloaded.
4 ) In project hirearchy, navigate to src/test/java / <package name> and import the two .java files I have attached in the repository.
5 ) Right click on the project, New-> File, and specify the file name as testng.xml. Once this is done, please paste the contents of the testng.xml file (I have attached this file in the repository) in to your testng.xml file.
  
6) Right click anywhere on the testng.xml file, Run As->Test NG suite and observe the results.
