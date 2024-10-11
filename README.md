**UPDATE - UPGRADED TO SELENIUM VERSION 4**
# selenoid-example
A maven testng code to run your selenium scripts on Selenoid (Docker based Selenium hub). 

For Selenoid installation with Terraform, you may use the main.tf file in the resources folder.

The code consists of sample tests run on Chrome and Firefox on Selenoid

YouTube Playlist - https://youtube.com/playlist?list=PLKpa9fJrn0A07frfki3p5fMCQJ08aaaZ-


*  **Steps to setup Selenoid with Terraform**
1. Update the browser config and video path in the main.tf file.
2. Execute the init command
```
terraform init
```
3. Execute the plan command
```
terraform plan
```
4. Execute the apply command
```
terraform apply
```

* **mvn command to run a single test**
```
mvn -Dtest=SampleTest_Chrome test
```
* **mvn command to run multiple tests**
```
mvn -Dtest=SampleTest_Chrome,uiTests.FirefoxUITest test
```
*  **mvn command to run all tests in a package**
```
mvn -Dtest="uiTests.**" test
```
*  **mvn command to run all tests matching a group name**
```
mvn -Dtest="**" -Dgroups="chrome" test
```


