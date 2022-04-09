# EMI-Calculator-Appium
## Tools and Framework used:
- Selenium
- TestNG
- Appium
- Allure Reporting

## What I did:
- Open the EMI calculator app
- Navigate to the EMI calculator screen
- Input necessary fields 
- Click on calculate button
- Verify data from dataset

## How to run:
### Prerequisites: 
- JDK 8 or higher
- Configure GRADLE_HOME and set allure path
- Start Appium server
### Steps to run:
- clone the repo
- give this command in root directory
  ``` gradle clean test ```
- To generate report hit this command
  ``` allure generate allure-results --clean -o allure-report ```
  ``` allure serve allure-results ```
  
## Report

![2022-04-10_0-06-24](https://user-images.githubusercontent.com/48891202/162586718-1b40dbf1-1efd-4f97-a73d-f5de18599c32.png)

![2022-04-10_0-16-45](https://user-images.githubusercontent.com/48891202/162586711-93923f07-4d87-487c-948d-74faccb5faef.png)

![2022-04-10_0-17-09](https://user-images.githubusercontent.com/48891202/162586734-55aa28de-aeab-410c-9995-d1bd34174f37.png)

## Video

https://user-images.githubusercontent.com/48891202/162498666-1bfee545-7a61-4f8d-9307-ce1487dbb100.mp4




