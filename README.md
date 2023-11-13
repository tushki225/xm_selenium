# Regression UI Testing


Github Repository - https://github.com/tushki225/xm_selenium.git


# Highlights of the framework
1. UI Automation tool - Selenium
2. Language - Java
3. Maven - Deployment and dependency tool
4. TestNg - Testing framework
5. Eclipse IDE preferred
6. POM (Page Object Model) design pattern followed

# Pre-requisites to install
1. Eclipse IDE for Java 2023 or other IDE (If executing via IDE)
2. Maven 3.9 or higher(If you want to execute tests through CLI)
3. Java 17 or higher
4. Latest TestNg from Eclipse Marketplace
5. Git Client(Not mandatory if using Eclipse IDE)
6. Chrome browser v119 (if using different browser version then change chrome driver in Project's driver folder but default driver included for mentioned version)

# Functional Test Scenarios covered as a part of the requirements
1. Test case as mentioned with maximum size of browser (Done)
2. Test case as mentioned with 1024*768 size of browser (60% done)
1. Test case as mentioned with 800*600 size of browser (0% done)


# Steps to execute	

1. Install Pre-requisites 
2. Clone the repository on your local machine using git	
	(https://github.com/tushki225/xm_selenium.git)
		
3. You can run the project in 2 different ways as mentioned below-
	
a) CLI. Navigate to project root folder in command prompt(For Windows and Terminal in MAC) and run 'mvn test'
	    
b) Eclipse. Make sure to have TestNg plugin added to Eclipse. Update project by right click pom.xml and click 'Update Project'. Then, right click testsuite.xml (testsuites-->testsuite.xml) and Run As--> TestNg Suite
	    
	    
# Troubleshooting steps		

1. Since, this project is developed on MAC, so there might be some issues related to path settings if you execute on Windows(although the capability has been added to framework to execute on Windows but its not tested on Windows), so if you face any issue o n Windows then you can modify the TestConfig.java (src/test/config folder)

2.  If you see any issue related to class path, then modify .classpath file in project root folder or from IDE.

3. You might face issue when executing on Windows, then please contact developer  

4. If you see any issue related to driver, then please change driver for MAC or Windows in driver folder