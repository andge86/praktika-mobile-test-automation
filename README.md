# praktika-mobile-test-automation

## Tech stack:
Java + Appium + TestNG + Allure Reports + GitHub Actions CI

## Base characteristics:
1. POM with PageFactory
2. Detailed comments
3. Reporting with screenshots on failure
4. Soft assertions to be able to assert few things at once
5. Universal locators (could be used for translation tests)
6. Generic methods for age, gender, language selection

## Extra characteristics:
1. Framework has parallel execution support for remote runs (using device farms, browserstack, etc.)
2. CI execution with publishing report to GitHub Pages (needed .apk file to work properly)

### Note: please provide .apk file to make it working and showing Allure Report here: https://andge86.github.io/praktika-mobile-test-automation

## How to run locally:
1. Install appium2 (by "brew install appium") (node.js is also required) and uiautomator2 driver (by "appium driver install uiautomator2")
2. Do not forget to add ANDROID_HOME env variable
3. Launch appium core server by running "appium" command
4. Install Android studio and launch Android emulator (also install praktika app on the emulator)
5. Setup Maven and Java 21
6. Clone repository
7. In the root directory run "mvn clean test -DsuiteXmlFile=TestNG_Android.xml"
8. To open Allure Report install allure (by "brew install allure") and run "allure serve"
9. To run CI pipeline manually open GitHub repo page and go to Actions and choose "Java Appium CI". Please provide me .apk file to make complete execution available
10. To run CI pipeline on scheduled basis uncomment "schedule" in appium-android.yaml
11. Enjoy!

Allure Report looks like this locally:

<img width="1397" alt="Screenshot 2024-07-15 at 5 11 43 AM" src="https://github.com/user-attachments/assets/8ad44845-7e36-4430-8a5a-c2e8ace377d3">
<img width="1348" alt="Screenshot 2024-07-15 at 5 10 51 AM" src="https://github.com/user-attachments/assets/94bd7259-b8a1-455c-9347-e841515b65f9">

## Several bugs/issues noted during test automation (need to be discussed):
1. Too long loading after taping on "Get Started" button at the Start screen
2. User can tap "Continue" button without entering any name
3. On Languages page if you scroll down many languages have no flags
    

### Please let me know in case if any additional functionality is required
### Thank you!


