### praktika-mobile-test-automation

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
Note: please provide .apk file to make it working and showing Allure Report here: https://andge86.github.io/praktika-mobile-test-automation

## How to run locally:
1. Install appium2 (by "brew install appium") (node.js is also required) and uiautomator2 driver (by "appium driver install uiautomator2")
2. Do not forget to add ANDROID_HOME env variable
3. Launch appium core server running "appium" command
4. Install Android studio and launch Android emulator
5. Setup Maven and Java 21
6. Clone repository
7. In the root directory run "mvn clean test -DsuiteXmlFile=TestNG_Android.xml"
8. To open Allure Report install allure (by "brew install allure") and run "allure serve"


