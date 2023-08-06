# OpenCart-Automation Tests
Automated tests are made up with Java programming language,Selenium,Maven and TestNG Framework. Below, you can find detailed instructions on how to run the project on your local machine. This project was built on the Windows operating system, and the instructions are based on that. For macOS users, the steps are very similar.
# Detailed Instructions for Running Tests on a Local Machine
First of all, you need to download Java JDK 17.0.7. Next, you should install the JDK you downloaded, and the most important thing is to add the JAVA_HOME variable to your System Variables and Path. You will also need some kind of integrated development environment. At the time the project was created, Eclipse was used (Eclipse IDE for Enterprise Java and Web Developers, version 4.27.0). The build automation tool that was used is Maven, and you will also need to download Maven 3.9.2 and add it to the system variable Path. After you have installed Java and Maven, there is an easy way to check if you did it correctly.

Go to the command prompt and type "java -version" and "mvn -version". If you did it correctly, versions of both Java and Maven should be printed on the console.

Depending on how you want to get the project from GitHub, you might have to configure Git on your local machine. If you don't want to spend the time on that, you can simply download it by clicking on Code -> Download ZIP. If you downloaded the project as a ZIP file, you will need to extract it to the desired location. If you want to use Git, go to the command prompt, place yourself in the desired directory, and execute this command: "git clone https://github.com/Raja-K-Tester/OpenCartSeleniumWithJava.git".

When you manage to download the project, open the IDE that you installed and open the project with it. Also, you don't need to download any kind of web driver since the WebDriverManager library will do everything for you (check the version of your browser that is installed, download the matching version (if unknown, it will download the latest available driver), and export the proper WebDriver Java environment variable for Selenium).

If you want to run tests from maven, simply right click on the project and select Run AS option->click Maven test.This command will freshly build the project and execute the test in one sequence. If you want to run it from your default terminal, open the command prompt, place yourself in the project directory, and run this command "mvn clean test". If you want to run tests in TestNG, then go to the test suites folder inside the project folder, right-click the xml you want to run, and then click Run As->TestNG Suite. It will run your test successfully.

There is a possibility to run tests in HEADLESS mode, but for that, you need to go to src/main/java->resources-> and click GlobalData.properties and change headless=true instead of false, and if you want to change browser then change browser=chrome/firefox/edge, give any one browser name, then only script will work.

For AutoIT script to run successfully open AutoIT folder click the autoit script and change the path pf the image file and then save the project.Next step is to right click the script and select compile script (x64) or (x86) depend on your system 32 or 64 bit.If 32 bit select compile script x86.Other option is to move image inside AutoIT folder to your desktop in my script i save it in desktop so it will work perfectly.

When the tests are finished, you can check your console the status of your tests. There is a test-output folder inside the project where you can find a html report, where you can exactly see which steps are passed and which ones are failed.The screenshots which are taken from the website are placed in the reports folder where you can verify the screenshots.Try to update all dependencies in the pom.xml file to the latest version if you face any issues, and then update the maven project.I tried my level best to make sure everything works fine on all the three browsers in case if anything not working as expected do some code modifications depend on the requirements.

Enjoy.

